package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }
    @FindBy(linkText = "Register")
    WebElement registerLink;
    @FindBy(xpath = "//a[@href='/login?returnUrl=%2F']")
    WebElement loginLink;
    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;
    @FindBy(id ="customerCurrency" )
    WebElement currencyDropDownList;
    @FindBy(linkText = "Computers")
    WebElement computersMenu;
    @FindBy(linkText = "Notebooks")
   public WebElement noteBooksMenu;

    public void openRegistrationPage(){

        clickOnButton(registerLink);
    }
    public void openLoginPage(){
        clickOnButton(loginLink);
    }

    public void openContactUsPage(){
        scrollToBottom();
        clickOnButton(contactUsLink);
    }

    public void changeCurrency(){
        select = new Select(currencyDropDownList);
        select.selectByVisibleText("Euro");
    }
    public void selectNoteBooksMenu(){
        action.moveToElement(computersMenu).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        action.moveToElement(noteBooksMenu).click().build().perform();
    }



}
