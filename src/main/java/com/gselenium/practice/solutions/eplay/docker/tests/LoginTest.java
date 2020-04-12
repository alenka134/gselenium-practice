package com.gselenium.practice.solutions.eplay.docker.tests;

import com.gselenium.practice.solutions.eplay.docker.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //This test status is "enabled = false", the test will be disabled, for switch ON this test--> , enabled = false should be deleted
    @Test(priority = 1, description = "login 'lena' insufficient permissions - the 1st try", enabled = false)
    public void loginFailed() {
        //login insufficient permissions - the 1st try
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lena@informup.com", "a1234567");
        System.out.println("Test #1: Login Fail");
    }

    @Test(priority = 2, description = "get and assert the message: 'username or password was incorrect' ")
    public void loginFailedMessage() {
        //Should check that we get right message
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lena1@informup.com", "a1234567");

        LoginPage loginPage1 = new LoginPage(driver);
        String actual = loginPage1.getErrorMessage();
        String expected = "Sorry, either your username or password was incorrect.";

        Assert.assertEquals(actual, expected);
        System.out.println("Test #2 --> An actual message is: " + actual);
    }

    @Test(priority = 3, description = "verify home page name")
    public void verifyHomepageTitle() {
        //For Fail test use: string "looo"
        //For Pass test use: string "Log In | ePly"
        String title = driver.getTitle();

        Assert.assertEquals(title, "Log In | ePly", "Test #3 --> Title is not matched");
        System.out.println("Test #3 --> Print Home Page title: " + title);

    }

    @Test(priority = 4, description = "verify if logo is displayed")
    public void verifyHomepageLogo() {

        LoginPage loginPage = new LoginPage(driver);
        //Test -> Pass, the Logo is displayed, it's TRUE
        Assert.assertTrue(loginPage.getLogo(), "Logo is not displayed on the page");
        //For Fail Test, use "assertFalse" so Expected:false, but Actual:true
        //Assert.assertFalse(loginPage.getLogo(), "Logo is not displayed on the page");

        System.out.println("Test #4 --> " + loginPage.getLogo());
    }

    //Dependency example: test will run only if the method "verifyHomepageLogo" passes
    @Test(priority = 5, dependsOnMethods = {"verifyHomepageLogo"})
    public void verifyPageTitle() {
        String title = driver.getTitle();

        Assert.assertEquals(title, "Log In | ePly", "Test FAIL --> Title is not matched");
        System.out.println("Test #5 PASS --> Home Page title is: " + title);
        //For Fail test and accept the alert message "Test FAIL --> Title is not matched", please use expected: "any word"
    }

    @Test(priority = 6, dependsOnMethods = {"verifyHomepageLogo"})
    public void verifyFailHomePageLogo() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertFalse(loginPage.getLogo(), "Test #6 FAIL --> Logo is displayed");
    }

    //AlwaysRun=true, test will run even all dependsOnMethods were failed
    @Test(priority = 7, dependsOnMethods = {"verifyFailHomePageLogo"}, description = "test run anyway", alwaysRun = true)
    public void alwaysRunLogIn() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.getLogo(), "Test #7 Run --> Logo is displayed");
    }
}
