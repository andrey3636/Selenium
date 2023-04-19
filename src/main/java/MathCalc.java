import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class MathCalc {
    ChromeDriver driver;
    @Before

    public void setUp(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\MR Popovics\\OneDrive\\Рабочий стол\\Drive\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://suninjuly.github.io/get_attribute.html");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    public double funcCalc(double x) {
        return log(abs(12*sin(x)));

    }


    @Test
    public void calculationTest() throws InterruptedException {
        double result = 0;
        WebElement treasure = driver.findElement(By.id("treasure"));
        System.out.println(treasure.getText());
        System.out.println(parseDouble(treasure.getAttribute("valuex")));
        result = funcCalc(parseDouble(treasure.getAttribute("valuex")));
        System.out.println("Result:" + result);
        WebElement answerInputField = driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result));

        WebElement checkbox = driver.findElement(By.id("robotCheckbox"));
        checkbox.click();
        WebElement checkbox1 = driver.findElement(By.id("robotsRule"));
        checkbox1.click();
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
//        sleep(10000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.getText();
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));




    }
}
