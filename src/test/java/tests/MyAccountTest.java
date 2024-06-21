package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

import java.time.Duration;

public class MyAccountTest extends TestBase{
    //Take Objects from the Pages you want to test
    HomePage homeObject;
    UserRegistrationPage registerObject;
    MyAccountPage myAccountObject;
    LoginPage loginObject;

    String oldPassword = "12345678";
    String newPassword = "123456789";
    String firstName = "Ahmed";
    String lastName = "Ali";
    String email= "Emad23@test.com";
    @Test(priority = 1)
    public void userCanRegisterSuccessfully() throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.registration(firstName,lastName, email,oldPassword);
        Assert.assertTrue(registerObject.successMessage.getText()
                .contains("Your registration completed"));
    }
    @Test(priority = 2)
    public void registeredUserCanChangePassword(){
        myAccountObject = new MyAccountPage(driver);
        registerObject.openMyAccountPage();
        myAccountObject.openChangePasswordPage();
        myAccountObject.changePassword(oldPassword,newPassword);
        Assert.assertTrue(myAccountObject.resultLbl.getText()
                .contains("Password was changed"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        myAccountObject.closeNotificationBar();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


    }
    @Test(priority = 3)
    public void registeredUserCanLogOut() throws InterruptedException {
        registerObject = new UserRegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        registerObject.userLogOut();

    }
    @Test(priority = 4)
    public void registeredUserCanLoginIn(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email,newPassword);
        Assert.assertTrue(registerObject.logOutLink.isDisplayed());


    }
}
