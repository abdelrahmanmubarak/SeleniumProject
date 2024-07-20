package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.LoadPropertiesFromFile;
import utilities.LoadPropertiesFromFile2;

import java.time.Duration;

public class UserRegistrationTestAndDDTUsingPropertiesFileDemo2 extends TestBase{

    String firstname = LoadPropertiesFromFile2.userData.getProperty("firstname");
    String lastname = LoadPropertiesFromFile2.userData.getProperty("lastname");
    String email = LoadPropertiesFromFile2.userData.getProperty("email");
    String password = LoadPropertiesFromFile2.userData.getProperty("password");
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
        Thread.sleep(2000);

    }
    @Test(dependsOnMethods = {"userCanRegisterSuccessfully"})
    public void registeredUserCanLogOut() throws InterruptedException {
        registerObject = new UserRegistrationPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        registerObject.userLogOut();
        Thread.sleep(2000);

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
