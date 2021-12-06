package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class SignInPage extends HomePage {
    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Authentication')]")
    WebElement authenticationText;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailFieldLink;
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordFieldLink;
    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement signInTab;
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailCreateAccLink;
    @FindBy(xpath = "//button[@id='SubmitCreate']")
    WebElement createAccountLink;
    @FindBy(xpath = "//li[contains(text(),'An email address required.')]")
    WebElement errorMessageLink;
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOutLink;

    public void verifyAuthMessage() {
        Reporter.log("Verifying the message" + authenticationText.toString()+ "<br>");
        pmVerifyElements(authenticationText, "AUTHENTICATION", "Page is not displayed correctly");
    }

    public void enterEmail(String emailAddress) {
        Reporter.log("Entering the email : " + emailCreateAccLink.toString() + "<br>");
        pmSendTextToElement(emailCreateAccLink, emailAddress);
    }

    public void clickOnCreateAcc() {
        Reporter.log("Clicking on create account" + createAccountLink.toString() + "<br>");
        pmClickOnElement(createAccountLink);
    }

    public void enterUsername(String username) {
        Reporter.log("Entering username" + emailFieldLink.toString() + "<br>");
        pmSendTextToElement(emailFieldLink, username);
    }

    public void enterPassword(String password) {
        Reporter.log("Entering the password " + passwordFieldLink.toString() + "<br>");
        pmSendTextToElement(passwordFieldLink, password);
    }

    public void clickOnSigninButton() {
        Reporter.log("Clicking on Signin button : " + signInTab.toString() + "<br>");
        pmClickOnElement(signInTab);
    }

    public void verifyErrorMessage() {
        String errorMessage = null;
        Reporter.log("Verifing the error message : " + errorMessageLink.toString() + "<br>");
        if (errorMessage == "An email address required.") {
            pmVerifyElements(errorMessageLink, errorMessage, "Message is not displaed correctly");
        } else if (errorMessage == "Password is required.") {
            pmVerifyElements(errorMessageLink, errorMessage, "Message is not displaed correctly");
        } else if (errorMessage == "Invalid email address.") {
            pmVerifyElements(errorMessageLink, errorMessage, "Message is not displaed correctly");
        } else if (errorMessage == "Invalid email address.") {
            pmVerifyElements(errorMessageLink, errorMessage, "Message is not displaed correctly");
        }
    }

    public void loginToApplication(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickOnSigninButton();
        //verifyErrorMessage(errorMessage);
    }
    public void verifySignOutLink(){
        Reporter.log("Verifying Signout link : " + signOutLink.toString() + "<br>");
        pmVerifyElements(signOutLink, "Sign out", "SignOut Link is not displayed ");
    }
    public void clickOnSignOut(){
        Reporter.log("Clicking on SignOut : " + signOutLink.toString() + "<br>");
        pmClickOnElement(signOutLink);
    }
    public void verifySignInLink(){
        Reporter.log("Verifying SignIn link : " + signInTab.toString() + "<br>");
        pmVerifyElements(signInTab, "Sign in", "SignOut Link is not displayed ");
    }

}