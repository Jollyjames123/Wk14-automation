package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData1;
@Listeners(CustomListeners.class)
public class SignPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        signInPage = new SignInPage();
    }

    /**
     * 1.userShouldNavigateToSignInPageSuccessFully().
     * Click on Sign In link
     * verify that "AUTHENTICATION" message is displayed
     */
    @Test
    public void userShouldNavigateToSignInPageSuccessFully() {
        homePage.clickOnSignIn();
        signInPage.verifyAuthMessage();
    }

    /**
     * 2. verifyTheErrorMessageWithInValidCredentials(String username, String password).
     * Click on sign in link
     * Enter "username"
     * Enter "password"
     * Click on Sign in Button
     * Verify the Error message "message"
     * DATA SET
     * | username | password | message |
     * | | 123456 | An email address required. |
     * | abcd@gmail.com | | Password is required. |
     * | adfdfgfg | 123456 | Invalid email address. |
     * | abcd@gmail.com | 123456 | Authentication failed. |
     */
    @Test(priority = 1, dataProvider = "credentials", dataProviderClass = TestData1.class)
    public void verifyTheErrorMessageWithInValidCredentials(String username, String password) {
        homePage.clickOnSignIn();
        signInPage.loginToApplication(username, password);
        signInPage.verifyErrorMessage();
    }

    /**
     * 3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
     * Click on sign link
     * Enter EmailId
     * Enter Password
     * Click on Sign Button
     * Verify that Sign out link is displayed
     */
    @Test(priority = 2)
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        homePage.clickOnSignIn();
        signInPage.enterUsername("prime@gmail.com");
        signInPage.enterPassword("Prime123");
        signInPage.clickOnSigninButton();
        signInPage.verifySignOutLink();
    }

    /**
     * 4. VerifyThatUserShouldLogOutSuccessFully()
     *  Click on sign link
     *  Enter EmailId
     *  Enter Password
     *  Click on Sign Button
     *  Click on Sign out Link
     *  Verify that Sign In Link displayed
     */
    @Test(priority = 3)
    public void VerifyThatUserShouldLogOutSuccessFully() {
        homePage.clickOnSignIn();
        signInPage.enterUsername("prime@gmail.com");
        signInPage.enterPassword("Prime123");
        signInPage.clickOnSigninButton();
        signInPage.clickOnSignOut();
        signInPage.verifySignInLink();
    }

}
