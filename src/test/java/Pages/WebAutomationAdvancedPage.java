package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WebAutomationAdvancedPage extends LoginPage{
    WebDriver driver;

    @FindBy(id = "deviceType")
    WebElement deviceType_id;
    @FindBy(id = "brand")
    WebElement deviceBrand_id;
    @FindBy(id = "storage-64GB")
    WebElement storage64GB_id;
    @FindBy(id = "storage-128GB")
    WebElement storage128GB_id;
    @FindBy(id = "storage-256GB")
    WebElement storage256GB_id;
    @FindBy(id = "color")
    WebElement deviceColor_id;
    @FindBy(id = "quantity")
    WebElement quantity_id;
    @FindBy(id = "address")
    WebElement deliveryAddress_id;
    @FindBy(id = "inventory-next-btn")
    WebElement nextButton_id;
    @FindBy(className = "error-text")
    WebElement errorText_class;
    @FindBy(xpath = "//*[@id=\"inventory-form-grid\"]/div[3]/div")
    WebElement storageSizeSelection;
    @FindBy(id = "inventory-errors")
    WebElement inventoryError_id;
    @FindBy(id = "unit-price-value")
    WebElement unitPrice_id;
    @FindBy(id = "quantity-value")
    WebElement quantityValue_id;
    @FindBy(id = "subtotal-value")
    WebElement subtotalValue_id;



    public WebAutomationAdvancedPage(WebDriver driver) {
        super(driver);
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
    public void deviceTypeNotSelected() {
        WebElement deviceTypeDropdown = driver.findElement(By.id("deviceType"));
        Select  select = new Select(deviceTypeDropdown);
        String selectedOption = select.getFirstSelectedOption().getText();
        if (selectedOption.equals("Select"))
        {
            System.out.println("Select a device type");
        } else {
            System.out.println("Device type field was not reset to default. Current selection: "+ selectedOption);
        }
    }

    public void noBrandSelected() {
        WebElement brandDropdown = driver.findElement(By.id("brand"));
        Select select = new Select(brandDropdown);
        String selectedOption = select.getFirstSelectedOption().getText();
        if (selectedOption.equals("Select brand")) {
            System.out.println("Select a brand");
        } else {
            System.out.println("Brand field was not reset to default. Current selection: " + selectedOption);
        }
    }

        public void storageSizeNotSelected(){
            WebElement storageRadioButtons = driver.findElement(By.xpath("//*[@id=\"inventory-form-grid\"]/div[3]/div"));
            if (!storageRadioButtons.isSelected()){
                System.out.println("Select storge size");
            }
            else {
                System.out.println("Storage size is selected!");
            }
    }
    public void validateAddressIsBlank() {
        String address = deliveryAddress_id.getText();
        if (address.isEmpty()) {
            System.out.println("Address required");
        } else {
            System.out.println("Address field is not blank");
        }
    }
    public void quantityMoreThanMaxErrorMessage() {
        WebElement errorMessage = driver.findElement(By.className("error-text"));
        String actualErrorMessage = errorMessage.getText();
        System.out.println("Actual error message: " + actualErrorMessage);

    }
    public void quantityLessThanMinErrorMessage(String quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("quantity")));
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
        nextButton_id.click();
        WebElement errorMessage = driver.findElement(By.className("error-text"));
        String actualErrorMessage = errorMessage.getText();
        System.out.println("Actual error message: " + actualErrorMessage);
        WebElement errorSummary = driver.findElement(By.id("inventory-errors"));
        inventoryError_id.isDisplayed();
        String actualErrorSummary = errorSummary.getText();
        System.out.println("Actual error message: " + actualErrorSummary);
    }
    public void correctAllDetailsAndClickNextButton(String quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("quantity")));
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
        nextButton_id.click();
    }
    public void noDeviceAndStorageSelected() {
        WebElement unitPriceValue = driver.findElement(By.id("unit-price-value"));
        WebElement subtotalValue = driver.findElement(By.id("subtotal-value"));
        String unitPrice = unitPriceValue.getText();
        String subtotal = subtotalValue.getText();
        if (unitPrice.equals("—") && subtotal.equals("—")) {
            System.out.println("Device and storage not selected");
        } else {
            System.out.println("Unit price or subtotal are not $0.00" + unitPrice + " " + subtotal);
        }
    }
    public void phoneStorage64GBQty1(){
        WebElement unitPriceValue = driver.findElement(By.id("unit-price-value"));
        WebElement quantityValue = driver.findElement(By.id("quantity-value"));
        WebElement subtotalValue = driver.findElement(By.id("subtotal-value"));
        String unitPrice = unitPriceValue.getText();
        String quantity = quantityValue.getText();
        String subtotal = subtotalValue.getText();
        if (unitPrice.equals("R400.00") && quantity.equals("1") && subtotal.equals("R400.00")) {
            System.out.println("quantity, Unit price and subtotal are correct: " + quantity + " " + unitPrice + " " + subtotal);
        } else {
            System.out.println("quantity, Unit price and subtotal are correct: " + quantity + " " + unitPrice + " " + subtotal);
        }
    }
    public void phoneStorage128GBQty2(){
        WebElement unitPriceValue = driver.findElement(By.id("unit-price-value"));
        WebElement quantityValue = driver.findElement(By.id("quantity-value"));
        WebElement subtotalValue = driver.findElement(By.id("subtotal-value"));
        String unitPrice = unitPriceValue.getText();
        String quantity = quantityValue.getText();
        String subtotal = subtotalValue.getText();
        if (unitPrice.equals("R480.00") && quantity.equals("2") && subtotal.equals("R960.00")) {
            System.out.println("quantity, Unit price and subtotal are correct: " + quantity + " " + unitPrice + " " + subtotal);
        } else {
            System.out.println("quantity, Unit price and subtotal are correct: " + quantity + " " + unitPrice + " " + subtotal);
        }
    }
    public void selectLaptopStorage256GBQty1(){
        WebElement unitPriceValue = driver.findElement(By.id("unit-price-value"));
        String unitPrice = unitPriceValue.getText();
        if (unitPrice.equals("R1360.00") ) {
            System.out.println("Unit price is correct: "  + unitPrice + " ");
        } else {
            System.out.println("Unit price is incorrect: " + unitPrice + " ");
        }
    }
    public void clearDeviceTypeSelection(String deviceType) {
        WebElement deviceTypeDropdown = driver.findElement(By.id("deviceType"));
        Select select = new Select(deviceTypeDropdown);
        select.selectByVisibleText(deviceType);

        WebElement unitPriceValue = driver.findElement(By.id("unit-price-value"));
        WebElement subtotalValue = driver.findElement(By.id("subtotal-value"));
        String unitPrice = unitPriceValue.getText();
        String subtotal = subtotalValue.getText();
        if (unitPrice.equals("—") && subtotal.equals("—")) {
            System.out.println("Pricing resets successfully!");
        } else {
            System.out.println("Unit price or subtotal are not resets back to default: " + unitPrice + " " + subtotal);
        }
    }

}
