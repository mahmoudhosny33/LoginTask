package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserActions;

public class LoginPage {

    WebDriver driver;

    /*********** Elements Locators ***********/

    By userNameTextField = By.xpath("//input[@id='user-name']");
    By passwordTextField = By.xpath("//input[@id='password']");

    By loginButton = By.xpath("//input[@type='submit']");

    By errorMessage=By.tagName("h3");


    /*********** page Constructor**************/
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /************** Page Functions ****************/


    public void enterUserNameAndPassword(String userName, String password) {
        BrowserActions.sendKey(driver, userNameTextField, userName);
        BrowserActions.sendKey(driver, passwordTextField, password);
    }

    public void clickOnLoginButton() {
        BrowserActions.clickButton(driver, loginButton);
    }
    public String getErrorMessage() {
        return BrowserActions.getText(driver, errorMessage);
    }

}
