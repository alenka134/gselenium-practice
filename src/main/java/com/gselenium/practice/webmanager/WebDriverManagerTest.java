package com.gselenium.practice.webmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebDriverManagerTest {
    @Test
    public void WebDriverManagerTest()
    {
        //Set the path to Chrome driver - traditional path
        //System.setProperty("webdriver.chrome.driver", "E:\\Sandbox\\browserdrivers\\chromedriver.exe" );

        //setup the Chrome Driver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        //Create driver object for Chrome
        WebDriver driver = new ChromeDriver();

        //Navigate to a URL
        driver.get("http://toolsqa.com");

        //quit the browser
        driver.quit();
    }
}
