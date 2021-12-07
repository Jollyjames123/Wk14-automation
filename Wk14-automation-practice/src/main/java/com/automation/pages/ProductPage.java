package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProductPage extends HomePage {
    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]/div[1]/div[2]/h5[1]/a[1]")
    WebElement blouseLink;
    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]/div[1]/div[2]/h5[1]/a[1]")
    WebElement printedDressLink;
    @FindBy(xpath = "//a[contains(text(),'Printed Chiffon Dress')]")
    WebElement printedChiffonDressLink;
    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[5]/div[1]/div[2]/h5[1]/a[1]")
    WebElement printedSummerDressLink;
    @FindBy(xpath = "//i[@class='icon-plus']")
    WebElement blouseQtyLink;
    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement printedDressQtyFieldLink;
    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement printedChiffonDressQtyFieldLink;
    @FindBy(xpath = "//i[@class='icon-plus']")
    WebElement printedSummerDressQty;
    @FindBy(id = "group_1")
    WebElement printedSummerDressSize;
    @FindBy(xpath = "(//a[@id='color_14'])[1]")
    WebElement printedSummerDressColour;
    @FindBy(id = "group_1")
    WebElement printedChiffonDressSize;
    @FindBy(xpath = "(//a[@id='color_15'])[1]")
    WebElement printedChiffonDressColour;
    @FindBy(id = "group_1")
    WebElement printedDressSize;
    @FindBy(xpath = "(//a[@id='color_13'])[1]")
    WebElement printedDressColour;
    @FindBy(xpath = "(//select[@id='group_1'])[1]")
    WebElement blouseSize;
    @FindBy(xpath = "(//a[@id='color_8'])[1]")
    WebElement blouseColour;
    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "(//h2[normalize-space()='Product successfully added to your shopping cart'])[1]")
    WebElement popUpMessageTextLink;
    @FindBy(xpath = "//span[@title='Close window']")
    WebElement popUpCloseButtonLink;


    public void clickOnTheProduct(String product) {
        if (product.equalsIgnoreCase("Blouse")) {
            pmClickOnElement(blouseLink);
        } else if (product.equalsIgnoreCase("Printed Dress")) {
            pmClickOnElement(printedDressLink);
        } else if (product.equalsIgnoreCase("Printed Chiffon Dress")) {
            pmClickOnElement(printedChiffonDressLink);
        } else if (product.equalsIgnoreCase("Printed Summer Dress with Price $28.98")) {
            pmClickOnElement(printedSummerDressLink);
        }
    }

    public void changeQty(String qty) {
        if (qty.equalsIgnoreCase("2")) {
            pmClickOnElement(blouseQtyLink);
        } else if (qty.equalsIgnoreCase("3")) {
            pmClearTextFromElement(printedDressQtyFieldLink);
            pmSendTextToElement(printedDressQtyFieldLink, "3");
        } else if (qty.equalsIgnoreCase("4")) {
            pmClearTextFromElement(printedChiffonDressQtyFieldLink);
            pmSendTextToElement(printedChiffonDressQtyFieldLink, "4");
        } else if (qty.equalsIgnoreCase("2")) {
            pmClickOnElement(printedSummerDressQty);
        }
    }

    public void selectSize(String size)  {
        if (size.equalsIgnoreCase("M")) {
            pmSelectByVisibleTextFromDropDown(blouseSize, "M");
            } else if (size.equalsIgnoreCase("L")) {
            //pmClickOnElement(printedDressSize);
            pmSelectByVisibleTextFromDropDown(printedDressSize, "L");
            //Thread.sleep(2000);
        } else if (size.equalsIgnoreCase("S")) {
            //pmClickOnElement(printedChiffonDressSize);
            pmSelectByVisibleTextFromDropDown(printedChiffonDressSize, "S");
            //Thread.sleep(2000);
        } else if (size.equalsIgnoreCase("M")) {
            pmSelectByVisibleTextFromDropDown(printedSummerDressSize, "M");
            //Thread.sleep(2000);
        }
    }

    public void selectColour(String colour) {
        if (colour.equalsIgnoreCase("White")) {
            pmClickOnElement(blouseColour);
        } else if (colour.equalsIgnoreCase("Orange")) {
            pmClickOnElement(printedDressColour);
        } else if (colour.equalsIgnoreCase("Green")) {
            pmClickOnElement(printedChiffonDressColour);
        } else if (colour.equalsIgnoreCase("Blue")) {
            pmClickOnElement(printedSummerDressColour);
        }
    }

    public void addToCart() throws InterruptedException {
        Reporter.log("Adding to cart" + addToCartButton.toString() + "<br>");
        pmClickOnElement(addToCartButton);
        Thread.sleep(3500);
    }

    public void addingToTheCartSuccessfully(String product, String qty, String size, String colour) throws InterruptedException {

        clickOnTheProduct(product);
        changeQty(qty);
        selectSize(size);
        selectColour(colour);
        addToCart();
        Thread.sleep(3500);
        verifyPopUpMessage();
        Thread.sleep(3500);
        closeThePopUpMessage();
    }

    public void verifyPopUpMessage() throws InterruptedException {
        Reporter.log("Verifying the popup Message" + popUpMessageTextLink.toString() + "<br>");
        pmVerifyElements(popUpMessageTextLink, "Product successfully added to your shopping cart", "Page is not correctly displayed");
        Thread.sleep(3500);
    }

    public void closeThePopUpMessage() {
        Reporter.log("Closing the popup message" + popUpCloseButtonLink.toString() + "<br>");
        pmClickOnElement(popUpCloseButtonLink);
    }
}
