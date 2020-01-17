package com.gselenium.practice.solutions.eplay.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    WebElement username;
    WebElement password;
    WebElement btnLogin;
    WebElement forgotYourPasswordLink;

    public LoginPage(WebDriver driver) {
        super(driver);
        username = driver.findElement(By.cssSelector("#body_Username"));
        password = driver.findElement(By.cssSelector("#body_Password"));
        btnLogin = driver.findElement(By.cssSelector("#body_SubmitButton"));
        forgotYourPasswordLink = driver.findElement(By.cssSelector("#body_ForgotPasswordButton"));
    }

    //Actions
    public void login(String user, String password) {
        //insert text to user name element
        fillText(username, user);
        //insert text to user name element
        fillText(this.password, password);
        //click the login button
        click(btnLogin);
    }

    public void forgotYourPassword() {
        //click the login button
        click(forgotYourPasswordLink);
    }
}
