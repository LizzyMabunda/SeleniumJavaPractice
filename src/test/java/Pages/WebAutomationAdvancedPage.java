package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WebAutomationAdvancedPage extends LoginPage {
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
    @FindBy(name = "storage")
    WebElement storageSizeSelection;
    @FindBy(id = "inventory-errors")
    WebElement inventoryError_id;
    @FindBy(id = "unit-price-value")
    WebElement unitPrice_id;
    @FindBy(id = "quantity-value")
    WebElement quantityValue_id;
    @FindBy(id = "subtotal-value")
    WebElement subtotalValue_id;
    @FindBy(id = "inventory-review-step")
    WebElement inventoryReviewStep_id;
    @FindBy(id = "shipping-option-express")
    WebElement shippingMethodExpress_id;
    @FindBy(id = "breakdown-shipping-value")
    WebElement shippingValue_id;
    @FindBy(id = "warranty-option-none")
    WebElement warrantyOptionNone_id;
    @FindBy(id = "warranty-option-1yr")
    WebElement warrantyOption1Year_id;
    @FindBy(id = "warranty-option-2yr")
    WebElement warrantyOption2Years_id;
    @FindBy(id = "breakdown-warranty-value")
    WebElement warrantyValue_id;
    @FindBy(id = "discount-code")
    WebElement discountCode_id;
    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountButton_id;
    @FindBy(id = "breakdown-total-value")
    WebElement finalTotalValue_id;
    @FindBy(id = "inventory-back-btn")
    WebElement inventoryBackButton_id;
    @FindBy(id = "add-to-cart-btn")
    WebElement addToCartButton_id;
    @FindBy(id = "purchase-device-btn")
    WebElement confirmPurchaseDeviceButton_id;
    @FindBy(id = "shipping-option-standard")
    WebElement shippingMethodStandard_id;
    @FindBy(id = "discount-feedback")
    WebElement discountFeedback_id;
    @FindBy(id = "breakdown-quantity-value")
    WebElement finaQuantityValue_id;
    @FindBy(id = "base-price-value")
    WebElement basePriceValue_id;
    @FindBy(id = "breakdown-subtotal-value")
    WebElement finalSubtotalValue_id;
    @FindBy(id = "cart-title")
    WebElement cartTitle_id;
    @FindBy(xpath = "//button[normalize-space(text())='Remove']")
    WebElement removeItemFromCart_XPath;
    @FindBy(id = "cart-grand-total-value")
    WebElement cartGrandTotal_id;
    @FindBy(xpath = "//div[starts-with(@id, 'cart-item-total-')]")
    WebElement cartItemTotal_XPath;
    @FindBy(id = "cart-summary")
    WebElement cartSummary_id;
    @FindBy(id = "review-cart-btn")
    WebElement reviewCartButton_id;
    @FindBy(id = "confirm-cart-btn")
    WebElement placeOrderButton_id;
    @FindBy(id = "cancel-cart-btn")
    WebElement cancelReviewOrderButton_id;
    @FindBy(id = "purchase-success-toast")
    WebElement successPurchaseToast_id;
    @FindBy(xpath = "//button[@title='Dismiss notification']")
    WebElement dismissToastNotificationButton_id;
    @FindBy(id = "view-history-btn")
    WebElement viewInvoiceHistoryButton_id;
    @FindBy(xpath = "//button[normalize-space(text())='\uD83D\uDC41\uFE0F View']")
    WebElement viewInvoiceButton_XPath;



    public WebAutomationAdvancedPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectDeviceType(String deviceType) {
        Select select = new Select(deviceType_id);
        select.selectByVisibleText(deviceType);

    }

    public void selectDeviceBrand(String brand) {
        Select select = new Select(deviceBrand_id);
        select.selectByVisibleText(brand);

    }

    public void selectStorageOfChoice(String storage) {
        switch (storage) {
            case "64GB":
                storage64GB_id.click();
                break;
            case "128GB":
                storage128GB_id.click();
                break;
            case "256GB":
                storage256GB_id.click();
                break;
        }
    }

    public void selectColour(String color) {
        Select select = new Select(deviceColor_id);
        select.selectByVisibleText(color);

    }

    public void selectQuantity(String quantity) {
        quantity_id.clear();
        quantity_id.sendKeys(quantity);

    }

    public void captureDeliveryAddress(String address) {
        deliveryAddress_id.sendKeys(address);
    }

    public void clickNextButton() {
        nextButton_id.click();
    }

    public void deviceTypeNotSelected() {
        Select select = new Select(deviceType_id);
        String selectedOption = select.getFirstSelectedOption().getText();
        if (selectedOption.equals("Select")) {
            System.out.println("Select a device type");
        } else {
            System.out.println("Device type field was not reset to default. Current selection: " + selectedOption);
        }
    }

    public void noBrandSelected() {
        Select select = new Select(deviceBrand_id);
        String selectedOption = select.getFirstSelectedOption().getText();
        if (selectedOption.equals("Select brand")) {
            System.out.println("Select a brand");
        } else {
            System.out.println("Brand field was not reset to default. Current selection: " + selectedOption);
        }
    }

    public void storageSizeNotSelected() {
       // storage128GB_id.click();
        List<WebElement> radioButtons = driver.findElements(By.name("storage"));
        boolean isAnySelected = false;

        for (WebElement radioButton : radioButtons) {
            if (radioButton.isSelected()) {
                isAnySelected = true;
                break;
            }
        }
        //If any selected fail with the message below
        Assert.assertFalse(isAnySelected, "Expected no storage option to be selected by default, but one was selected.");
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
        String actualErrorMessage = errorText_class.getText();
        System.out.println("Actual error message: " + actualErrorMessage);

    }

    public void quantityLessThanMinErrorMessage(String quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("quantity")));
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
        nextButton_id.click();
        String actualErrorMessage = errorText_class.getText();
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
        String unitPrice = unitPrice_id.getText();
        String subtotal = subtotalValue_id.getText();
        if (unitPrice.equals("—") && subtotal.equals("—")) {
            System.out.println("Device and storage not selected");
        } else {
            System.out.println("Unit price or subtotal are not R0.00" + unitPrice + " " + subtotal);
        }
    }

    public void phoneStorage64GBQty1() {
        String unitPrice = unitPrice_id.getText();
        String subtotal = subtotalValue_id.getText();
        Assert.assertEquals(unitPrice, "R400.00", "❌ Unit price should be R400.00 for Phone 64GB with quantity 1");
        Assert.assertEquals(subtotal, "R400.00", "❌ Subtotal should be R400.00 for Phone 64GB with quantity 1");
        System.out.println("Unit price and subtotal Amounts are correct: "  + unitPrice + " " + subtotal);

    }

    public void phoneStorage128GBQty2() {
        String unitPrice = unitPrice_id.getText();
        String subtotal = subtotalValue_id.getText();
        Assert.assertEquals(unitPrice, "R480.00", "❌ Unit price should be R400.00 for Phone 128GB with quantity 2");
        Assert.assertEquals(subtotal, "R960.00", "❌ Subtotal should be R400.00 for Phone 128GB with quantity 2");
        System.out.println("Unit price and subtotal Amounts are correct: "  + unitPrice + " " + subtotal);
    }

    public void selectLaptopStorage256GBQty1() {
        String unitPrice = unitPrice_id.getText();
        Assert.assertEquals(unitPrice, "R1360.00", "❌ Unit price should be R400.00 for Phone 128GB with quantity 2");
        System.out.println("Unit price is correct: " + unitPrice + " ");

    }

    public void clearDeviceTypeSelection(String deviceType) {
        Select select = new Select(deviceType_id);
        select.selectByVisibleText(deviceType);
        String unitPrice = unitPrice_id.getText();
        String subtotal = subtotalValue_id.getText();
        Assert.assertEquals(unitPrice, "—", "❌ Unit price should be R_ when device is cleared");
        Assert.assertEquals(subtotal, "—", "❌ Subtotal should be R_ when device is cleared");
        System.out.println("Unit price or subtotal resets back to default: " + unitPrice +  " "  + subtotal);

    }

    public void verifyInventoryReviewIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOf(inventoryReviewStep_id));
        inventoryReviewStep_id.isDisplayed();
    }

    public void clickStandardShippingMethodButton() {
        shippingMethodStandard_id.click();
    }
    public void clickExpressShippingMethodButton() {
        shippingMethodExpress_id.click();
    }

    public void verifyShippingMethodExpressAmount() {
        shippingMethodExpress_id.click();
        String expressShippingAmount = shippingValue_id.getText();
        Assert.assertEquals(expressShippingAmount, "R25.00", "❌ Shipping cost is incorrect:");
        System.out.println("Shipping cost is correct: " + expressShippingAmount);
    }

    public void clickNoneWarrantyOption() {
        warrantyOptionNone_id.click();
    }

    public void click1yearWarrantyOption() {
        warrantyOption1Year_id.click();
    }

    public void click2yearsWarrantyOption() {
        warrantyOption2Years_id.click();
    }

    public void verifyWarrantySelectionAmounts() {
        warrantyOptionNone_id.click();
        String noneAmount = warrantyValue_id.getText();
        if (noneAmount.equals("R0.00")) {
            System.out.println("Warranty None amount is correct: " + noneAmount);
        } else {
            System.out.println("Warranty None amount is incorrect: " + noneAmount);
        }
        warrantyOption1Year_id.click();
        String oneYearAmount = warrantyValue_id.getText();
        if (oneYearAmount.equals("R49.00")) {
            System.out.println("Warranty 1yr amount is correct: " + oneYearAmount);
        } else {
            System.out.println("Warranty 1yr amount is incorrect: " + oneYearAmount);
        }
        warrantyOption2Years_id.click();
        String twoYearAmount = warrantyValue_id.getText();
        if (twoYearAmount.equals("R89.00")) {
            System.out.println("Warranty 2yr amount is correct: " + twoYearAmount);
        } else {
            System.out.println("Warranty 2yr amount is incorrect: " + twoYearAmount);
        }
    }

    public void verifyFormulaForPhone128GBQty2Express1YrSave10() {

        String finalQuantityText = finaQuantityValue_id.getText();
        String displayedShippingValueText = shippingValue_id.getText().replace("R", "");
        String displayedWarrantyAmount = warrantyValue_id.getText().replace("R", "");
        String unitDevicePriceText = basePriceValue_id.getText().replace("R", "");
        String displayedSubTotalText = finalSubtotalValue_id.getText().replace("R", "");
        String displayedTotalText = finalTotalValue_id.getText().replace("R", "");
        double displayedTotal = Double.parseDouble(displayedTotalText);
        double displayedWarranty = Double.parseDouble(displayedWarrantyAmount);
        double unitDevicePrice = Double.parseDouble(unitDevicePriceText);
        double displayedSubTotal = Double.parseDouble(displayedSubTotalText);
        double displayedShippingValue = Double.parseDouble(displayedShippingValueText);
        int deviceQuantity = Integer.parseInt(finalQuantityText);

        double displayedSubTotalValue = (unitDevicePrice * deviceQuantity) + displayedWarranty + displayedShippingValue;
        double discountCalculation = displayedSubTotalValue * 0.10;
        double totalCalculation = displayedSubTotalValue - discountCalculation;

        if (Math.abs(displayedTotal - totalCalculation) < 0.01) {
            System.out.println("Total is correct: R" + displayedTotal);
        } else {
            System.out.println("Total is incorrect. Expected: R" + totalCalculation + ", Displayed: R" + displayedTotal);
        }
    }

    public void captureDiscountPercentage(String discountCode) {
        discountCode_id.sendKeys(discountCode);
        applyDiscountButton_id.click();
        discountFeedback_id.isDisplayed();
        String discountFeedback = discountFeedback_id.getText();
        System.out.println("Discount feedback message: " + discountFeedback);
    }
    public void verifySAVE20DiscountCodeMessageUpdate(String discountCode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("discount-code")));
        discountCode_id.clear();
        discountCode_id.sendKeys(discountCode);
        applyDiscountButton_id.click();
        discountFeedback_id.isDisplayed();
        String discountFeedback = discountFeedback_id.getText();
        System.out.println("Discount feedback message: " + discountFeedback);
    }
    public void verifyInvalidDiscountCodeMessageUpdate(String discountCode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("discount-code")));
        discountCode_id.clear();
        discountCode_id.sendKeys(discountCode);
        applyDiscountButton_id.click();
        discountFeedback_id.isDisplayed();
        String discountFeedback = discountFeedback_id.getText();
        System.out.println("Discount feedback message: " + discountFeedback);

    }
    public void verifyClearInputNoMessageDisplayed() {
        {
        discountCode_id.clear();
        discountCode_id.sendKeys("  ");
        applyDiscountButton_id.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.id("apply-discount-btn")));
            List<WebElement> discountMessages = driver.findElements(By.id("discount-feedback"));

            if (!discountMessages.isEmpty()) {
                boolean isVisible = discountMessages.get(0).isDisplayed();
                Assert.assertFalse(isVisible, "Discount element should be hidden when no discount code is applied.");
            } else {
                Assert.assertTrue(true, "Discount message not present, as expected.");
                System.out.println("Discount message not present, as expected.");
            }

        }

    }
    public void addValidItemToCart(String discountCode) {
        discountCode_id.clear();
        discountCode_id.sendKeys(discountCode);
        applyDiscountButton_id.click();
        addToCartButton_id.click();
        cartTitle_id.isDisplayed();
        String confirmNumberOfItemsInCart = cartTitle_id.getText();
        System.out.println("Number of Item(s) in the Cart: " + confirmNumberOfItemsInCart);
    }

    public void clickBackButtonAndModifyQuantity() {
        inventoryBackButton_id.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("quantity")));
    }
    public void clickAddToCartButton() {
        addToCartButton_id.click();
        cartTitle_id.isDisplayed();
        String confirmNumberOfItemsInCart = cartTitle_id.getText();
        System.out.println("Number of Item(s) in the Cart: " + confirmNumberOfItemsInCart);
    }
    public void RemoveItemFromCart() {
        removeItemFromCart_XPath.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOf(cartGrandTotal_id));
        cartGrandTotal_id.isDisplayed();
        String grandTotal = cartGrandTotal_id.getText().replace("R", "");;
        String itemsTotal = cartItemTotal_XPath.getText().replace("R", "");;
        String confirmNumberOfItemsInCart = cartTitle_id.getText();
        System.out.println("Number of Item(s) in the Cart after removing item: " + confirmNumberOfItemsInCart +   "Grand Total: " +grandTotal);
        double displayedGrandTotal =  Double.parseDouble(grandTotal);
        double displayedItemTotal = Double.parseDouble(itemsTotal);

        Assert.assertEquals(displayedItemTotal, displayedGrandTotal, 0.01, "Amounts do not match!");
        System.out.println("Amounts are equal: R" + displayedGrandTotal);

    }
    public void RemoveSecondItemFromCart() {
        removeItemFromCart_XPath.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> cartSummarySection = driver.findElements(By.id("cart-summary"));
        Assert.assertTrue(cartSummarySection.isEmpty(), "❌ Cart summary should not be present after removing all items.");
        System.out.println("Cart summary panel is hidden, as expected :)");

    }
    public void clickReviewCartOrderFlow(){
        reviewCartButton_id.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(visibilityOf(placeOrderButton_id));
        cartSummary_id.isDisplayed();
        placeOrderButton_id.isDisplayed();
        cancelReviewOrderButton_id.isDisplayed();
    }

    public void clickPlaceOrderFlow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(successPurchaseToast_id));
        String orderConfirmationText = successPurchaseToast_id.getText().trim();
        System.out.println("Order successful message:" + orderConfirmationText);

    }
    public void confirmCartOrderFlow(){
        placeOrderButton_id.click();
    }
    public void dismissToastNotification(){
        dismissToastNotificationButton_id.click();
    }
    public void clickCancelReviewOrderButton(){
        cancelReviewOrderButton_id.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(reviewCartButton_id));
    }
    public void viewInvoiceFromToast() {
        String originalWindow = driver.getWindowHandle();
        viewInvoiceHistoryButton_id.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        viewInvoiceButton_XPath.click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        System.out.println("Title of new tab: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(originalWindow);

    }

    public void switchToOriginalTab(WebDriver driver) {
    }
}
