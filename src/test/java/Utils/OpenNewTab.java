package Utils;

import org.openqa.selenium.WebDriver;

import static Utils.BrowserFactory.driver;

public class OpenNewTab {
    public static void openNewTabAndSwitch(WebDriver driver) {
        ((org.openqa.selenium.JavascriptExecutor) BrowserFactory.driver).executeScript("window.open()");
        java.util.ArrayList<String> tabs = new java.util.ArrayList<>(BrowserFactory.driver.getWindowHandles());
        BrowserFactory.driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.get("https://www.ndosiautomation.co.za/");
    }

}
