package com.gselenium.practice.ipro_automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(css = "body > app-root > div.container2 > app-home > div > h2 > img")
    WebElement logo;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Verification if logo presented on home page
    public boolean getLogo() {
        logo.isDisplayed();
        click(logo);
        //Change the style back after few milliseconds
        highlightElementTime(logo, "orange");
        System.out.println("Logo is displayed on HomePage: " + logo.isDisplayed());
        return true;
    }
}
