package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CreateAccountPage extends HomePage {
    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstNameLink;
    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastNameLink;
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordLink;
    @FindBy(xpath = "//input[@id='address1']")
    WebElement addressLink;
    @FindBy(xpath = "//input[@id='city']")
    WebElement cityLink;
    @FindBy(xpath = "//select[@id='id_state']")
    WebElement stateLink;
    @FindBy(xpath = "//input[@id='postcode']")
    WebElement zipPostalLink;
    @FindBy(xpath = "//select[@id='id_country']")
    WebElement countryLink;
    @FindBy(xpath = "//input[@id='phone_mobile']")
    WebElement mobilePhoneLink;
    @FindBy(xpath = "//button[@id='submitAccount']")
    WebElement registerLink;
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailCreateAccLink;
    @FindBy(xpath = "//button[@id='SubmitCreate']")
    WebElement createAccountLink;
    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    WebElement myAccountTextLink;

    public void fillMandetoryFields() {
        Reporter.log("Entering firstname" + firstNameLink.toString()+ "<br>");
        pmSendTextToElement(firstNameLink, "James");
        Reporter.log("Entering lastname" + lastNameLink.toString()+ "<br>");
        pmSendTextToElement(lastNameLink, "Bond");
        Reporter.log("Entering password" + passwordLink.toString()+ "<br>");
        pmSendTextToElement(passwordLink, "Prime123");
        Reporter.log("Entering address" + addressLink.toString()+ "<br>");
        pmSendTextToElement(addressLink, "999 Prime Road");
        Reporter.log("Entering city" + cityLink.toString()+ "<br>");
        pmSendTextToElement(cityLink, "London");
        Reporter.log("Selecting the state" + stateLink.toString()+ "<br>");
        pmSelectByVisibleTextFromDropDown(stateLink, "Florida");
        Reporter.log("Entering postalcode" + zipPostalLink.toString()+ "<br>");
        pmSendTextToElement(zipPostalLink, "12345");
        Reporter.log("Entering contact number" + mobilePhoneLink.toString()+ "<br>");
        pmSendTextToElement(mobilePhoneLink, "01234567891");
    }

    public void clickOnRegister() {
        Reporter.log("Clicking on register link" + registerLink.toString()+ "<br>");
        pmClickOnElement(registerLink);
    }
    public void verifyMyAccountText(){
        Reporter.log("Verifying the message" + myAccountTextLink.toString()+ "<br>");
        pmVerifyElements(myAccountTextLink,"MY ACCOUNT", "Message is not displayed correctly" );
    }
}
