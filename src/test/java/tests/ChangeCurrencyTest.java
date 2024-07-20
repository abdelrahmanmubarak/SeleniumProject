package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

import java.time.Duration;

public class ChangeCurrencyTest extends TestBase{

    HomePage homeObject;
    ProductDetailsPage productDetailsPageObject;
    String productNameBreadCrumb ="MacBook";
    String productName = "mac";
    SearchPage searchPageObject;


    @Test(priority = 1)
    public void userCanChangeCurrency(){
        homeObject = new HomePage(driver);
        homeObject.changeCurrency();
    }
    @Test(priority = 2 )
    public void userCanSearchUsingAutoSuggest() throws InterruptedException {
        searchPageObject = new SearchPage(driver);
        productDetailsPageObject = new ProductDetailsPage(driver);
        searchPageObject.searchUsingAutoSuggest(productName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(productDetailsPageObject.productNameBreadCrumb.getText()
                .contains(productNameBreadCrumb));
        Thread.sleep(1000);
        Assert.assertTrue(productDetailsPageObject.productPriceLbl
                .getText().contains("€"));
        System.out.println(productDetailsPageObject.productPriceLbl
                .getText());

    }

}
