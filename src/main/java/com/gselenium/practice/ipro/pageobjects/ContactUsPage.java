package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {
    @FindBy(css = "input[type=text][name='contactFirstName']")
    WebElement enterFirstName;
    @FindBy(css = "input[type=text][name='contactLastName']")
    WebElement enterLastName;
    @FindBy(css = "input[type=email][name='contactEmail']")
    WebElement enterEmail;
    @FindBy(css = "input[type=text][name='contactPhoneNumber']")
    WebElement enterPhoneNumber;
    @FindBy(css = "input[type=text][name='contactFacilityName']")
    WebElement enterFacilityName;
    @FindBy(css = "textarea[name='contactMessage']")
    WebElement enterContactMessage;
    @FindBy(css = "button[class='btn btn-primary']")
    WebElement btnSend;
    @FindBy(css = "a[href='mailto:info@mes-india.in']")
    WebElement infoEmailMES;
    @FindBy(css = "body > app-root > div.container2 > app-contact > div > div:nth-child(2) > ul > li:nth-child(1) > ul > li:nth-child(1) > img")
    WebElement iconEmail;
    @FindBy(css = "body > app-root > div.container2 > app-contact > div > div:nth-child(2) > ul > li:nth-child(2) > ul > li:nth-child(1) > img")
    WebElement iconPhone;
    @FindBy(css = "body > app-root > div.container2 > app-contact > div > div:nth-child(2) > ul > li:nth-child(3) > ul > li:nth-child(1) > img")
    WebElement iconAddress;
    @FindBy(css = "body > app-root > div.container2 > app-contact > div > div > pre > h1")
    WebElement approvedMessage;
    @FindBy(css = "button[class='btn btn-primary']")
    WebElement btnBackToHomePage;
    @FindBy(css = "button[class='signInBtn']")
    WebElement btnSignIn;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    //Verify that the email, phone and address of the Mes-india are presented on the page
    public String isInfoMesEmailAppear() {
        String infoEmailMESText = infoEmailMES.getText();
        System.out.println("The contact info email is: " + infoEmailMESText);

        return infoEmailMESText;
    }

    //Verification if all contact icons are presented
    public boolean getContactIcons() {
        iconPhone.isDisplayed();
        click(iconPhone);

        iconAddress.isDisplayed();
        click(iconAddress);

        iconEmail.isDisplayed();
        click(iconEmail);

        //Change the style back after few milliseconds
        highlightElementTime(iconPhone, "orange");
        highlightElementTime(iconAddress, "orange");
        highlightElementTime(iconEmail, "orange");
        System.out.println("Icon phone is displayed on Contact Page: " + iconPhone.isDisplayed());
        System.out.println("Icon address is displayed on Contact Page: " + iconAddress.isDisplayed());
        System.out.println("Icon email is displayed on Contact Page: " + iconEmail.isDisplayed());
        return true;
    }

    //Entry user contact details and send to support
    public void fillContactUs(String firstName, String lastName, String email, String phoneNumber, String facility, String contactMessage) {

        //insert text to user name element
        fillText(this.enterFirstName, firstName);
        fillText(enterLastName, lastName);
        fillText(enterEmail, email);
        fillText(enterPhoneNumber, phoneNumber);
        fillText(enterFacilityName, facility);
        fillText(enterContactMessage, contactMessage);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //click SEND button
        click(btnSend);
        System.out.println("User contact details sent successfully, the approved message is: " + approvedMessage.getText());
        click(btnBackToHomePage);
        click(btnSignIn);
    }
}



