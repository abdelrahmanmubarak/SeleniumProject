package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "strong.current-item")
   public WebElement productNameBreadCrumb;
    @FindBy(css = "button.button-2.email-a-friend-button")
    WebElement emailFriendBtn;
    @FindBy(id = "price-value-4")
    public WebElement productPriceLbl;
    @FindBy (css = "div.page-title")
    public WebElement pageTitle;
    @FindBy(id = "add-to-wishlist-button-4")
    WebElement addToWishListBtn;
    @FindBy(linkText = "wishlist")
    WebElement wishListAttemptLink;

    public void openSendEmail(){
        clickOnButton(emailFriendBtn);
    }
    public void addProductToWishList(){
        clickOnButton(addToWishListBtn);
    }
    public void clickOnWishListLink(){
        clickOnButton(wishListAttemptLink);
    }
}
