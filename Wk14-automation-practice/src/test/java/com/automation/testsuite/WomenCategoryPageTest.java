package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.*;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

/**
 * 3. WomenCategoryPageTest
 * Inside WomenCategoryPageTest class create following testmethods
 * 1. verifyUserShouldNavigateToWomenCategoryPageSuccessfully()
 *  Click on WOMEN tab
 *  Verify "WOMWN" text
 */
@Listeners(CustomListeners.class)
public class WomenCategoryPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    WomenCategoryPage womenCategoryPage;
    ProductPage productPage;

    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
        womenCategoryPage = new WomenCategoryPage();
        productPage = new ProductPage();
    }
    @Test
    public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully(){
        homePage.clickOnWomenTab();
        womenCategoryPage.verifyWomenText();
    }
/**
 * 2. verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty,
 * String size, String colour)
 *  Click on WOMEN tab
 *  Click on the product "product"
 *  Change quantity "qty"
 *  Select size "size"
 *  Select colour "colour"
 *  Click on Add To Cart Button
 *  Popup will desplay
 *  Vetify the message "Product successfully added to your shopping cart"
 *  Click on X button and close the popup
 */
@Test(priority = 1, dataProvider = "productsdata", dataProviderClass = TestData.class)
public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String size, String colour) throws InterruptedException {
homePage.clickOnWomenTab();
productPage.addingToTheCartSuccessfully(product,qty,size,colour);
//productPage.clickOnTheProduct(product);
//productPage.changeQty(qty);
//productPage.selectSize(size);
//productPage.selectColour(colour);
//productPage.addToCart();
//Thread.sleep(4000);
//productPage.verifyPopUpMessage();
//Thread.sleep(4000);
//productPage.closeThePopUpMessage();

}
}
