package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.io.IOException;
import java.time.Duration;

public class TestBase3 {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver.set(new SafariDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().get("https://demo.nopcommerce.com/");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void screenShotOnFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenShot(getDriver(), result.getName());
            System.out.println("Screenshot taken for test case: " + result.getName());
        }
    }

    @AfterClass
    public void closeDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
