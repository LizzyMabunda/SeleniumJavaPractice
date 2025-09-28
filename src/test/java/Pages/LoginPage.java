package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends HomePage{
    WebDriver driver;

    @FindBy(id = "login-heading")
    WebElement LoginScreenHeading_id;
    @FindBy(id = "signup-toggle")
    WebElement signUpToggle_id;
    @FindBy(id = "login-email")
    WebElement emailField_id;
    @FindBy(id = "login-password")
    WebElement passwordField_id;
    @FindBy(id = "login-submit")
    WebElement loginButton_id;
    @FindBy(id = "practice-heading")
    WebElement practiceHeading_id;
    @FindBy(id = "practice-tabs")
    WebElement practiceTabs_id;
    @FindBy(id = "tab-btn-web")
    WebElement webAutomationBtn_id;
    @FindBy(id ="logout-button")
    WebElement logoutButton_id;
    @FindBy(id = "nav-btn-curriculum")
    WebElement curriculumButton_id;
    @FindBy(id = "curriculum-heading")
    WebElement curriculumHeading_id;


    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void validateLoginScreenHeading() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOf(LoginScreenHeading_id));
        LoginScreenHeading_id.isDisplayed();
    }

    public void loginValidCredentials(String EmailAddress, String Password) {
        emailField_id.sendKeys(EmailAddress);
        passwordField_id.sendKeys(Password);
        loginButton_id.click();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOf(practiceTabs_id));
        practiceTabs_id.isDisplayed();

    }
    public void validLogin(String EmailAddress, String Password) {
        emailField_id.sendKeys(EmailAddress);
        passwordField_id.sendKeys(Password);
        loginButton_id.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOf(practiceHeading_id));
        practiceHeading_id.isDisplayed();
    }
    public void invalidPassword(String EmailAddress, String Password) {
        emailField_id.sendKeys(EmailAddress);
        passwordField_id.sendKeys(Password);
        loginButton_id.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println("Invalid login details Error message is: " + alertMessage);
        alert.accept();
    }
    public void trimSpaceLogin(String EmailAddress, String Password)  {
        emailField_id.sendKeys(EmailAddress);
        passwordField_id.sendKeys(Password);
        loginButton_id.click();

    }
    public void switchTabThenBack(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOf(curriculumButton_id));
        curriculumButton_id.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOf(curriculumHeading_id));
        curriculumHeading_id.isDisplayed();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOf(learningMaterialButton_id));
        learningMaterialButton_id.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOf(LoginScreenHeading_id));
        LoginScreenHeading_id.isDisplayed();

    }
    public void clickWebAutomationButton() {
        webAutomationBtn_id.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOf(webAutomationBtn_id));
    }
    public void clickLogoutButton() {
        logoutButton_id.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOf(LoginScreenHeading_id));
    }
    public void clickSignUpToggle() {
        signUpToggle_id.click();
    }

}