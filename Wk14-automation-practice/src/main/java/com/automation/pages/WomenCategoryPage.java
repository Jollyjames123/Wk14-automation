package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class WomenCategoryPage extends HomePage{
    public WomenCategoryPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//h2[contains(text(),'Women')]")
    WebElement womenTitleTextLink;

    public void verifyWomenText(){
        Reporter.log("Verifying WOMEN text"+womenTitleTextLink.toString()+"<br>");
        pmVerifyElements(womenTitleTextLink, "WOMEN", "Page is not displayed correctly");
    }
}
