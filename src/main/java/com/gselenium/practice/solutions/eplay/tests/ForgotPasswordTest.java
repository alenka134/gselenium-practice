package com.gselenium.practice.solutions.eplay.tests;

import java.util.concurrent.TimeUnit;

import com.gselenium.practice.solutions.eplay.pageobjects.ForgotPasswordPage;
import com.gselenium.practice.solutions.eplay.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ForgotPasswordTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrom.driver", "/Users/alenka/automation/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.eply.com/Login/index.aspx?Logout=True");
        //login insufficient permissions
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lena@informup.com", "a1234567");
        Thread.sleep(2000);

        loginPage = new LoginPage(driver);
        loginPage.forgotYourPassword();

        ForgotPasswordPage fpTest = new ForgotPasswordPage(driver);
        fpTest.submitForgotPassword("gal@gmail.com");
        Thread.sleep(3000);

//Validation if the message "Instructions on how to reset..." appears on the screen

        if (fpTest.isMessageAppear()) {
            System.out.println("Result: " + fpTest.isMessageAppear());
        } else {
            System.out.println("Fail");
        }
        driver.quit();
    }
}
