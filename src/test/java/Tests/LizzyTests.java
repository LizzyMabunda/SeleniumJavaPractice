package Tests;

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
    }

   @Test(dependsOnMethods = "validateLoginScreenHeadingTests")
    public void clickSignInButtonTests() {
       loginPage.clickSignUpToggle();
    }
    @Test(dependsOnMethods = "clickSignInButtonTests")
    public void validateRegistrationScreenHeadingTests() {
        registrationPage.validateRegistrationScreenHeading();
    }
    @Test(dependsOnMethods = "validateRegistrationScreenHeadingTests")
    public void passwordMisMatchRegistrationErrorTest() {
        registrationPage.captureRegistrationDetails("Lizzy", "Test", "mm@yahoo.com", "Rifuwo@07", "Rifuwo@09");
        registrationPage.passwordMisMatchRegistrationError();
    }
    @Test(dependsOnMethods = "passwordMisMatchRegistrationErrorTest")
    public void passwordLengthRegistrationErrorTests() {
        registrationPage.passwordLengthRegistrationError("Test", "Test");
    }
    @Test(dependsOnMethods = "passwordLengthRegistrationErrorTests")
    public void invalidEmailErrorTests() {
        registrationPage.invalidEmailRegistrationError("mm@uhgsd","Rifuwo@07","Rifuwo@07");
    }
    @Test(dependsOnMethods = "invalidEmailErrorTests")
    public void successfulRegistration() throws InterruptedException {
        registrationPage.successfulRegistration("Password", "Test", "help@yahoo.com", "Ntavele@1", "Ntavele@1");
        //registrationPage.captureRegistrationDetails("Lizzy", "Test", "mom@test.com", "Rifuwo@08", "Rifuwo@08");
    }
    @Test(dependsOnMethods = "successfulRegistration")
    public void validLoginDetailsTests() {
        loginPage.loginDetails("lm31@yahoo.com", "Rifuwo@07");
    }
    @Test(dependsOnMethods = "validLoginDetailsTests")
    public void validatePracticeTabsAreDisplayedTests() {
        loginPage.validatePracticeTabsAreDisplayed();
    }
    @Test(dependsOnMethods = "validatePracticeTabsAreDisplayedTests")
    public void validateInvalidLoginDetailsErrTests() {
        loginPage.loginDetails("lm31@yahoo.com", "Rifuwo@09");
        loginPage.validateInvalidLoginDetailsErr();
    }
    @Test(dependsOnMethods = "validateInvalidLoginDetailsErrTests")
    public void trimSpaceLoginTests() throws InterruptedException {
        loginPage.trimSpaceLogin(" lm31@yahoo.com ", " Rifuwo@07 ");
    }
    @Test(dependsOnMethods = "trimSpaceLoginTests")
    public void switchTabTests(){
        loginPage.switchTab();
    }
    @Test(dependsOnMethods = "switchTabTests")
    public void switchbackToLearningMaterialTabTests(){
        loginPage.switchBackToLearningMaterialTab("lm31@yahoo.com", "Rifuwo@07");
    }
   @Test(dependsOnMethods = "switchbackToLearningMaterialTabTests")
    public void clickLogoutButtonTests() {
        loginPage.clickLogoutButton();
    }
    //@AfterTest
    public void tearDown(){
        driver.quit();
    }


}
