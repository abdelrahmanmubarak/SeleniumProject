package tests;

import data.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

import java.io.IOException;

public class LoginTestUsingExcelData extends TestBase{
    HomePage homeObj;
    LoginPage loginObj;
    UserRegistrationPage regObj;
    @DataProvider(name="UserData")
    public Object[][] userRegisterData() throws IOException {

        ExcelReader er = new ExcelReader();
        return er.getExcelData();
    }
    @Test(dataProvider = "UserData")
    public void userCanLoginUsingExcelData(String email,String password){
        homeObj = new HomePage(driver);
        homeObj.openLoginPage();
        loginObj = new LoginPage(driver);
        loginObj.userLogin(email, password);
        regObj = new UserRegistrationPage(driver);
        regObj.userLogOut();

    }
}
