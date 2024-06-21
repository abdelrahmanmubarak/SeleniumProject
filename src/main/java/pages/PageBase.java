package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    protected WebDriver driver;
    public JavascriptExecutor jse;
    public Select select;
    public Actions action;

    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected static void setTextInTxtBox(WebElement txtBox, String value){
        txtBox.sendKeys(value);
    }

    protected void clickOnButton(WebElement btn){
        btn.click();
    }

    public void scrollToBottom(){
        jse.executeScript("scrollBy(0,2500)");

    }


}
