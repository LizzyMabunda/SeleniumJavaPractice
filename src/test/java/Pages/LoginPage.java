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
    @FindBy(id = "practice-header")
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

    public void loginDetails(String EmailAddress, String Password) {
        emailField_id.sendKeys(EmailAddress);
        passwordField_id.sendKeys(Password);
        loginButton_id.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(practiceHeading_id));
        practiceHeading_id.isDisplayed();
    }
    public void validatePracticeTabsAreDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(practiceTabs_id));
        practiceTabs_id.isDisplayed();
        logoutButton_id.click();
    }

    public void clickOnWebAutomationButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(webAutomationBtn_id));
        webAutomationBtn_id.click();
    }
    public void validateInvalidLoginDetailsErr() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println("Invalid login details Error message is: " + alertMessage);
        alert.accept();
    }
    public void trimSpaceLogin(String EmailAddress, String Password) throws InterruptedException {
        emailField_id.sendKeys(EmailAddress.trim());
        passwordField_id.sendKeys(Password.trim());
        System.out.println("Trimmed Email Address: " + EmailAddress);
        System.out.println("Trimmed Password: " + Password);
        loginButton_id.click();
        Thread .sleep(5000);

    }
    public void switchTab(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(curriculumButton_id));
        curriculumButton_id.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(curriculumHeading_id));
        curriculumHeading_id.isDisplayed();
    }
    public void switchBackToLearningMaterialTab(String EmailAddress, String Password){
        learningMaterialButton_id.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOf(LoginScreenHeading_id));
        emailField_id.sendKeys(EmailAddress);
        passwordField_id.sendKeys(Password);
        loginButton_id.click();
    }
    public void clickLogoutButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOf(logoutButton_id));
        logoutButton_id.click();
    }
    public void clickSignUpToggle() {
        signUpToggle_id.click();
    }

}