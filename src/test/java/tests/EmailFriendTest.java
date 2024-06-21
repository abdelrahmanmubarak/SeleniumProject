package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class EmailFriendTest extends TestBase{
    String firstName = "Ahmed";
    String lastName = "Ali";
    String email = "englishtest@test.local";
    String password = "1234567";
    String productName = "mac";
    String productNameBreadCrumb ="MacBook";
    SearchPage searchPageObject;
    ProductDetailsPage productDetailsPageObject;
    EmailFriendPage emailObject;
    HomePage homeObject;
    UserRegistrationPage registerObject;
    String friendEmail = "testfor123@test.local";
    String personalMessage = "Hello Ahmed, this is for Test";
    //1. User should be registered
    @Test(priority = 1)
    public void userCanRegisterSuccessfully() throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.registration(firstName,lastName, email,password);
        Assert.assertTrue(registerObject.successMessage.getText()
                .contains("Your registration completed"));
    }
    //2. User Search
    @Test(priority = 2)
    public void userCanSearchUsingAutoSuggest(){
        searchPageObject = new SearchPage(driver);
        productDetailsPageObject = new ProductDetailsPage(driver);
        searchPageObject.searchUsingAutoSuggest(productName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(productDetailsPageObject.productNameBreadCrumb.getText()
                .contains(productNameBreadCrumb));

    }

    //3.Email A Friend
    @Test(priority = 3)
    public void registeredUserCanSendEmailToFriend(){
        productDetailsPageObject.openSendEmail();
        emailObject = new EmailFriendPage(driver);
        emailObject.sendEmailToFriend(friendEmail,personalMessage);
        Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
    }

    //4.User Logout
    @Test(priority = 4)
    public void registeredUserCanLogOut() throws InterruptedException {
        registerObject = new UserRegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        registerObject.userLogOut();
    }

}
