package Tests;

import Utils.OpenNewTab;
import org.testng.annotations.Test;

public class LizzyTests extends Base {

    @Test
    public void VerifyHomePageIsDisplayedTests() {
        homePage.verifyHomePageIsDisplayed();
    }

    @Test(dependsOnMethods = "VerifyHomePageIsDisplayedTests")
    public void clickLearningMaterialTests() {
        homePage.clickLearningMaterial();
    }

    @Test(dependsOnMethods = "clickLearningMaterialTests")
    public void validateLoginScreenHeadingTests() {
        loginPage.validateLoginScreenHeading();
        takesScreenshots.takesSnapShot(driver, "LoginScreen Heading");
    }

    //@Test(dependsOnMethods = "validateLoginScreenHeadingTests")
    public void clickSignUpButtonTests() {
        loginPage.clickSignUpToggle();
    }

    // @Test(dependsOnMethods = "clickSignUpButtonTests")
    public void validateRegistrationScreenHeadingTests() {
        registrationPage.validateRegistrationScreenHeading();
    }

    //@Test(dependsOnMethods = "validateRegistrationScreenHeadingTests")
    public void passwordMisMatchRegistrationErrorTest() {
        registrationPage.captureRegistrationDetails("Lizzy", "Test", "mm@yahoo.com", "Rifuwo@07", "Rifuwo@09");
        registrationPage.passwordMisMatchRegistrationError();
    }

    // @Test(dependsOnMethods = "passwordMisMatchRegistrationErrorTest")
    public void passwordLengthRegistrationErrorTests() {
        registrationPage.passwordLengthRegistrationError("Test", "Test");
    }

    //@Test(dependsOnMethods = "passwordLengthRegistrationErrorTests")
    public void invalidEmailErrorTests() {
        registrationPage.invalidEmailRegistrationError("mm@uhgsd", "Rifuwo@07", "Rifuwo@07");
    }

    //@Test(dependsOnMethods = "invalidEmailErrorTests")
    public void successfulRegistration() throws InterruptedException {
        registrationPage.successfulRegistration("Lizzy", "Test", "lmabunda@yahoo.com", "Ntavele@07", "Ntavele@07");
        //registrationPage.captureRegistrationDetails("Lizzy", "Test", "mom@test.com", "Rifuwo@08", "Rifuwo@08");
    }

    @Test(dependsOnMethods = "validateLoginScreenHeadingTests")
    public void loginValidCredentialsTest() {
        loginPage.loginValidCredentials(readFromExcel.username, readFromExcel.password);
        loginPage.clickWebAutomationButton();
    }

    //@Test(dependsOnMethods = "openNewTabAndSwitchTests")
    public void validLoginTest() {
        loginPage.validLogin("lmabunda@yahoo.com", "Ntavele@07");
        loginPage.clickLogoutButton();
    }

    // @Test(dependsOnMethods = "validLoginTest")
    public void validateInvalidLoginDetailsErrTests() {
        loginPage.invalidPassword("lm31@yahoo.com", "Rifuwo@09");

    }

    //@Test(dependsOnMethods = "validateInvalidLoginDetailsErrTests")
    public void trimSpaceLoginTest() {
        loginPage.trimSpaceLogin(" lm31@yahoo.com ", " Rifuwo@07 ");
    }

    //@Test(dependsOnMethods = "trimSpaceLoginTest")
    public void switchbackToLearningMaterialTabTests() {
        loginPage.switchTabThenBack();
        loginPage.loginValidCredentials("lm31@yahoo.com", "Rifuwo@07");


    }

    //@Test(dependsOnMethods = "switchbackToLearningMaterialTabTests")
    public void clickLogoutButtonTests() {
        loginPage.clickLogoutButton();
    }

    @Test(dependsOnMethods = "loginValidCredentialsTest")
    public void deviceTypeNotSelectedTest() {
        webAutomationAdvancedPage.deviceTypeNotSelected();
    }

    @Test(dependsOnMethods = "deviceTypeNotSelectedTest")
    public void noBrandSelectedTests() {
        webAutomationAdvancedPage.selectDeviceType("Laptop");
        webAutomationAdvancedPage.noBrandSelected();
    }

    @Test(dependsOnMethods = "noBrandSelectedTests")
    public void storageSizeNotSelectedTests() {
        webAutomationAdvancedPage.storageSizeNotSelected();
        takesScreenshots.takesSnapShot(driver, "storageSizeNotSelected");
    }

    @Test(dependsOnMethods = "storageSizeNotSelectedTests")
    public void validateAddressIsBlankTests() {
        webAutomationAdvancedPage.validateAddressIsBlank();
    }

    @Test(dependsOnMethods = "validateAddressIsBlankTests")
    public void quantityMoreThanMaxErrorTests() {
        webAutomationAdvancedPage.selectDeviceBrand("Macbook pro");
        webAutomationAdvancedPage.selectStorageOfChoice("64GB");
        webAutomationAdvancedPage.selectColour("Gold");
        webAutomationAdvancedPage.selectQuantity("11");
        webAutomationAdvancedPage.captureDeliveryAddress("123 Test Street, Test City, TX 750");
        webAutomationAdvancedPage.clickNextButton();
        webAutomationAdvancedPage.quantityMoreThanMaxErrorMessage();
    }

