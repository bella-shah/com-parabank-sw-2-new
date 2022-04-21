package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseurl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        // register name link and click on register link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        //This message from requirement
        String expectedMessage = "Signing up is easy!";
        String actualMessage = driver.findElement(By.xpath("//h1[@class='title']")).getText();

        //Validate actual and expected message h1 class="title" xpath="1">
        Assert.assertEquals("Error Message Not Displayed", expectedMessage, actualMessage);
    }

    @Test
    public void verifyShouldRegisterAccountsSuccessfully() {
        //find log in link and click on login link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        // find the first name and enter first name
        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        firstName.sendKeys("Bella");
        // find the last name and enter last name
        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Shah");
        //Find the address and enter the address
        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys("54 Ealing Road");
        // find the city and enter the city name
        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.sendKeys("Wembley");
        // find the state name and enter the state name
        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("Middlesex");
        // find the zip code and enter the zip code
        WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
        zipCode.sendKeys("HP20 1DA");
        //find the phone number and enter the phone number
        WebElement phoneNumber = driver.findElement(By.id("customer.phoneNumber"));
        phoneNumber.sendKeys("07939373398");
        //find the ssn number end enter the ssn number
        WebElement ssn = driver.findElement(By.id("customer.ssn"));
        ssn.sendKeys("AA-12-34-55-B");
        //find the username and enter the username
        WebElement username = driver.findElement(By.id("customer.username"));
        username.sendKeys("Bella-shah8");
        //find the password field and enter the password
        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys("Bella1234");
        //find the confirm password and enter the confirm password
        WebElement confirmPassword = driver.findElement(By.id("repeatedPassword"));
        confirmPassword.sendKeys("Bella1234");
        //find the register field and click on register field
        WebElement registerBtn = driver.findElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        registerBtn.click();
        //This message from requirement
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        WebElement actualMessageElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println("Actual Message : " + actualMessage);

        //Validate actual and expected message
        Assert.assertEquals("Cannot Register", expectedMessage, actualMessage);
    }

    @After
    //close the driver
    public void tearDown() {
        closeBrowser();
    }

}

