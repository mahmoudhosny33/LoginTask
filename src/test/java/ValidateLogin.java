import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class ValidateLogin extends BaseTest {


    @Test
    public void enterValidData() {

        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUserNameAndPassword("standard_user","secret_sauce");
        loginPage.clickOnLoginButton();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        softAssert.assertAll();
    }

    @Test
    public void leaveUesrNameFieldEmpty() {

        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUserNameAndPassword("","secret_sauce");
        loginPage.clickOnLoginButton();
        softAssert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
        softAssert.assertAll();
    }

    @Test
    public void leavePasswordFieldEmpty() {

        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUserNameAndPassword("standard_user","");
        loginPage.clickOnLoginButton();
        softAssert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required");
        softAssert.assertAll();
    }


    @Test
    public void enterRejectedUserName() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUserNameAndPassword("mahmoud","Mahmoud");
        loginPage.clickOnLoginButton();
        softAssert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
        softAssert.assertAll();
    }

    }
