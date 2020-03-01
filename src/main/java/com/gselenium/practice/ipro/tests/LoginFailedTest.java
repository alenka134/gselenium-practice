package com.gselenium.practice.ipro.tests;

import com.gselenium.practice.ipro.pageobjects.LoginPageFailed;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFailedTest extends BaseTest {
    @Test(priority = 1, description = "Error alert message is presented", enabled = true)
    public void loginFailedTest() {
        try {
            //login incorrect
            LoginPageFailed loginPageFailed = new LoginPageFailed(driver);
            loginPageFailed.login1("kk@kkj", "4de4");
            System.out.println("Test 1: Login fail and error message is presented ");
            //verification of the error message
            String actual = loginPageFailed.getErrorMessage();
            String expected = "Error! Email or Password is incorrect\n×";

            Assert.assertEquals(actual, expected);
            System.out.println("Test1- An actual message is: " + actual);
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s " + " and the picture you can found: /Users/alenka/Desktop/Screenshots/testCaseName .jpg", e));
        }

    }

    @Test(priority = 2, description = "Navigate to Contact Us Page", alwaysRun = true)
    public void getLinkToContactUs() {
        //login incorrect> navigate to Contact Us Page
        LoginPageFailed loginPageFailed = new LoginPageFailed(driver);
        loginPageFailed.login2("lena@lll", "57575");
        loginPageFailed.openContactUsPage();
        System.out.println("Test 2: Login Fail, Contact Us page is presented ");
    }

    @Test(priority = 3, description = "verify Contact Us Page name", dependsOnMethods = {"getLinkToContactUs"})
    public void verifyContactUsPageTitle() {
        LoginPageFailed loginPageFailed = new LoginPageFailed(driver);
        loginPageFailed.login2("lena@lll", "57575");
        loginPageFailed.openContactUsPage();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://www.e-sperm.com/I-PRO/#/contact", "Test #3 --> Title is not matched");
        System.out.println("Test #3 --> The page current url is: " + currentUrl);
    }
}