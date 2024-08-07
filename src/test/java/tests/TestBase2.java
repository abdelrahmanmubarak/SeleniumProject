package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.Helper;

import java.io.IOException;

public class TestBase2 {

   public static WebDriver driver;



   @BeforeMethod
   @Parameters({"browser"})
    public void setUp( @Optional("chrome") String browserName){
      if (browserName.equalsIgnoreCase("chrome")){
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.get("https://demo.nopcommerce.com/");

      }
      else if (browserName.equalsIgnoreCase("firefox")){
         driver = new FirefoxDriver();
          //driver.manage().window().maximize();
          driver.get("https://demo.nopcommerce.com/");
      }
      else if (browserName.equalsIgnoreCase("safari")){
          driver = new SafariDriver();
          driver.manage().window().maximize();
          driver.get("https://demo.nopcommerce.com/");
      }


   }

   @AfterMethod
    public void screenShotOnFailure(ITestResult result) throws IOException {
       if (result.getStatus()==ITestResult.FAILURE){
           System.out.println("Failed");
           System.out.println("Taking Screenshot....");
           Helper.captureScreenShot(driver, result.getName());
       }

   }
  @AfterMethod
    public void closeDriver(){
       driver.quit();
   }
}
