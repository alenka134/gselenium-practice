package com.gselenium.practice.solutions.eplay.tests;

import com.gselenium.practice.solutions.eplay.pageobjects.ForgotPasswordPage;
import com.gselenium.practice.solutions.eplay.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrom.driver", "/Users/alenka/automation/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.eply.com/Login/index.aspx?Logout=True");

        ForgotPasswordPage fpTest = new ForgotPasswordPage(driver);
        fpTest.submitForgotPassword("lololol@gmail.com");
        Thread.sleep(3000);

//Validation if the message "Sorry, either your username or password was incorrect..." appears on the screen

       fpTest.isMessageAppear();

       LoginPage loginPage = new LoginPage(driver);
       loginPage.forgotYourPassword();
       driver.quit();
    }
}
