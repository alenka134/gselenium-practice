package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MotilityCountingWho4 extends BasePage {
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
    @FindBy(css = "button[class='btn btn-default']")
    WebElement btnDefaultTallyCounter;
    @FindBy(xpath = "//button[text()='Tally Counter']")
    WebElement btnTallyCounter;
    @FindBy(css = "button[class='btn btn-default']")
    WebElement btnDefaultLabelCounter;
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

    public MotilityCountingWho4(WebDriver driver) {
        super(driver);
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
    public void setTallyCounter(){
        click(btnTallyCounter);
        highlightElementTime(btnTallyCounter, "blue");
        click5(clickMotile);
        click3(clickImmotile);
        click(clickRapidProg);
        click(clickSlowProg);
        click(btnNextField);
        highlightElementTime(btnTallyCounter, "pink");
        System.out.println("The 1st field counted ->> " + getText(clickMotileCounterResult));
    }
    //enter integers to Mot, Immot and Rapid Prog, Slow Prog
    public void setLabelCounter(){
        click(btnLabelCounter);
        highlightElementTime(btnLabelCounter, "blue");
        click(inputTextImmotile);
        fillText(inputTextMotile, "25");
     /*   click(inputTextImmotile);
        fillText(inputTextImmotile, "10");
        click(inputTextRapidProgressive);
        fillText(inputTextRapidProgressive, "2");
        click(inputTextSlowProgressive);
        fillText(inputTextSlowProgressive, "2"); */

    }
}
