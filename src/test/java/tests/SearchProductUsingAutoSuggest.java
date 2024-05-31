package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

import java.time.Duration;

public class SearchProductUsingAutoSuggest extends TestBase{

    String productName = "mac";
    String productNameBreadCrumb ="MacBook";
    SearchPage searchPageObject;
    ProductDetailsPage productDetailsPageObject;
    @Test
    public void userCanSearchUsingAutoSuggest(){
        searchPageObject = new SearchPage(driver);
        productDetailsPageObject = new ProductDetailsPage(driver);
        searchPageObject.searchUsingAutoSuggest(productName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(productDetailsPageObject.productNameBreadCrumb.getText()
        .contains(productNameBreadCrumb));

    }
}
