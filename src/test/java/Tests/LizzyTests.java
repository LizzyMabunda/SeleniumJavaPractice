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

    //@Test(dependsOnMethods = "clickOnWebAutomationButtonTests")
    public void fillInventoryFormTests() {
        webAutomationAdvancedPage.selectDeviceType("Laptop");
        webAutomationAdvancedPage.selectDeviceBrand("Macbook pro");
        webAutomationAdvancedPage.selectStorageOfChoice("64GB");
        webAutomationAdvancedPage.selectColour("Gold");
        webAutomationAdvancedPage.selectQuantity("3");
        webAutomationAdvancedPage.captureDeliveryAddress("123 Test Street, Test City, TX 750");
        webAutomationAdvancedPage.clickNextButton();
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


    //@AfterTest
    public void tearDown() {
        driver.quit();
    }


}
