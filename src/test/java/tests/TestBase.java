package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.Helper;

import java.io.IOException;

public class TestBase {

   public static WebDriver driver;

   @BeforeSuite
   @Parameters({"browser"})
    public void setUp( @Optional("chrome") String browserName){
      if (browserName.equalsIgnoreCase("chrome")){
         driver = new ChromeDriver();
      }
      else if (browserName.equalsIgnoreCase("firefox")){
         driver = new FirefoxDriver();
      }

       driver.get("https://demo.nopcommerce.com/");
       driver.manage().window().maximize();
   }

   @AfterMethod
    public void screenShotOnFailure(ITestResult result) throws IOException {
       if (result.getStatus()==ITestResult.FAILURE){
           System.out.println("Failed");
           System.out.println("Taking Screenshot....");
           Helper.captureScreenShot(driver, result.getName());
       }

   }
}
