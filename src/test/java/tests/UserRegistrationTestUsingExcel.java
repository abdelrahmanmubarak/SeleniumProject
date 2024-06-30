package tests;

import data.ExcelReader2;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;
import java.time.Duration;

public class UserRegistrationTestUsingExcel extends TestBase{
    //Take Objects from the Pages you want to test
    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;

    @DataProvider (name="UserData")
    public Object[][] userRegisterData() throws IOException {

        ExcelReader2 er = new ExcelReader2();
        return er.getExcelData();
    }
    @Test(priority = 1,dataProvider="UserData")
    public void userCanRegisterSuccessfully(String firstname,String lastname
    ,String email,String password) throws IOException, ParseException, InterruptedException {


        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.registration(firstname,lastname,
                email,password);
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
