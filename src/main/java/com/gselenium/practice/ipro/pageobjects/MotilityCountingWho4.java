package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MotilityCountingWho4 extends BasePage {

    @FindBy(xpath = "//div[text()='MOTILITY TEST - WHO 4TH']")
    WebElement motilityTestHeading;
    @FindBy(xpath = "//text()[contains(.,'Download the Motility Test Instructions')]/ancestor::a[1]")
    WebElement linkPDFMotility4Instruction;
    @FindBy(xpath = "//text()[contains(.,'Download WHO 4TH Guidelines')]/ancestor::a[1]")
    WebElement linkWHO4THGuidelines;
    @FindBy(xpath = "//*[@id='mainVieo']/div/ul/li[1]/button")
    WebElement btnGridOn;
    @FindBy(xpath = "//button[text()='GRID OFF']")
    WebElement btnGridOff;
    @FindBy(xpath = "//button[text()='FREEZE']")
    WebElement btnFreeze;
    @FindBy(xpath = "//button[text()='REAL TIME']")
    WebElement btnRealTime;

    @FindBy(css = "p[class='blackColor']")
    WebElement clickMotileCounterResult;

    @FindBy(css = "button[class='swal-button swal-button--cancel']")
    WebElement swalCancelBtn;
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

    @FindBy(xpath = " /html[1]/body[1]/app-root[1]/div[2]/app-proficiency[1]/aw-wizard[1]/div[1]/app-motilitycounting[1]/div[1]/div[2]/div[4]/div[2]/ul[1]/li[1]/button[1]")
    WebElement clickMotile;
    @FindBy(xpath = " /html[1]/body[1]/app-root[1]/div[2]/app-proficiency[1]/aw-wizard[1]/div[1]/app-motilitycounting[1]/div[1]/div[2]/div[4]/div[2]/ul[1]/li[2]/button[1]")
    WebElement clickImmotile;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[2]/app-proficiency[1]/aw-wizard[1]/div[1]/app-motilitycounting[1]/div[1]/div[2]/div[4]/div[2]/ul[3]/li[1]/button[1]")
    WebElement clickRapidProg;
    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[2]/app-proficiency[1]/aw-wizard[1]/div[1]/app-motilitycounting[1]/div[1]/div[2]/div[4]/div[2]/ul[3]/li[2]/button[1]")
    WebElement clickSlowProg;

    @FindBy(css = "input[type=text][name='motile']")
    WebElement inputTextMotile;
    @FindBy(css = "input[type=text][name='immotile']")
    WebElement inputTextImmotile;
    @FindBy(css = "input[type=text][name='rapidProgressive']")
    WebElement inputTextRapidProgressive;
    @FindBy(css = "input[type=text][name='slowProgressive']")
    WebElement inputTextSlowProgressive;

    @FindBy(css = "button[class='swal-button swal-button--confirm']")
    WebElement approveAlertBtn;

    public MotilityCountingWho4(WebDriver driver) {
        super(driver);
    }

    public void setMotilityTestHeading() {
        click(motilityTestHeading);
        highlightElementTime(motilityTestHeading, "blue");
        System.out.println("Title Screen is " + motilityTestHeading.getText());
    }

    public boolean setMotilityButtons() {
        btnGridOn.isDisplayed();
        click(btnGridOn);
        click(btnGridOff);
        highlightElementTime(btnGridOn, "blue");
        click(btnFreeze);
        click(btnRealTime);
        highlightElementTime(btnFreeze, "blue");
        return true;
    }

    // Count Mot, Immot and Rapid Prog, Slow Prog cells wth click,
    // NOTE!!! Sum (imm+prog) should be < than Total Motile cells
    public void setTallyCounter() {
        click(btnTallyCounter);
        highlightElementTime(btnTallyCounter, "blue");
        click5(clickMotile);
        click3(clickImmotile);
        click(clickRapidProg);
        click(clickSlowProg);
        //click next field for counting (total Field should be 8)
        click(btnNextField);
        highlightElementTime(btnTallyCounter, "green");
        System.out.println("The 1st field counted with Tally Counter ->> " + getText(clickMotileCounterResult));
    }

    //Count enabled Video Examples, use Next Field button
    //Note!!! The count of the fields should be = 8 (Motility has 8 videos)
    public void setVideoNextFieldCount() {
        click8(btnNextField);
        highlightElementTime(btnNextField, "orange");
    }

    //reset count --> to zerolizing it and enter integers to Mot, Immot and Rapid Prog, Slow Prog
    public void setLabelCounter() {
        click(btnLabelCounter);
        highlightElementTime(btnLabelCounter, "blue");
        click(inputTextImmotile);
        fillText(inputTextMotile, "25");

        click(inputTextImmotile);
        fillText(inputTextImmotile, "10");

        click(inputTextRapidProgressive);
        fillText(inputTextRapidProgressive, "2");

        click(inputTextSlowProgressive);
        fillText(inputTextSlowProgressive, "2");

        click(btnNextField);
        highlightElementTime(btnLabelCounter, "green");
        System.out.println("The 1st field counted with Label Counter->> " + getText(clickMotileCounterResult));

    }

    //click Save and Continue button
    // Switching to Alert > Capturing alert message > Displaying alert message > Accepting alert.
    public void clickSaveAndContinue() {
        click(btnSaveAndContinue);
        try {
            click(swalCancelBtn);
             {acceptAlert(swalCancelBtn);
            System.out.println("User click 'cancel' button and previous settings are stored");
             }
        } catch (Exception e) {
            System.out.println("The alert message was not displayed");
        }
        click(approveAlertBtn);

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

    //Check pdf links (2)
    public void getLinkPDFMotilityInstruction() {
        click(linkPDFMotility4Instruction);
        highlightElementTime(linkPDFMotility4Instruction, "blue");
        switchBetweenWindow();
        System.out.println("If the 'PDF Motility Instruction'-link is displayed after the valid login: " + linkPDFMotility4Instruction.isDisplayed() + " and user back to the previous tab: " + driver.getCurrentUrl());
    }

    public void getLinkWHO4THGuidelines() {
        click(linkWHO4THGuidelines);
        highlightElementTime(linkWHO4THGuidelines, "blue");
        switchBetweenWindow();
        System.out.println("If the 'WHO 4TH Guidelines'-link is displayed after the valid login: " + linkWHO4THGuidelines.isDisplayed() + " and user back to the previous tab: " + driver.getCurrentUrl());
    }
}
