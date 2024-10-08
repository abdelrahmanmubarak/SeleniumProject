package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;
import utilities.HelperClass2;

import java.io.IOException;
import java.time.Duration;

public class TestBase {

   public WebDriver driver;




   @BeforeClass
   @Parameters({"browser"})
   public void setUp(@Optional("chrome") String browserName) {
       if (browserName.equalsIgnoreCase("chrome")) {
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu");
           driver = new ChromeDriver(options);
           driver.manage().window().maximize();
           driver.get("https://testautomationu.applitools.com/learningpaths.html");
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       }
/*
      else if (browserName.equalsIgnoreCase("firefox")){
          FirefoxOptions options = new FirefoxOptions();
          if (System.getenv()!=null){
              options.addArguments("--headless","--no-sandbox","--disable-dev-shm-usage");
          }
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


   }*/

  /*@AfterMethod
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
   }*/
   }
}
