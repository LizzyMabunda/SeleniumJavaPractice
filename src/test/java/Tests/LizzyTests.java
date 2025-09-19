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

   // @Test(dependsOnMethods = "validateLoginScreenHeadingTests")
    public void clickSignInButtonTests() {
        loginPage.clickSignUpToggle();
    }

    //@Test(dependsOnMethods = "clickSignInButtonTests")
    public void signUpNewUserTests() {
        loginPage.signUpNewUser("Lizzy", "Mabunda", "lm31@yahoo.com", "Rifuwo@07", "Rifuwo@07");
    }

    //@Test(dependsOnMethods = "signUpNewUserTests" )
    public void clickCreateAccountButtonTests() {
        loginPage.clickCreateAccountButton();
    }

   // @Test(dependsOnMethods = "clickCreateAccountButtonTests" )
    public void validateExistingUserSignUpErrorTests() {
        loginPage.validateExistingUserSignUpError();
    }
    @Test(dependsOnMethods = "validateLoginScreenHeadingTests")
    public void validLoginDetailsTests() {
        loginPage.loginDetails("lm31@yahoo.com", "Rifuwo@07");
    }

    @Test(dependsOnMethods = "validLoginDetailsTests")
    public void clickLoginButtonTests() {
        loginPage.clickLoginButton();
    }

    @Test(dependsOnMethods = "validLoginDetailsTests")
    public void validatePracticeTabsAreDisplayedTests() {
        loginPage.validatePracticeTabsAreDisplayed();
    }

    @Test(dependsOnMethods = "validatePracticeTabsAreDisplayedTests")
    public void clickLogoutButtonTests() {
        loginPage.clickLogoutButton();
    }

    @Test(dependsOnMethods = "clickLogoutButtonTests")
    public void validateInvalidLoginDetailsErrTests() {
        loginPage.loginDetails("lmabinda31@yahoo.com", "Rifuwo@09");
        loginPage.validateInvalidLoginDetailsErr();
    }


}
