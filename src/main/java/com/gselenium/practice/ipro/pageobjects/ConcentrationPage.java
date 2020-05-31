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
    @FindBy(xpath = "//button[text()='Save and Continue']")
    WebElement btnSaveAndContinue;

    public ConcentrationPage(WebDriver driver) {
        super(driver);
    }

    public void setConcentrationPageTestHeading() {
        LoginPagePass loginPagePass = new LoginPagePass(driver);
        loginPagePass.login("elena@mes-ltd.com", "123456");

        IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
        try {
            introWho4AutoVisionPap.getBatchNumber("B31102019");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      //  introWho4AutoVisionPap.setNoReplicateWho4();
      //  introWho4AutoVisionPap.setNoReplicateWhoAutomatic();
        introWho4AutoVisionPap.setDeviceTypeSqaVision();
       // introWho4AutoVisionPap.setStainingMethodPapanicolaou();

        MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
        motilityCountingWho4.setTallyCounter();
        motilityCountingWho4.clickSaveAndContinue();

        MorphologyCountingWho4 morphologyCountingWho4 = new MorphologyCountingWho4(driver);
       morphologyCountingWho4.setTallyCounter();
       // morphologyCountingWho4.setVideoNextPapFieldCount();
        morphologyCountingWho4.clickSaveAndContinue();

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
        morphologyCountingWho4.clickSaveAndContinue();

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