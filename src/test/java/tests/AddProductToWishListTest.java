package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

import java.time.Duration;

public class AddProductToWishListTest extends TestBase{
    String productNameUsingAutoSuggest = "mac";
    SearchPage searchPageObject;
    String productNameBreadCrumb ="MacBook";
    ProductDetailsPage productDetailsPageObject;
    WishListPage wishListPageObject;
    String productName = "Apple MacBook Pro 13-inch";




    @Test(priority = 1)
    public void userCanSearchUsingAutoSuggest(){
        searchPageObject = new SearchPage(driver);
        productDetailsPageObject = new ProductDetailsPage(driver);
        searchPageObject.searchUsingAutoSuggest(productNameUsingAutoSuggest);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(productDetailsPageObject.productNameBreadCrumb.getText()
                .contains(productNameBreadCrumb));

    }
    @Test(priority = 2)
    public void userCanAddProductToWishList(){
        productDetailsPageObject = new ProductDetailsPage(driver);
        productDetailsPageObject.addProductToWishList();
        productDetailsPageObject.clickOnWishListLink();
        wishListPageObject = new WishListPage(driver);
        Assert.assertTrue(wishListPageObject.wishListHeader.isDisplayed());
        Assert.assertTrue(wishListPageObject.productCell
                .getText().contains(productName));
    }
    @Test(priority = 3)
    public void userCanRemoveItemFromWishList(){
        wishListPageObject= new WishListPage(driver);
        wishListPageObject.removeProductFromWishList();
        Assert.assertTrue(wishListPageObject.emptyCartLbl.isDisplayed());

    }
}
