package com.gselenium.practice.ipro.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    //before class we open the driver
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/alenka/automation/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.e-sperm.com/I-PRO/#/");
    }
    /*
     * This method will run after each test,
     * it will take screen shot only for tests that failed
     */
    @AfterMethod
    public void failedTest(ITestResult result) {
        //check if the test failed
        if (result.getStatus() == ITestResult.FAILURE ){
            TakesScreenshot ts = (TakesScreenshot)driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile, new File("/Users/alenka/Desktop/Screenshots/"+result.getName()+".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //result.getname() method will give you current test case name.
            //./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
        }
    }
    //after class we close the driver
   @AfterClass
    public void tearDown() {
       driver.quit();
    }
}
