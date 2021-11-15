package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConcentrationPage extends BasePage {
    @FindBy(xpath = "//h2[text()='Concentration Assessment']")
    WebElement concentrationPageTestHeading;
    @FindBy(xpath = "//text()[.='Download the Concentration test Instructions']/ancestor::a[1]")
    WebElement linkPDFConcentrationTestInstruction;

    @FindBy(css = "input[type=text][placeholder='Sample 1 [M/ml]']")
    WebElement inputSampleOne;
    @FindBy(css = "input[type=text][placeholder='Sample 2 [M/ml]']")
    WebElement inputSampleTwo;
    @FindBy(css = "button[class='btn btn-primary navbtn']")
    WebElement btnBack;
    @FindBy(css = "button[class='swal-button swal-button--cancel']")
    WebElement swalCancelBtn;
    @FindBy(xpath = "//button[text()='Save and Continue']")
    WebElement btnSaveAndContinue;

    public ConcentrationPage(WebDriver driver) {
        super(driver);
    }

    public void setConcentrationPageTestHeading() {
        click(concentrationPageTestHeading);
        highlightElementTime(concentrationPageTestHeading, "blue");
        System.out.println("Title Screen is " + concentrationPageTestHeading.getText());
    }

    public void getLinkPDFConcentrationTestInstruction() throws InterruptedException {
        Thread.sleep(500);
        click(linkPDFConcentrationTestInstruction);
        highlightElementTime(linkPDFConcentrationTestInstruction, "blue");
        switchBetweenWindow();
        System.out.println("If the 'PDF Concentration Test Instruction'-link is displayed after the valid login: " + linkPDFConcentrationTestInstruction.isDisplayed() + " and user back to the previous tab: " + driver.getCurrentUrl());
    }

    public void setConcentrationAssessment() throws InterruptedException {
        Thread.sleep(500);
        click(inputSampleOne);
        highlightElementTime(inputSampleOne, "blue");
        fillText(inputSampleOne, "1.5");

        click(inputSampleTwo);
        fillText(inputSampleTwo, "2");

        click(btnBack);
        highlightElementTime(btnBack, "green");
        MorphologyCountingWho4 morphologyCountingWho4 = new MorphologyCountingWho4(driver);
        morphologyCountingWho4.setTallyCounter();
        try {
            click(swalCancelBtn);
            // {acceptAlert(swalCancelBtn);
            System.out.println("User click 'cancel' button and previous settings WHO are stored");
            // }
        } catch (Exception e) {
            System.out.println("The alert message was not displayed");
        }
        morphologyCountingWho4.setSaveAndContinue();

        click(inputSampleOne);
        highlightElementTime(inputSampleOne, "blue");
        fillText(inputSampleOne, "4");
        click(inputSampleTwo);
        highlightElementTime(inputSampleOne, "blue");
        fillText(inputSampleTwo, "5");

        click(btnSaveAndContinue);
        System.out.println("The concentrations entered and saved, jump to Finish Page");

    }
}