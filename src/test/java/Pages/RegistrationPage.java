package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage extends LoginPage{
        WebDriver driver;


        @FindBy(id = "registration-heading")
        WebElement registrationScreenHeading_id;
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
        @FindBy(id ="login-toggle")
        WebElement loginHereButton_id;

        public RegistrationPage(WebDriver driver) {
            super(driver);
            this.driver = driver;
        }
        public void validateRegistrationScreenHeading() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(registrationScreenHeading_id));
            registrationScreenHeading_id.isDisplayed();
        }
        public void captureRegistrationDetails(String FirstName,String LastName,String RegisterEmail,String RegisterPassword,String RegisterConfirmPassword) {
            firstNameField_id.sendKeys(FirstName);
            lastNameField_id.sendKeys(LastName);
            registerEmailField_id.sendKeys(RegisterEmail);
            registerPasswordField_id.sendKeys(RegisterPassword);
            registerConfirmPasswordField_id.sendKeys(RegisterConfirmPassword);
            CreateAccountButton_id.click();
        }
        public void passwordMisMatchRegistrationError() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Passwords do not match!")) {
                System.out.println("Alert message is correct: " + alertText);
            } else {
                System.out.println("Alert message is incorrect: " + alertText);
            }
            alert.accept();
        }
    public void passwordLengthRegistrationError(String RegisterPassword, String RegisterConfirmPassword) {
        registerPasswordField_id.clear();
        registerPasswordField_id.sendKeys(RegisterPassword);
        registerConfirmPasswordField_id.clear();
        registerConfirmPasswordField_id.sendKeys(RegisterConfirmPassword);
        CreateAccountButton_id.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (alertText.equals("Password must be at least 8 characters long")) {
            System.out.println("Alert message is correct: " + alertText);
        } else {
            System.out.println("Alert message is incorrect: " + alertText);
        }
        alert.accept();
    }
        public void invalidEmailRegistrationError(String RegisterEmail, String RegisterPassword, String RegisterConfirmPassword) {
            registerEmailField_id.clear();
            registerEmailField_id.sendKeys(RegisterEmail);
            registerPasswordField_id.clear();
            registerPasswordField_id.sendKeys(RegisterPassword);
            registerConfirmPasswordField_id.clear();
            registerConfirmPasswordField_id.sendKeys(RegisterConfirmPassword);
            CreateAccountButton_id.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Please enter a valid email address")) {
                System.out.println("Alert message is correct: " + alertText);
            } else {
                System.out.println("Alert message is incorrect: " + alertText);
            }
            alert.accept();
        }
        public void successfulRegistration(String FirstName,String LastName,String RegisterEmail,String RegisterPassword,String RegisterConfirmPassword) throws InterruptedException {
            registerEmailField_id.clear();
            registerEmailField_id.sendKeys(RegisterEmail);
            firstNameField_id.clear();
            firstNameField_id.sendKeys(FirstName);
            lastNameField_id.clear();
            lastNameField_id.sendKeys(LastName);
            registerPasswordField_id.clear();
            registerPasswordField_id.sendKeys(RegisterPassword);
            registerConfirmPasswordField_id.clear();
            registerConfirmPasswordField_id.sendKeys(RegisterConfirmPassword);
            CreateAccountButton_id.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.equals("Registration successful! Please login with your credentials.")) {
                System.out.println("Alert message is correct: " + alertText);
            } else {
                System.out.println("Alert message is incorrect: " + alertText);
            }
            alert.accept();
            Thread .sleep(3000);
            emailField_id.clear();

        }
        public void clickLoginHere() {
            loginHereButton_id.click();
        }

}
