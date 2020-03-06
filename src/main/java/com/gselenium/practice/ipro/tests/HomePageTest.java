package com.gselenium.practice.ipro.tests;

import com.gselenium.practice.ipro.pageobjects.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1, description = "verify if logo is displayed")
    public void verifyHomepageLogo() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getLogo(), "Logo is not displayed on the page");
        System.out.println("Test #1: Logo is displayed:  --> " + homePage.getLogo());
    }

    @Test(priority = 2, description = "verify version number ")
    public void verifyHomepageTopPadHeader() {
        HomePage homePage = new HomePage(driver);
        System.out.println("Test #2 --> Print header text and version is displayed: " + homePage.getTopPadHeader());
    }

    @Test(priority = 3, description = "verify home page name")
    public void verifyHomepageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "IPRO", "Test #2 --> Title is not matched");
        System.out.println("Test #3 --> Print Home Page title: " + title);
    }

    @Test(priority = 4, description = "verify the 1st part from Home page text")
    public void verifyHomepageText() {
        String text = driver.findElement(By.xpath("//li[contains(text(),'The I-PRO Proficiency scheme consists of both samples and online assessment.')]")).getText();
        Assert.assertEquals(text, "The I-PRO Proficiency scheme consists of both samples and online assessment.", "Test #3 --> Title is not matched");
        System.out.println("Test #4 --> Print Home Page text: " + text);
    }

    @Test(priority = 5, description = "verify if 4 main buttons presented on the Home screen")
    public void verifyHomepageButtons() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getContactUs(), "Button is not displayed on the page");
        System.out.println("Test #5: 'Contact Us' is displayed:  --> " + homePage.getContactUs());
        Assert.assertTrue(homePage.getHome(), "Button is not displayed on the page");
        System.out.println("         ' HOME' is displayed:  --> " + homePage.getHome());
        Assert.assertTrue(homePage.getProficiency(), "Button is not displayed on the page");
        System.out.println("         ' Proficiency' is displayed:  --> " + homePage.getProficiency());
        Assert.assertTrue(homePage.getSignInHome(), "Button is not displayed on the page");
        System.out.println("         ' Sign In' is displayed:  --> " + homePage.getSignInHome());
    }
}
