package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        WebElement validUserName = driver.findElement(By.xpath("//input[@type='text']"));
        //Send Valid Username to username field
        validUserName.sendKeys("Bella-shah8");
        WebElement validPassword = driver.findElement(By.xpath("//input[@type='password']"));
        // Send valid password to Password field
        validPassword.sendKeys("Bella1234");
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        //This is from requirement
        String expectedMessage = "Accounts Overview";
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualMessage = actualMessageElement.getText();
        Assert.assertEquals("Not a valid Message : ", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        WebElement invalidUserName = driver.findElement(By.xpath("//input[@type='text']"));
        //Send invalid Username to username field
        invalidUserName.sendKeys("Bella66");
        WebElement invalidPassword = driver.findElement(By.xpath("//input[@type='password']"));
        // Send invalid password to Password field
        invalidPassword.sendKeys("abcd123");
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        //This is from requirement
        String expectedMessage = "The username and password could not be verified.";
        WebElement actualMessageElement = driver.findElement(By.xpath("//p[@class='error']"));
        String actualMessage = actualMessageElement.getText();
        //Validate actual and expected Message
        Assert.assertEquals("Not a valid Message : ", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Find Element of userName field
        WebElement validUserName = driver.findElement(By.xpath("//input[@type='text']"));
        validUserName.sendKeys("Bella-shah8");
        //Find Element of Password field
        WebElement validPassword = driver.findElement(By.xpath("//input[@type='password']"));
        validPassword.sendKeys("Bella1234");
        //Find Login element and click on it
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        //Find Logout element and click on it
        WebElement logout = driver.findElement(By.xpath("//a[@href='/parabank/logout.htm']"));
        logout.click();
        //This is from requirement
        String expectedMessage = "Customer Login";
        WebElement actualMessageElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualMessage = actualMessageElement.getText();
        //Validate actual and expected Message
        Assert.assertEquals("Not a valid Message : ", expectedMessage, actualMessage);

    }

    @After
    //close the driver
    public void tearDown() {
        closeBrowser();
    }

}


