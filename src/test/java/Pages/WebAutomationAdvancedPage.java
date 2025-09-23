package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WebAutomationAdvancedPage {
    WebDriver driver;

    @FindBy(id = "deviceType")
    WebDriver deviceType_id;
    @FindBy(id = "brand")
    WebDriver deviceBrand_id;
    @FindBy(id = "storage-64GB")
    WebDriver storage64GB_id;
    @FindBy(id = "storage-128GB")
    WebDriver storage128GB_id;
    @FindBy(id = "storage-256GB")
    WebDriver storage256GB_id;
    @FindBy(id = "color")
    WebDriver deviceColor_id;
    @FindBy(id = "quantity")
    WebDriver quantity_id;
    @FindBy(id = "address")
    WebDriver deliveryAddress_id;
    @FindBy(id = "inventory-next-btn")
    WebDriver nextButton_id;
    @FindBy(className = "error-text")
    WebDriver errorText_class;

    public WebAutomationAdvancedPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDeviceType(String deviceType) {
        WebElement deviceType_id = driver.findElement(By.id("deviceType"));
        Select select = new Select(deviceType_id);
        select.selectByVisibleText(deviceType);

    }
    public void selectDeviceBrand(String brand) {
        WebElement deviceBrand_id = driver.findElement(By.id("brand"));
        Select select = new Select(deviceBrand_id);
        select.selectByVisibleText(brand);

    }
    public void selectStorageOfChoice(String storage) {
        if (storage.equals("64GB")) {
            driver.findElement(By.id("storage-64GB")).click();
        } else if (storage.equals("128GB")) {
            driver.findElement(By.id("storage-128GB")).click();
        } else if (storage.equals("256GB")) {
            driver.findElement(By.id("storage-256GB")).click();
        }
    }
    public void selectColour(String color) {
        WebElement deviceColor_id = driver.findElement(By.id("color"));
        Select select = new Select(deviceColor_id);
        select.selectByVisibleText(color);

    }
    public void selectQuantity(String quantity) {
        WebElement quantity_id = driver.findElement(By.id("quantity"));
        quantity_id.clear();
        quantity_id.sendKeys(quantity);

    }
    public void captureDeliveryAddress(String address) {
        WebElement deliveryAddress_id = driver.findElement(By.id("address"));
        deliveryAddress_id.sendKeys(address);
    }
    public void clickNextButton() {
        WebElement nextButton_id = driver.findElement(By.id("inventory-next-btn"));
        nextButton_id.click();
    }
    public boolean deviceTypeNotSelectedNextButtonDisabled() {
        WebElement nextButton = driver.findElement(By.id("inventory-next-btn"));
        return !nextButton.isEnabled();
    }

    public boolean noBrandSelectedNextButtonDisabled() {
        WebElement nextButton = driver.findElement(By.id("inventory-next-btn"));
        return !nextButton.isEnabled();

    }
    public void quantityMoreThanMaxErrorMessage() {
        WebElement errorMessage = driver.findElement(By.className("error-text"));
        String actualErrorMessage = errorMessage.getText();
        System.out.println("Actual error message: " + actualErrorMessage);
    }
    public void quantityLessThanMinErrorMessage() {
        WebElement errorMessage = driver.findElement(By.className("error-text"));
        String actualErrorMessage = errorMessage.getText();
        System.out.println("Actual error message: " + actualErrorMessage);
    }

}
