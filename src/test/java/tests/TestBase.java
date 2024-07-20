package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;
import utilities.HelperClass2;

import java.io.IOException;
import java.time.Duration;

public class TestBase {

   public static WebDriver driver;




   @BeforeClass
   @Parameters({"browser"})
    public void setUp( @Optional("chrome") String browserName){
      if (browserName.equalsIgnoreCase("chrome")){
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.get("https://demo.nopcommerce.com/");
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      }
      else if (browserName.equalsIgnoreCase("firefox")){
         driver = new FirefoxDriver();
          driver.manage().window().maximize();
          driver.get("https://demo.nopcommerce.com/");
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
           System.out.println("Screenshot taken for test case: " + result.getName());
       }

   }
  @AfterClass
    public void closeDriver(){
       driver.quit();
   }
}
