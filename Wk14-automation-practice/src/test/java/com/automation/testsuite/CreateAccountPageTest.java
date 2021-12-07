package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 2. CreateAccountPageTest
 * Inside CreateAccountPageTest class create following testmethods
 *
 * 1. verifyThatUserShouldCreateAccountSuccessfully()
 *  Click on Sign in Link
 *  Enter email address
 *  Click on "Create an account" button
 *  Fill all mandetory fields
 *  Click on "Register" button
 *  Verify message "My Account"
 */
@Listeners(CustomListeners.class)
public class CreateAccountPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
    }
    @Test
    public void verifyThatUserShouldCreateAccountSuccessfully(){
    homePage.clickOnSignIn();
    signInPage.enterEmail(emailString()+"@gmail.com");
    signInPage.clickOnCreateAcc();
    createAccountPage.fillMandetoryFields();
    createAccountPage.clickOnRegister();
    createAccountPage.verifyMyAccountText();

    }

}