    @Test(dependsOnMethods = "quantityMoreThanMaxErrorTests")
    public void quantityLessThanMinErrorMessageTests() {
        webAutomationAdvancedPage.quantityLessThanMinErrorMessage("0");
    }

    @Test(dependsOnMethods = "quantityLessThanMinErrorMessageTests")
    public void correctAllDetailsAndClickNextButtonTests() {
        webAutomationAdvancedPage.selectQuantity("3");
        webAutomationAdvancedPage.clickNextButton();
    }

    @Test(dependsOnMethods = "correctAllDetailsAndClickNextButtonTests")
    public void openNewTabAndSwitchTests() {
        openNewTab.openNewTabAndSwitch(driver);
        homePage.verifyHomePageIsDisplayed();
    }

    @Test(dependsOnMethods = "openNewTabAndSwitchTests")
    public void noDeviceAndStorageSelected() {
        homePage.clickLearningMaterial();
        loginPage.clickWebAutomationButton();
        webAutomationAdvancedPage.noDeviceAndStorageSelected();
    }

    @Test(dependsOnMethods = "noDeviceAndStorageSelected")
    public void phoneStorage64GBQty1Test() {
        webAutomationAdvancedPage.selectDeviceType("Phone");
        webAutomationAdvancedPage.selectStorageOfChoice("64GB");
        webAutomationAdvancedPage.phoneStorage64GBQty1();
    }

