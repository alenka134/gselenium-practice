package com.gselenium.practice.solutions.eplay.tests;

import com.gselenium.practice.solutions.eplay.pageobjects.ForgotPasswordPage;
import com.gselenium.practice.solutions.eplay.pageobjects.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/alenka/automation/drivers/chromedriver");
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

        loginPage.login("joho", "353535636535");  // include highLightElement(btnLogin);
        Thread.sleep(3000);

        // Take ScreenShot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Store Screenshot
        try {
            FileUtils.copyFile(screenshotFile, new File("/Users/alenka/Desktop/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
