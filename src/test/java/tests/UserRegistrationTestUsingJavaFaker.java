package tests;

import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;
import java.time.Duration;

public class UserRegistrationTestUsingJavaFaker extends TestBase{
    //Take Objects from the Pages you want to test
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();

    @Test(priority = 1,alwaysRun = true)
    public void userCanRegisterSuccessfully() throws IOException, ParseException {


        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.registration(firstname,lastname,email,password);
        System.out.println("The User Data is:\n" + "Firstname: " + firstname + "\n" +
                "Secondname: " + lastname
                + "\n" + "Email: " + email + "\n" + "Password: " + password);



        Assert.assertTrue(registerObject.successMessage.getText()
                        .contains("Your registration completed"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        registerObject.userLogOut();
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email,password);
        Assert.assertTrue(registerObject.logOutLink.isDisplayed());
        registerObject.userLogOut();
    }

}
