package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //Find all Elements of the Page
    @FindBy(id = "Email")
    WebElement emailTxtBox;
    @FindBy(id = "Password")
    WebElement passwordTxtBox;
    @FindBy(xpath = "//button[@class='button-1 login-button']")
   public WebElement loginBtn;
    //Pass a String Parameters into the Method to avoid hard coded values
    public void userLogin(String email, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // 10 seconds timeout
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='ico-login']")));
        setTextInTxtBox(emailTxtBox,email);
        setTextInTxtBox(passwordTxtBox,password);
        clickOnButton(loginBtn);
    }

}
