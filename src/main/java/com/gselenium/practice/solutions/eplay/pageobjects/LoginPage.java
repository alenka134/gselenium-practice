package com.gselenium.practice.solutions.eplay.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "#form > header > div > div > div > a > img")
    WebElement logo;
    @FindBy(css = "#body_Username")
    WebElement username;
    @FindBy(css = "#body_Password")
    WebElement password;
    @FindBy(css = "#body_SubmitButton")
    WebElement btnLogin;
    @FindBy(css = "#body_ForgotPasswordButton")
    WebElement forgotYourPasswordLink;
    @FindBy(css = "#body_ErrorMessage")
    WebElement errorMessage;

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    //Actions
    public boolean getLogo() {
        logo.isDisplayed();
        return true;
    }

    public void login(String user, String password) {
        //insert text to user name element
        fillText(username, user);
        //insert text to user name element
        fillText(this.password, password);
        //click the login button
        click(btnLogin);

    }

    public String getErrorMessage() {

        return errorMessage.getText();
    }

    public void forgotYourPassword() {
        //click the login button
        click(forgotYourPasswordLink);
    }
}
