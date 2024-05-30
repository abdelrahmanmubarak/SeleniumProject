package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserRegistrationPage extends PageBase {
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;
    public UserRegistrationPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        jsExecutor = (JavascriptExecutor) driver;
    }
    @FindBy(id = "gender-male")
    WebElement genderRdoBtn;
    @FindBy(id = "FirstName")
    WebElement fnTxtBox;
    @FindBy(id = "LastName")
    WebElement lnTxtBox;
    @FindBy(id = "Email")
    WebElement emailTxtBox;
    @FindBy(id = "Password")
    WebElement passwordTxtBox;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTxtBox;
    @FindBy(id = "register-button")
    WebElement registerBtn;
    @FindBy(css = "div.result")
   public WebElement successMessage;
    @FindBy(css = "a.ico-logout")
    public WebElement logOutLink; //make it Public to be able to assert on it in the test Case
    @FindBy(css = "a.ico-account")
    WebElement myAccountLink;
    public void registration(String firstName, String lastName, String email, String password){
        clickOnButton(genderRdoBtn);
        setTextInTxtBox(fnTxtBox,firstName);
        setTextInTxtBox(lnTxtBox,lastName);
        setTextInTxtBox(emailTxtBox,email);
        setTextInTxtBox(passwordTxtBox,password);
        setTextInTxtBox(confirmPasswordTxtBox,password);
        clickOnButton(registerBtn);

    }
    public void userLogOut(){
        waitUntilClickable(logOutLink);
        clickUsingJavaScript(logOutLink);
    }
    public WebElement getLogOutLink() {
        return logOutLink;
    }
    private void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    private void clickUsingJavaScript(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    public void openMyAccountPage(){
        clickOnButton(myAccountLink);
    }



}
