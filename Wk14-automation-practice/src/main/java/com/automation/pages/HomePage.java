package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]")
    WebElement womenLink;
    @FindBy(xpath="")
    WebElement dressesLink;
    @FindBy(xpath="")
    WebElement tShirtLink;
    @FindBy(xpath="//a[contains(text(),'Sign in')]")
    WebElement signInLink;
    @FindBy(xpath="")
    WebElement logoLink;
    public void clickOnSignIn(){
        Reporter.log("Clicking on SignIn" + signInLink.toString()+ "<br>");
        pmClickOnElement(signInLink);
    }
    public void clickOnWomenTab(){
        Reporter.log("Clicking on WOMEN tab" + womenLink.toString()+ "<br>");
        pmClickOnElement(womenLink);
    }
}
