package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

    HomePage homeObject;
    ContactUsPage contactUsObject;
    String fullName = "Abdoul";
    String email = "ali1@test.local";
    String enquiry = "Hello Admin, This is for Test";

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Contact Us Test Case")
    @Link(name = "Jira Ticket",url = "https://google.com")



    public void userCanContactUs() throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.openContactUsPage();
        contactUsObject = new ContactUsPage(driver);
        contactUsObject.contactUs(fullName,email,enquiry);
        Assert.assertTrue(contactUsObject.successMessage.getText()
        .contains("Your enquiry has been successfullyyy sent to the store owner."));
        Thread.sleep(3000);
    }

}
