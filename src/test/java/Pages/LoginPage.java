package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage{
    WebDriver driver;

    @FindBy(id = "login-heading")
    WebElement LoginScreenHeading_id;
    @FindBy(id = "login-email")
    WebElement emailField_id;
    @FindBy(id = "signup-toggle")
    WebElement signUpToggle_id;
    @FindBy(id = "register-firstName")
    WebElement firstNameField_id;
    @FindBy(id = "register-lastName")
    WebElement lastNameField_id;
    @FindBy(id = "register-email")
    WebElement registerEmailField_id;
    @FindBy(id = "register-password")
    WebElement registerPasswordField_id;
    @FindBy(id = "register-confirmPassword")
    WebElement registerConfirmPasswordField_id;
    @FindBy(id = "register-submit")
    WebElement CreateAccountButton_id;
    @FindBy(id = "login-password")
    WebElement passwordField_id;
    @FindBy(id = "login-submit")
    WebElement loginButton_id;
    @FindBy(id = "practice-tabs")
    WebElement practiceTabs_id;
    @FindBy(id = "tab-btn-web")
    WebElement webAutomationBtn_id;
    @FindBy(id ="logout-button")
    WebElement logoutButton_id;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateLoginScreenHeading() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(LoginScreenHeading_id));
        LoginScreenHeading_id.isDisplayed();
    }
    public void clickSignUpToggle() {
        signUpToggle_id.click();
    }
    public void signUpNewUser(String FirstName,String LastName,String RegisterEmail,String RegisterPassword,String RegisterConfirmPassword) {
        firstNameField_id.sendKeys(FirstName);
        lastNameField_id.sendKeys(LastName);
        registerEmailField_id.sendKeys(RegisterEmail);
        registerPasswordField_id.sendKeys(RegisterPassword);
        registerConfirmPasswordField_id.sendKeys(RegisterConfirmPassword);
    }
    public void clickCreateAccountButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(CreateAccountButton_id));
        CreateAccountButton_id.click();
    }
    public void enterEmailAddress(String EmailAddress) {
        emailField_id.sendKeys(EmailAddress);
    }

    public void enterPassword(String Password) {
        passwordField_id.sendKeys(Password);
    }

    public void validateExistingUserSignUpError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

    }
    public void loginDetails(String EmailAddress, String Password) {
        enterEmailAddress(EmailAddress);
        enterPassword(Password);
        loginButton_id.click();
    }
    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(LoginScreenHeading_id));
        loginButton_id.click();
    }
    public void validatePracticeTabsAreDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(practiceTabs_id));
        practiceTabs_id.isDisplayed();
    }
    public void clickLogoutButton() {
       new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOf(logoutButton_id));
        logoutButton_id.click();
    }
    public void validateInvalidLoginDetailsErr() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println("Alert message is: " + alertMessage);
        alert.accept();
    }

}