    @Test(dependsOnMethods = "phoneStorage64GBQty1Test")
    public void phoneStorage128GBQty2Test() {
        webAutomationAdvancedPage.selectStorageOfChoice("128GB");
        webAutomationAdvancedPage.selectQuantity("2");
        webAutomationAdvancedPage.phoneStorage128GBQty2();

    }
    @Test(dependsOnMethods = "phoneStorage128GBQty2Test")
    public void selectLaptopStorage256GBQty1(){
        webAutomationAdvancedPage.selectDeviceType("Laptop");
        webAutomationAdvancedPage.selectStorageOfChoice("256GB");
        webAutomationAdvancedPage.selectQuantity("1");
        webAutomationAdvancedPage.selectLaptopStorage256GBQty1();
    }
    @Test(dependsOnMethods = "selectLaptopStorage256GBQty1")
    public void clearDeviceTypeSelectionTest(){
        webAutomationAdvancedPage.selectStorageOfChoice("64GB");
        webAutomationAdvancedPage.clearDeviceTypeSelection("Select");
    }
    @Test(dependsOnMethods = "clearDeviceTypeSelectionTest")
    public void fillInventoryFormTests() {
        webAutomationAdvancedPage.selectDeviceType("Laptop");
        webAutomationAdvancedPage.selectDeviceBrand("Macbook pro");
        webAutomationAdvancedPage.selectStorageOfChoice("64GB");
        webAutomationAdvancedPage.selectColour("Gold");
        webAutomationAdvancedPage.selectQuantity("1");
        webAutomationAdvancedPage.captureDeliveryAddress("123 Test Street, Test City, TX 750");
        webAutomationAdvancedPage.clickNextButton();
    }
    @Test(dependsOnMethods = "fillInventoryFormTests")
    public void verifyInventoryReviewIsDisplayedTests(){
        webAutomationAdvancedPage.verifyInventoryReviewIsDisplayed();
        takesScreenshots.takesSnapShot(driver, "Inventory Review Page");
    }
    @Test(dependsOnMethods = "verifyInventoryReviewIsDisplayedTests")
    public void verifyShippingMethodExpressAmountTests(){
        webAutomationAdvancedPage.verifyShippingMethodExpressAmount();
    }
    @Test(dependsOnMethods = "verifyShippingMethodExpressAmountTests")
    public void verifyWarrantyRowAmountsTests(){
        webAutomationAdvancedPage.verifyWarrantySelectionAmounts();
    }
    @Test(dependsOnMethods = "verifyWarrantyRowAmountsTests")
    public void clickBackButtonAndModifyQuantityTests(){
        webAutomationAdvancedPage.clickBackButtonAndModifyQuantity();
        webAutomationAdvancedPage.selectDeviceType("Phone");
        webAutomationAdvancedPage.selectDeviceBrand("Samsung");
        webAutomationAdvancedPage.selectStorageOfChoice("128GB");
        webAutomationAdvancedPage.selectColour("White");
        webAutomationAdvancedPage.selectQuantity("2");
        webAutomationAdvancedPage.captureDeliveryAddress("123 Test Street, Test City, TX 750");
        webAutomationAdvancedPage.clickNextButton();
    }
    @Test(dependsOnMethods = "clickBackButtonAndModifyQuantityTests")
    public void verifyFormulaForPhone128GBQty2Express1YrSave10(){
        webAutomationAdvancedPage.clickExpressShippingMethodButton();
        webAutomationAdvancedPage.click1yearWarrantyOption();
        webAutomationAdvancedPage.captureDiscountPercentage("SAVE10");
        webAutomationAdvancedPage.verifyFormulaForPhone128GBQty2Express1YrSave10();
        takesScreenshots.takesSnapShot(driver, "Final Order Summary");
    }
   @Test(dependsOnMethods = "verifyFormulaForPhone128GBQty2Express1YrSave10")
    public void verifySAVE20DiscountCodeMessageUpdate(){
        webAutomationAdvancedPage.verifySAVE20DiscountCodeMessageUpdate("SAVE20");
        //takesScreenshots.takesSnapShot(driver, "Final Order Summary with SAVE20");
    }
    @Test(dependsOnMethods = "verifySAVE20DiscountCodeMessageUpdate")
    public void verifyInvalidDiscountCodeErrorMessageTests(){
        webAutomationAdvancedPage.verifyInvalidDiscountCodeMessageUpdate("SAVE100");
    }
    @Test(dependsOnMethods = "verifyInvalidDiscountCodeErrorMessageTests")
    public void verifyClearInputNoMessageDisplayedTests() throws InterruptedException {
        webAutomationAdvancedPage.verifyClearInputNoMessageDisplayed();
    }
    @Test(dependsOnMethods = "verifyClearInputNoMessageDisplayedTests")
    public void addOneValidItemToCart(){
        webAutomationAdvancedPage.addValidItemToCart("SAVE20");
       // webAutomationAdvancedPage.verifyInventoryReviewIsDisplayed();
    }
    @Test(dependsOnMethods = "addOneValidItemToCart")
    public void addTwoValidItemToCart(){
        webAutomationAdvancedPage.selectDeviceType("Laptop");
        webAutomationAdvancedPage.selectDeviceBrand("Macbook pro");
        webAutomationAdvancedPage.selectStorageOfChoice("256GB");
        webAutomationAdvancedPage.selectColour("Blue");
        webAutomationAdvancedPage.selectQuantity("1");
        webAutomationAdvancedPage.captureDeliveryAddress("123 Test Street, Test City, TX 750");
        webAutomationAdvancedPage.clickNextButton();
        webAutomationAdvancedPage.clickStandardShippingMethodButton();
        webAutomationAdvancedPage.clickNoneWarrantyOption();
        //webAutomationAdvancedPage.captureDiscountPercentage("SAVE10");
        webAutomationAdvancedPage.clickAddToCartButton();

    }
   @Test(dependsOnMethods = "addTwoValidItemToCart")
    public void RemoveItemFromCart(){
        webAutomationAdvancedPage.RemoveItemFromCart();
    }
    @Test(dependsOnMethods = "RemoveItemFromCart")
    public void RemoveSecondItemFromCartTests(){
        webAutomationAdvancedPage.RemoveSecondItemFromCart();
    }
    @Test(dependsOnMethods = "RemoveSecondItemFromCartTests")
    public void verifyPlaceOrderCancelButtonsDisplayed() {
        webAutomationAdvancedPage.selectDeviceType("Laptop");
        webAutomationAdvancedPage.selectDeviceBrand("Macbook pro");
        webAutomationAdvancedPage.selectStorageOfChoice("256GB");
        webAutomationAdvancedPage.selectColour("Gold");
        webAutomationAdvancedPage.selectQuantity("1");
        webAutomationAdvancedPage.captureDeliveryAddress("123 Test Street, Test City, TX 750");
        webAutomationAdvancedPage.clickNextButton();
        webAutomationAdvancedPage.clickExpressShippingMethodButton();
        webAutomationAdvancedPage.click2yearsWarrantyOption();
        webAutomationAdvancedPage.captureDiscountPercentage("SAVE10");
        webAutomationAdvancedPage.clickAddToCartButton();
        webAutomationAdvancedPage.clickReviewCartOrderFlow();

    }
    @Test(dependsOnMethods = "verifyPlaceOrderCancelButtonsDisplayed")
    public void clickCancelOrderFlowTests(){
        webAutomationAdvancedPage.clickCancelReviewOrderButton();
    }

    @Test(dependsOnMethods = "clickCancelOrderFlowTests")
    public void placeOrderSuccessful() {
        webAutomationAdvancedPage.clickReviewCartOrderFlow();
        webAutomationAdvancedPage.confirmCartOrderFlow();
        webAutomationAdvancedPage.clickPlaceOrderFlow();

    }
    @Test(dependsOnMethods = "placeOrderSuccessful")
    public void viewInvoiceFromToast(){
        webAutomationAdvancedPage.viewInvoiceFromToast();
        takesScreenshots.takesSnapShot(driver, "Invoice Page");
    }
    public void switchToOriginalTabTests(){
        webAutomationAdvancedPage.switchToOriginalTab(driver);
        homePage.verifyHomePageIsDisplayed();
    }
    //@AfterTest
    public void tearDown() {
        driver.quit();
    }


}
