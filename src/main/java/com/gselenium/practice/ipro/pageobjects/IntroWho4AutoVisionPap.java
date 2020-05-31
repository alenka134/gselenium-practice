package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IntroWho4AutoVisionPap extends BasePage {
    @FindBy(css = "p[class='notification']")
    WebElement noteFinalTestDate;
    @FindBy(css = "input[type=text][name='Batchnumber']")
    WebElement enterBatchNumber;

    @FindBy(css = "a[href='assets/iPRO_Insert_ internal_alpha.pdf']")
    WebElement herePDFInstructionLink;

    @FindBy(xpath = "//button[text()='WHO Version']")
    WebElement WhoVersionBtn;
    @FindBy(xpath = "/html/body/app-root/div[2]/app-proficiency/aw-wizard/div/app-intro/div/div[3]/div/div/div[1]/button")
    WebElement WHO;
    @FindBy(css = "div[class='swal-title']")
    WebElement swalChangingSettings;
    @FindBy(css = "button[class='swal-button swal-button--cancel']")
    WebElement swalCancelBtn;
    @FindBy(css = "button[class='swal-button swal-button--confirm swal-button--danger']")
    WebElement swalConfirmBtn;
    @FindBy(xpath = "//button[text()='WHO 5']")
    WebElement WHO5;
    @FindBy(xpath = "//button[text()='WHO 4']")
    WebElement WHO4;
    @FindBy(xpath = "//button[text()='WHO 3']")
    WebElement WHO3;

    @FindBy(css = "#dropdownBasic2")
    WebElement concAssumpMethod;
    @FindBy(xpath = "//button[contains(text(),'Automatic')]")
    WebElement concAssumpMethodAutomatic;
    @FindBy(xpath = "//button[text()='Manual']")
    WebElement concAssumpMethodManual;

    @FindBy(css = "button[id='dropdownBasic3']")
    WebElement deviceType;
    @FindBy(xpath = "//button[text()='SQA-Vision']")
    WebElement deviceSqaVision;
    @FindBy(xpath = "//button[text()='SQA-V']")
    WebElement deviceSqaV;
    @FindBy(xpath = "//button[text()='QwikCheckGold']")
    WebElement deviceQwikCheckGold;
    @FindBy(xpath = "//button[text()='Other']")
    WebElement deviceOther;

    // @FindBy(xpath = "/html/body/app-root/div[2]/app-proficiency/aw-wizard/div/app-intro/div[3]/div/div/div[3]/button")
    @FindBy(xpath = "/html/body/app-root/div[2]/app-proficiency/aw-wizard/div/app-intro/div/div[3]/div/div/div[3]/button")
    WebElement stainingMethod;
    @FindBy(xpath = "/html/body/app-root/div[2]/app-proficiency/aw-wizard/div/app-intro/div/div[3]/div/div/div[3]/div/button[1]")
    WebElement stainingMethodPapanicolaou;

    @FindBy(xpath = "//button[text()='Diff-Quik']")
    WebElement stainingMethodDiffQuik;
    @FindBy(xpath = "//button[text()='Prestaind Slide']")
    WebElement stainingMethodPrestaindSlide;
    @FindBy(xpath = "//button[text()='START TESTING']")
    WebElement btnStartTest;

    public IntroWho4AutoVisionPap(WebDriver driver) {
        super(driver);
    }

    public boolean getNotificationFinalTestDate() {
        noteFinalTestDate.isDisplayed();
        click(noteFinalTestDate);
        //Change the style back after few milliseconds
        highlightElementTime(noteFinalTestDate, "orange");
        System.out.println("Note text is: " + getText(noteFinalTestDate));
        return true;
    }

    //Check pdf links (1)
    public boolean getHerePDFInstructionLink() {
        herePDFInstructionLink.isDisplayed();
        click(herePDFInstructionLink);
        highlightElementTime(herePDFInstructionLink, "blue");
        switchBetweenWindow();
        System.out.println("If the 'PDF here'-link is displayed after the click 'here': " + herePDFInstructionLink.isDisplayed() + ", link name is: " + getText(herePDFInstructionLink) + " and user back to the previous tab: " + driver.getCurrentUrl());
        return true;
    }

    public void getBatchNumber(String batchNumber) throws InterruptedException {
        fillText(enterBatchNumber, batchNumber);
        click(enterBatchNumber);
        System.out.println("The static Batch Number is accepted: " + batchNumber);
        Thread.sleep(2000);
    }

    //this method for WHO4, but we can change criteria to WHO5 or WHO3
    public void setNoReplicateWho4() {
        fillText(enterBatchNumber, "B31102019");
        click(enterBatchNumber);
        click(WHO);
        click(WHO5);
        highlightElementTime(WHO5, "blue");
        try {
            click(swalCancelBtn);
            // {acceptAlert(swalCancelBtn);
            System.out.println("User click 'cancel' button and previous settings WHO are stored");
            // }
        } catch (Exception e) {
            System.out.println("The alert message was not displayed");
        }

        System.out.println("WHO CRITERIA is: " + WHO.getText());
    }


    public void setNoReplicateWhoAutomatic() {
        //  click(btnStartTest);
        click(concAssumpMethod);
        click(concAssumpMethodAutomatic);
        highlightElementTime(concAssumpMethodAutomatic, "blue");
        System.out.println("Concentration assumption method is: " + concAssumpMethod.getText());
    }

    public void setDeviceTypeSqaVision() {
        click(btnStartTest);
        click(deviceType);
        click(deviceSqaVision);
        highlightElementTime(deviceSqaVision, "blue");
        System.out.println("Device type is: " + deviceType.getText());
    }

    //staining method is the last mandatory choice in intro page
    public void setStainingMethodPapanicolaou() {
        click(stainingMethod);
        click(stainingMethodPapanicolaou);

        highlightElementTime(stainingMethodPapanicolaou, "blue");
        System.out.println("Staining method is: " + stainingMethod.getText());
        // click(btnStartTest);
        // highlightElementTime(btnStartTest, "green");
    }
}
