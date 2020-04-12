package com.gselenium.practice.aerocube;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class GridTest {
    WebDriver driver;

    @Test
    public void setGridTest() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "/Users/alenka/automation/drivers/chromedriver80");
        // driver = new ChromeDriver();

        //Create chrome RemoteWebDriver instance instead local ChromeDriver (./chromedriver80)
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("80.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("videoName", this.getClass().getName() + "_" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss")) + ".mp4");
        capabilities.setCapability("screenResolution", "1280x1024x24");

        driver = new RemoteWebDriver(

                URI.create("http://localhost:4444/wd/hub").toURL(),

                capabilities
        );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
    }
}
