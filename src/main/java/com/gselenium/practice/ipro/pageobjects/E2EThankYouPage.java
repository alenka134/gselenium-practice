package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class E2EThankYouPage extends BasePage {
    @FindBy(xpath = "//h2[text()='THANK YOU!']")
    WebElement headingThankYouPage;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[2]/app-proficiency[1]/aw-wizard[1]/div[1]/app-finish[1]/div[1]")
    WebElement fullPageText;

    public E2EThankYouPage(WebDriver driver) {
        super(driver);
    }

    public void setThankYouPageTestHeading() {
        click(headingThankYouPage);
        highlightElementTime(headingThankYouPage, "blue");
        System.out.println("Title Screen is " + headingThankYouPage.getText());
    }

    //Verify that the email, phone and address of the Mes-india are presented on the page
    public String isInfoThankYouPageAppear() {
        String fullText = fullPageText.getText();
        System.out.println("The contact info email is: " + fullText);

        return fullText;
    }
}
