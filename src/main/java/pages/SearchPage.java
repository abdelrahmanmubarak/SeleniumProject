package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "small-searchterms")
    WebElement searchTxtBox;
    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;
    @FindBy(id = "ui-id-1")
    List <WebElement> productList;
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement productTitle;

    public void productSearch(String productName){
        setTextInTxtBox(searchTxtBox,productName);
        clickOnButton(searchBtn);
    }
    public void openProductDetailsPage(){
        clickOnButton(productTitle);
    }

    public void searchUsingAutoSuggest(String searchTxt){
        setTextInTxtBox(searchTxtBox,searchTxt);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-1")));
        // using get with index
        productList.get(0).click();
        // using enhanced for..loop
        /*for (WebElement productName:productList){
            productName.click();
        }*/



    }
}
