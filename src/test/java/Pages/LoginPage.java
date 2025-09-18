package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage{

    @FindBy(id="login-heading")
    WebElement LoginScreenHeading_id;
    @FindBy(id="login-email")
    WebElement emailField_id;
    @FindBy(id="login-password")
    WebElement passwordField_id;
    @FindBy(id="login-submit")
    WebElement loginButton_id;
    @FindBy(id="tab-btn-web")
    WebElement webAutomationBtn_id;


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void validateLoginScreenHeading() {
        LoginScreenHeading_id.isDisplayed();
    }
    public void enterEmailAddress(String EmailAddress) {
        emailField_id.sendKeys(EmailAddress);
    }
    public void enterPassword(String Password) {
        passwordField_id.sendKeys(Password);
    }
    public void clickLoginButton() {
        loginButton_id.click();
    }
    public void loginErrorMessageIsDisplayed() {
        Alert alert =driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert message: " + alertText);

    }
}