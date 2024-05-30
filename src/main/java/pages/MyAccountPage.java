package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends PageBase {

    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        jsExecutor = (JavascriptExecutor) driver;
    }

    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;

    @FindBy(id = "OldPassword")
    WebElement oldPasswordTxt;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTxt;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPasswordTxt;

    @FindBy(css = "button.button-1.change-password-button")
    WebElement changePasswordBtn;

    @FindBy(css = "p.content")
    public WebElement resultLbl;

    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
    public WebElement notificationCloseBtn;

    public void openChangePasswordPage() {
        waitUntilClickable(changePasswordLink);
        clickUsingJavaScript(changePasswordLink);
    }

    public void changePassword(String oldPassword, String newPassword) {
        setTextInTxtBox(oldPasswordTxt, oldPassword);
        setTextInTxtBox(newPasswordTxt, newPassword);
        setTextInTxtBox(confirmPasswordTxt, newPassword);
        waitUntilClickable(changePasswordBtn);
        clickUsingJavaScript(changePasswordBtn);
    }

    public void closeNotificationBar() {
        try {
            waitUntilClickable(notificationCloseBtn);
            clickUsingJavaScript(notificationCloseBtn);
            // Wait for the notification to disappear
            wait.until(ExpectedConditions.invisibilityOf(notificationCloseBtn));
        } catch (Exception e) {
            System.out.println("Notification bar is not present or clickable.");
        }
    }

    private void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void clickUsingJavaScript(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        jsExecutor.executeScript("arguments[0].click();", element);
    }


}
