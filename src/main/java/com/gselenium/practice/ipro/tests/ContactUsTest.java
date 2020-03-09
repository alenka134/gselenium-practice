package com.gselenium.practice.ipro.tests;

import com.gselenium.practice.ipro.pageobjects.ContactUsPage;
import com.gselenium.practice.ipro.pageobjects.LoginPageFailed;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseTest {
    @Test(priority = 1, description = "Mes e-mail verification")
    // Verify that the email, phone and address of the Mes-india are presented on the page
    public void isInfoMesEmailAppearTest() {
        try {
            LoginPageFailed loginPageFailed = new LoginPageFailed(driver);
            loginPageFailed.login2("lena@lll", "57575");
            loginPageFailed.openContactUsPage();
            ContactUsPage contactUsPage = new ContactUsPage(driver);
            contactUsPage.isInfoMesEmailAppear();
            System.out.println("Test 1: MES contact e-mail is displayed");
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s ", e));
        }
    }
    @Test(priority = 2, description = "All Contact icons verification")
    public void isContactIconsAppearTest() {
        try {
            ContactUsPage contactUsPage = new ContactUsPage(driver);
            contactUsPage.getContactIcons();
            System.out.println("Test 2: Check all contact icons");
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s ", e));
        }
    }
    @Test(priority = 3, description = "Contact form is filling and sending")
    public void fillContactUsTest() {
        try {
            ContactUsPage contactUsPage = new ContactUsPage(driver);
            contactUsPage.fillContactUs("Lena", "Tester", "elena@tester", "1234567891", "mes", "contactTest");
            System.out.println("Test 3: Contact Us form filled without problem");
            Thread.sleep(1000);
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s ", e));
        }
    }
}
