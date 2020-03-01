package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFailed extends BasePage {
    @FindBy(css = "button[class='btn btn-primary']")
    WebElement btnGetStarted;
    @FindBy(css = "button[class='signInBtn']")
    WebElement btnSignIn;
    @FindBy(css = "input[type=text][name='loginEmail']")
    WebElement username;
    @FindBy(css = "input[type=password][name='loginPassword']")
    WebElement password;
    @FindBy(xpath = "//a[text()='Contact us']")
    WebElement contactUsLink;
    @FindBy(css = "body > app-root > div.container2 > app-signin > div > div > form > button")
    WebElement btnLogin;
    @FindBy(xpath = "//a[text()='Forgot Password?']")
    WebElement forgotPasswordLink; // for now the link disabled
    @FindBy(css = "*[class='alert alert-danger alert-dismissible']")
    WebElement errorMessage;

    public LoginPageFailed(WebDriver driver) {
        super(driver);
    }

    //Actions
    // Use incorrect login
    public void login1(String user, String password) {
        //click Get Started button
        click(btnGetStarted);
        //Change the style back after few milliseconds
       // highlightElementTime(btnGetStarted, "blue");
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
      //  click(btnLogin);
    }
    public void login2(String user, String password) {
        //click Get Started button
        driver.get("http://www.e-sperm.com/I-PRO/#/signin");
        //insert text to user name element
        fillText(username, user);
        //insert text to user name element
        fillText(this.password, password);
    }
    public String getErrorMessage() {
        click(forgotPasswordLink);
        System.out.println("Error message is: " + errorMessage.getText());
        return errorMessage.getText();
    }
    public void openContactUsPage(){
        click(contactUsLink);
    }

}
