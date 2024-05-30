package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //Find all Elements of the Page
    @FindBy(id = "Email")
    WebElement emailTxtBox;
    @FindBy(id = "Password")
    WebElement passwordTxtBox;
    @FindBy(css = "button.button-1.login-button")
    WebElement loginBtn;
    //Pass a String Parameters into the Method to avoid hard coded values
    public void userLogin(String email, String password){
        setTextInTxtBox(emailTxtBox,email);
        setTextInTxtBox(passwordTxtBox,password);
        clickOnButton(loginBtn);
    }

}
