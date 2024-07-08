package pages;

// Importing necessary Selenium and Java classes
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    // Protected member variables for WebDriver, JavascriptExecutor, Select, and Actions
    protected WebDriver driver;
    public JavascriptExecutor jse;
    public Select select;
    public Actions action;

    // Constructor that initializes the WebDriver and the PageFactory
    public PageBase(WebDriver driver) {
        this.driver = driver;
        // Initialize the PageFactory, which will initialize the WebElements declared in the child classes
        PageFactory.initElements(driver, this);
    }

    // Protected static method to set text in a text box WebElement
    protected static void setTextInTxtBox(WebElement txtBox, String value) {
        txtBox.sendKeys(value); // Send the specified value to the text box
    }

    // Protected method to click on a button WebElement
    protected void clickOnButton(WebElement btn) {
        btn.click(); // Click the specified button
    }

    // Public method to scroll to the bottom of the page
    public void scrollToBottom() {
        // Use the JavascriptExecutor to execute a JavaScript command that scrolls the page down by 2500 pixels
        jse.executeScript("scrollBy(0,2500)");
    }
}
