package com.gselenium.practice.solutions.eplay.mycomp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(css = "#body_Username")
    WebElement username;
    @FindBy(css = "#body_SubmitButton")
    WebElement btnLogin;
    @FindBy(css = "#body_ErrorMessage")
    WebElement errorMessage;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public void submitForgotPassword(String user) {
        //insert text to user name element
        fillText(username, user);
        //click Submit button
        click(btnLogin);
    }

    //Validation
    public String isMessageAppear() {
        String message = errorMessage.getText();
        System.out.println("An alert message is: " + message);

        return message;
    }
}
