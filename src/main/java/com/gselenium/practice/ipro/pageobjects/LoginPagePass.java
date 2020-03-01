package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class LoginPagePass extends BasePage {
    @FindBy(css = "button[class='btn btn-primary']")
    WebElement btnGetStarted;
    @FindBy(css = "input[type=text][name='loginEmail']")
    WebElement username;
    @FindBy(css = "input[type=password][name='loginPassword']")
    WebElement password;
    @FindBy(css = "body > app-root > div.container2 > app-signin > div > div > form > button")
    WebElement btnLogin;
    @FindBy(css = "a[href='assets/I-PRO_Insert_ internal_alpha.pdf']")
    WebElement herePDFInstructionLink;

    public LoginPagePass(WebDriver driver) {
        super(driver);
    }
    //Use the correct login
    public void login(String user, String password) {
        //click Get Started button
        click(btnGetStarted);
        //Change the style back after few milliseconds
        highlightElementTime(btnLogin, "blue");
        //insert text to user name element
        fillText(username, user);
        //insert text to user name element
        fillText(this.password, password);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //click the login button
        click(btnLogin);
    }
    public void getHerePDFInstructionLink() {
        click(herePDFInstructionLink);
        highlightElementTime(herePDFInstructionLink, "blue");
        //Create an ArrayList and store the open tabs
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//below code will switch to new tab
        driver.switchTo().window(tabs.get(1));
        System.out.println("Text from link is: " + driver.getCurrentUrl());
//perform whatever actions you want in new tab then close it
        driver.close();
//Switch back to your original tab
        driver.switchTo().window(tabs.get(0));
        System.out.println("If the 'here'-link is displayed after the valid login: " + herePDFInstructionLink.isDisplayed() +" and user back to the previous tab: " + driver.getCurrentUrl());
    }
}
