package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import Pages.WebAutomationAdvancedPage;
import Utils.BrowserFactory;
import Utils.TakesScreenshots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
    HomePage homePage = PageFactory.initElements(driver,HomePage.class);
    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
    RegistrationPage registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
    WebAutomationAdvancedPage webAutomationAdvancedPage = PageFactory.initElements(driver,WebAutomationAdvancedPage.class);

    TakesScreenshots takesScreenshots = new TakesScreenshots();
}
