import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.FileStore;
import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class Registration {
    ChromeDriver driver;
    @Before

    public void setUp(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\MR Popovics\\OneDrive\\Рабочий стол\\Drive\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://suninjuly.github.io/registration1.html");
    }
    @After
    public void tearnDown(){
        driver.quit();
    }
    @Test
    public void placeholerTest(){
        String expectedFirstNamePlaceholder = "Input your first name";
        WebElement firstNameInputField = driver.findElement(By.cssSelector("input[placeholder='Input your first name']"));
        assertEquals("Placeholder has not text:" + expectedFirstNamePlaceholder, expectedFirstNamePlaceholder,
                firstNameInputField.getAttribute("placeholder"));
        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        assertEquals("Input your last name",lastNameInputField.getAttribute("placeholder"));
        WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        assertEquals("Input your email",emailInputField.getAttribute("placeholder"));
        WebElement phoneInputField = driver.findElement(By.cssSelector("[placeholder='Input your phone:']"));
        assertEquals("Input your phone:",phoneInputField.getAttribute("placeholder"));
        WebElement addressInputField = driver.findElement(By.cssSelector("[placeholder='Input your address:']"));
        assertEquals("Input your address:",addressInputField.getAttribute("placeholder"));
    }

@Test
    public void sucessfulRegAllFields() throws InterruptedException {
    WebElement firstNameInputField = driver.findElement(By.cssSelector("input[placeholder='Input your first name']"));

    firstNameInputField.sendKeys("John");
    WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));

    lastNameInputField.sendKeys("Bright");
    WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder='Input your email']"));

    emailInputField.sendKeys("andrey@gmail.com");
    WebElement phoneInputField = driver.findElement(By.cssSelector("[placeholder='Input your phone:']"));

    phoneInputField.sendKeys("+491556464747");
    WebElement addressInputField = driver.findElement(By.cssSelector("[placeholder='Input your address:']"));

    addressInputField.sendKeys("Dresden Leipziger str 98");
    sleep(10000);




    WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
    submitButton.click();
//    sleep(10000);
    WebElement headerSuccess = driver.findElement(By.tagName("h1"));
    assertEquals("Congratulations! You have successfully registered!", headerSuccess.getText());

    assertTrue(headerSuccess.getText().contains("Congratulations!"));

    System.out.println(driver.getCurrentUrl());

    assertTrue(driver.getCurrentUrl().contains("registration_result"));
//    sleep(10000);
    }

    @Test
    public void withoutFirstName(){
        WebElement lastNameInputFiled =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));

        lastNameInputFiled.sendKeys("Bright");
        //email, phone, address
        WebElement emailInputFiled =
                driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputFiled.sendKeys("jbright@gmail.com");
        WebElement phoneInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your phone:']"));
        phoneInputField.sendKeys("423523576");
        WebElement addressInputFiled =
                driver.findElement(By.cssSelector("[placeholder='Input your address:']"));
        addressInputFiled.sendKeys("Hdfgsgjdsgh");
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
        // sleep(2000);
        submitButton.click();
        WebElement firstNameInputFiled =
                driver.findElement(By.cssSelector("input[placeholder='Input your first name']"));
        assertTrue(firstNameInputFiled.getAttribute("validationMessage").contains("Заполните это поле"));
    }

    @Test
    public void withoutLastName() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("Andrey");
        WebElement emailInputFiled = driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputFiled.sendKeys("andrey@gmail.com");
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        assertEquals("Заполните это поле.",lastNameInputField.getAttribute("validationMessage"));

    }

    @Test
    public void withoutEmail() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("Andrey");
        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Popovics");
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        assertEquals("Заполните это поле.",emailInputField.getAttribute("validationMessage"));
    }

    @Test
    public void invalidedEmail() {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("Andrey");
        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Popovics");
        WebElement emailInputFiled = driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputFiled.sendKeys("andreygmail.com");
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement headerSuccsess = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!",headerSuccsess.getText());
    }

    @Test
    public void successRegWithSpaceFields(){
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys(" ");
        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys(" ");
        WebElement emailInputFiled = driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputFiled.sendKeys(" ");
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebElement headerSuccsess = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!",headerSuccsess.getText());
        assertTrue(headerSuccsess.getText().contains("Congratulations!"));
    }

    }




