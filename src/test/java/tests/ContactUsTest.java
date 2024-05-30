package tests;

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
    public void userCanContactUs(){
        homeObject = new HomePage(driver);
        homeObject.openContactUsPage();
        contactUsObject = new ContactUsPage(driver);
        contactUsObject.contactUs(fullName,email,enquiry);
        Assert.assertTrue(contactUsObject.successMessage.getText()
        .contains("Your enquiry has been successfully sent to the store owner."));
    }

}
