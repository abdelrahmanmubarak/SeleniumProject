package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }
        @FindBy(id = "FriendEmail")
    WebElement emailFriendTxtBox;
    @FindBy(id = "PersonalMessage")
    WebElement personalMessageTxtBox;
    @FindBy(name = "send-email")
    WebElement sendEmailBtn;
    @FindBy(css = "div.result")
   public WebElement messageNotification;

    public void sendEmailToFriend(String friendEmail, String personalMessage){
        setTextInTxtBox(emailFriendTxtBox,friendEmail);
        setTextInTxtBox(personalMessageTxtBox,personalMessage);
        clickOnButton(sendEmailBtn);
    }
}
