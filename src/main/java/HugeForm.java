import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HugeForm {
    ChromeDriver driver;
    @Before

    public void setUp(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\MR Popovics\\OneDrive\\Рабочий стол\\Drive\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://suninjuly.github.io/huge_form.html");
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void allFields() throws InterruptedException {
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
        for (WebElement field : inputFields) {
            field.sendKeys("sdgdgdsgf");
        }
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.getText();
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

        // " Congrats, you've passed the task!"


    }
}

