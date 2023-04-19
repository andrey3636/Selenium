import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Cats {
    ChromeDriver driver;
@Before

    public void setUp(){



        System.setProperty("webdriver.chrome.driver","C:\\Users\\MR Popovics\\OneDrive\\Рабочий стол\\Drive\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("http://suninjuly.github.io/cats.html");
    }
    @Test

    public void checkHeaderText() {

        WebElement header = driver.findElement(By.tagName("h1"));
        assertEquals("Cat memes", header.getText());
    }
    @Test
    public void TimeOfLastCat() {

        WebElement timeOfLAstCat = driver.findElement(By.xpath("//div[@class=\"col-sm-4\"][6]//small"));
        assertEquals("9 mins",timeOfLAstCat.getText());

    }
@Test
    public void checkCardsQuantity(){
        List<WebElement> cards = driver.findElements(By.xpath("//div[@class='col-sm-4']"));
        System.out.println(cards.size());

        assertEquals(6, cards.size());

    }
    @Test
    public void editButtonSecindCatIsDisplayed() {
    WebElement editBtnScndCat = driver.findElement(By.xpath("(//div[@class='col-sm-4'][2]//button)[2]"));
    assertTrue(editBtnScndCat.isDisplayed());

    }

    @Test
    public void allCardsAreDisplayed(){
        List<WebElement> cards =
                driver.findElements(By.className("col-sm-4"));
   /*     for (int i=0; i<cards.size();i++){
            assertTrue(cards.get(i).isDisplayed());
        }*/
        for (WebElement card : cards) {
            assertTrue(card.isDisplayed());
        }
        //cards.forEach(card->assertTrue(card.isDisplayed()));
    }

    @After
    public void tearnDown(){
        driver.quit();
    }
}