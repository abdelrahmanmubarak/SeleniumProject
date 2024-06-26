package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.time.Duration;

public class UserRegistrationTest extends TestBase{

    String firstName = "Ahmed";
    String lastName = "Ali";
    String email = "Almiolaghbnmkl@test.local";
    String password = "1234567";
    //Take Objects from the Pages you want to test
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully() throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.registration(firstName,lastName, email,password);
        Assert.assertTrue(registerObject.successMessage.getText()
                .contains("Your registration completed"));

    }
    @Test(dependsOnMethods = {"userCanRegisterSuccessfully"})
    public void registeredUserCanLogOut() throws InterruptedException {
        registerObject = new UserRegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        registerObject.userLogOut();

    }
    @Test(dependsOnMethods = {"registeredUserCanLogOut"})
    public void registeredUserCanLoginIn(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email,password);
        Assert.assertTrue(registerObject.logOutLink.isDisplayed());
    }
    @Test(dependsOnMethods = {"registeredUserCanLoginIn"})
    public void registeredUserCanLogOutAgain() throws InterruptedException {
        registerObject = new UserRegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        registerObject.userLogOut();
    }
}
