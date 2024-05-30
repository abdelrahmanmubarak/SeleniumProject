package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "FullName")
    WebElement fullNameTxtBox;
    @FindBy(id = "Email")
    WebElement emailTxtBox;
    @FindBy(id = "Enquiry")
    WebElement enquiryTxtBox;
    @FindBy(name = "send-email")
    WebElement submitBtn;
    @FindBy(css = "div.result")
   public WebElement successMessage;

    public void contactUs(String fullName,String email, String enquiry){

        setTextInTxtBox(fullNameTxtBox,fullName);
        setTextInTxtBox(emailTxtBox,email);
        setTextInTxtBox(enquiryTxtBox,enquiry);
        clickOnButton(submitBtn);
    }
}
