package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchPageObject;
    ProductDetailsPage productDetailsPageObject;
    @Test
    public void userCanSearchForProduct(){
        searchPageObject = new SearchPage(driver);
        productDetailsPageObject = new ProductDetailsPage(driver);
        searchPageObject.productSearch(productName);
        searchPageObject.openProductDetailsPage();
        Assert.assertTrue(productDetailsPageObject.productNameBreadCrumb
        .getText().equalsIgnoreCase(productName));
    }
}
