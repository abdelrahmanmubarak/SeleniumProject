package tests;

import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;
import java.time.Duration;

public class UserRegistrationTestUsingJson extends TestBase{
    //Take Objects from the Pages you want to test
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully() throws IOException, ParseException {
        JsonDataReader jsonDataReader = new JsonDataReader();
        jsonDataReader.JsonReader();

        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.registration(jsonDataReader.firstname, jsonDataReader.lastname,
                jsonDataReader.email, jsonDataReader.password);
        Assert.assertTrue(registerObject.successMessage.getText()
                .contains("Your registration completed"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        registerObject.userLogOut();
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(jsonDataReader.email, jsonDataReader.password);
        Assert.assertTrue(registerObject.logOutLink.isDisplayed());
        registerObject.userLogOut();
    }

}
