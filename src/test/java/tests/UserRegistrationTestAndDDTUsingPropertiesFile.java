package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.LoadPropertiesFromFile;

import java.time.Duration;

public class UserRegistrationTestAndDDTUsingPropertiesFile extends TestBase{

    String firstname = LoadPropertiesFromFile.userData.getProperty("firstname");
    String lastname = LoadPropertiesFromFile.userData.getProperty("lastname");
    String email = LoadPropertiesFromFile.userData.getProperty("email");
    String password = LoadPropertiesFromFile.userData.getProperty("password");
    //Take Objects from the Pages you want to test
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully() throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.registration(firstname,lastname, email,password);
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
