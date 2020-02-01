package com.gselenium.practice.solutions.eplay.tests;

import com.gselenium.practice.solutions.eplay.pageobjects.ForgotPasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPswTest extends BaseTest {

    @Test(priority = 1, description = "Forgot password an alert message is presented")
    public void ForgotPasswordTest() {
        //login insufficient permissions

        ForgotPasswordPage fpTest = new ForgotPasswordPage(driver);
        fpTest.submitForgotPassword("alenka@gmail.com");

        String actual = fpTest.isMessageAppear();
        String expected = "Sorry, either your username or password was incorrect.";

        Assert.assertEquals(actual, expected);
        System.out.println("Test #1 --> An actual message is: " + actual);
    }
}


