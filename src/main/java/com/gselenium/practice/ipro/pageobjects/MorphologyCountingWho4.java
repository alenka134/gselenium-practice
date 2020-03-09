package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MorphologyCountingWho4 extends BasePage {

    @FindBy(xpath = "//h4[text()='MORPHOLOGY TEST - PAPANICOLAOU']")
    WebElement morphologyTestHeading;
    @FindBy(xpath = "//text()[.='Download the Morphology Test Instructions']/ancestor::a[1]")
    WebElement linkPDFMorphology4Instruction;

    @FindBy(xpath = "//button[text()='GRID ON']")
    WebElement btnGridOn;
    @FindBy(xpath = "//button[text()='GRID OFF']")
    WebElement btnGridOff;
    @FindBy(xpath = "//button[text()='ZOOM ON']")
    WebElement btnZoomOn;
    @FindBy(xpath = "//button[text()='ZOOM OFF']")
    WebElement btnZoomOff;

    @FindBy(css = "div[class='blueColor']")
    WebElement clickMorphologyCounterResult;
    @FindBy(xpath = "//button[text()='Save and Continue']")
    WebElement btnSaveAndContinue;
    @FindBy(xpath = "//button[text()='Reset Count']")
    WebElement btnResetCount;
    @FindBy(xpath = "//button[text()='Back']")
    WebElement btnBack;

    @FindBy(xpath = "//button[text()='Tally Counter']")
    WebElement btnTallyCounter;
    @FindBy(xpath = "//button[text()='Label Counter']")
    WebElement btnLabelCounter;
    @FindBy(xpath = "//button[text()='NEXT FIELD']")
    WebElement btnNextField;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[2]/app-proficiency[1]/aw-wizard[1]/div[1]/app-morphologycounting[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ul[1]/li[1]/button[1]")
    WebElement clickNormal;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[2]/app-proficiency[1]/aw-wizard[1]/div[1]/app-morphologycounting[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ul[1]/li[2]/button[1]")
    WebElement clickAbNormal;

    @FindBy(xpath = "/html/body/app-root/div[2]/app-proficiency/aw-wizard/div/app-morphologycounting/div/div[2]/div[2]/div[2]/div[1]/ul/li[1]/p/span/input")
    WebElement inputTextNormal;
   @FindBy(xpath = "/html/body/app-root/div[2]/app-proficiency/aw-wizard/div/app-morphologycounting/div/div[2]/div[2]/div[2]/div[1]/ul/li[2]/p/span/input")
    WebElement inputTextAbNormal;

    public MorphologyCountingWho4(WebDriver driver) {
        super(driver);
    }

    public void setMorphologyTestHeading() {
        click(morphologyTestHeading);
        highlightElementTime(morphologyTestHeading, "blue");
        System.out.println("Title Screen is " + morphologyTestHeading.getText());
    }
    public void getLinkPDFMorphologyInstruction() {
        click(linkPDFMorphology4Instruction);
        highlightElementTime(linkPDFMorphology4Instruction, "blue");
        switchBetweenWindow();
        System.out.println("If the 'PDF Morphology Instruction'-link is displayed after the valid login: " + linkPDFMorphology4Instruction.isDisplayed() +" and user back to the previous tab: " + driver.getCurrentUrl());
    }
    public boolean setMorphologyButtons() {
        btnGridOn.isDisplayed();
        click(btnGridOn);
        click(btnGridOff);
        highlightElementTime(btnGridOn, "blue");
        click(btnZoomOn);
        click(btnZoomOff);
        highlightElementTime(btnZoomOn, "blue");
        return true;
    }
    public void setTallyCounter() {
        click(btnTallyCounter);
        highlightElementTime(btnTallyCounter, "blue");
        click5(clickNormal);
        click3(clickAbNormal);
        //click next field for counting (total Field should be 8)
        click(btnNextField);
        highlightElementTime(btnTallyCounter, "green");
        System.out.println("The 1st field counted with Tally Counter ->> " + getText(clickMorphologyCounterResult));
    }
    //Count enabled Video Examples, use Next Field button
    //Note!!! The count of the fields should be = 8
    public void setVideoNextFieldCount() {
        click8(btnNextField);
        highlightElementTime(btnNextField, "orange");
    }

    //reset count --> to zerolizing it and enter integers to Normal and Abnormal fields
    public void setLabelCounter() {
        click(btnLabelCounter);
        highlightElementTime(btnLabelCounter, "blue");

        click(inputTextNormal);
        fillText(inputTextNormal, "7");

        click(inputTextAbNormal);
        fillText(inputTextAbNormal, "2");

        click(btnNextField);
        highlightElementTime(btnLabelCounter, "green");
        System.out.println("The 1st field counted with Label Counter->> " + getText(clickMorphologyCounterResult));
    }
    //check Save and Continue button:
    // Switching to Alert > Capturing alert message > Displaying alert message > Accepting alert.
    public void clickSaveAndContinue() {
        click(btnSaveAndContinue);
        acceptAlert(btnSaveAndContinue);
    }
    public boolean setSaveAndContinue() {
        btnSaveAndContinue.isDisplayed();
        highlightElementTime(btnSaveAndContinue, "green");
        return true;
    }
    //check Reset Count button
    public boolean setResetCount() {
        btnResetCount.isDisplayed();
        highlightElementTime(btnResetCount, "green");
        return true;
    }
    //Check Back button
    public boolean setBack() {
        btnBack.isDisplayed();
        highlightElementTime(btnBack, "green");
        return true;
    }
}
