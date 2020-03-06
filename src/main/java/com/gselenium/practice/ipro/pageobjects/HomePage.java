package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "body > app-root > div.container2 > app-home > div > h2 > img")
    WebElement logo;
    @FindBy(css = "a[href='#/']")
    WebElement linkHome;
    @FindBy(css = "a[href='#/contact']")
    WebElement linkContactUs;
    @FindBy(xpath = "//a[text()='Proficiency Test']")
    WebElement linkProficiency;
    @FindBy(css = "button[class='signInBtn']")
    WebElement btnSignInHome;
    @FindBy(css = "div[class='TopPad']")
    WebElement topPadHeader;
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Verification if logo presented on home page
    public boolean getLogo() {
        logo.isDisplayed();
        click(logo);
        //Change the style back after few milliseconds
        highlightElementTime(logo, "orange");
        return true;
    }
    public boolean getTopPadHeader() {
        topPadHeader.isDisplayed();
        click(topPadHeader);
        //Change the style back after few milliseconds
        highlightElementTime(topPadHeader, "orange");
        System.out.println(getText(topPadHeader));
        return true;
    }
    public boolean getHome() {
        linkHome.isDisplayed();
        click(linkHome);
        //Change the style back after few milliseconds
        highlightElementTime(linkHome, "orange");
        return true;
    }

    public boolean getContactUs() {
        linkContactUs.isDisplayed();
        click(linkContactUs);
        //Change the style back after few milliseconds
        highlightElementTime(linkContactUs, "orange");
        return true;
    }

    public boolean getProficiency() {
        linkProficiency.isDisplayed();
        click(linkProficiency);
        //Change the style back after few milliseconds
        highlightElementTime(linkProficiency, "orange");
        return true;
    }

    public boolean getSignInHome() {
        btnSignInHome.isDisplayed();
        click(btnSignInHome);
        //Change the style back after few milliseconds
        highlightElementTime(btnSignInHome, "orange");
        return true;
    }
}
