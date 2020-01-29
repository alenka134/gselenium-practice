package com.gselenium.practice.solutions.eplay.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

    WebElement username;
    WebElement btnForgot;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        username = driver.findElement(By.cssSelector("#body_Username"));
        btnForgot = driver.findElement(By.cssSelector("#body_SubmitButton"));
    }

    //Actions
    public void submitForgotPassword(String user) {
        //insert text to user name element
        fillText(username, user);
        //click the submit button
        click(btnForgot);
    }

    //Validation
    public boolean isMessageAppear() {
        String message = driver.findElement(By.cssSelector("#body_Message")).getText();

        //check function
        if (message.contains("Instructions on how to reset your password have been sent to the email address registered with the username provided.")) {
            return true;
        }
        return false;
    }
}
