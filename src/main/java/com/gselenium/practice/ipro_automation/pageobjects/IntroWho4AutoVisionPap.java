package com.gselenium.practice.ipro_automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class IntroWho4AutoVisionPap extends BasePage {

    @FindBy(css = "input[type=text][name='Batchnumber']")
    WebElement enterBatchNumber;

    @FindBy(css = "#dropdownBasic1")
    WebElement WHO;
    @FindBy(xpath = "//button[text()='WHO 5']")
    WebElement WHO5;
    @FindBy(xpath = "//button[text()='WHO 4']")
    WebElement WHO4;
    @FindBy(xpath = "//button[text()='WHO 3']")
    WebElement WHO3;

    @FindBy(css = "button[id='dropdownBasic2']")
    WebElement concAssumpMethod;
    @FindBy(xpath = "//button[text()='Automatic']")
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

    @FindBy(xpath = "/html/body/app-root/div[2]/app-proficiency/aw-wizard/div/app-intro/div[3]/div/div/div[3]/button")
    WebElement stainingMethod;
    @FindBy(xpath = "//button[text()='Papanicolaou']")
    WebElement stainingMethodPapanicolaou;

    @FindBy(xpath = "//button[text()='Diff-Quik']")
    WebElement stainingMethodDiffQuik;
    @FindBy(xpath = "//button[text()='Prestaind Slide']")
    WebElement stainingMethodPrestaindSlide;
    @FindBy(css = "button[class='btn btn-primary navbtn']")
    WebElement btnStartTest;

    public IntroWho4AutoVisionPap(WebDriver driver) {
        super(driver);
    }

    public void getBatchNumber(String batchNumber) {
        fillText(enterBatchNumber, batchNumber);
        click(enterBatchNumber);
    }

    //this method for WHO5, but we can change criteria to WHO3 or WHO4
    public void setNoReplicateWho4() {
        click(WHO);
        click(WHO4);
        highlightElementTime(WHO4, "blue");
        System.out.println("WHO CRITERIA is: " + WHO.getText());
    }

    public void setNoReplicateWhoAutomatic() {
        click(concAssumpMethod);
        click(concAssumpMethodAutomatic);
        highlightElementTime(concAssumpMethodAutomatic, "blue");
        System.out.println("Concentration assumption method is: " + concAssumpMethod.getText());
    }

    public void setDeviceTypeSqaVision() {
        click(deviceType);
        click(deviceSqaVision);
        highlightElementTime(deviceSqaVision, "blue");
        System.out.println("Device type is: " + deviceType.getText());
    }

    /*  public void setNoReplicateWho5MethodManual() {
          click(concAssumpMethod);
          click(concAssumpMethodManual);
          highlightElementTime(concAssumpMethodManual, "blue");
          System.out.println("Concentration assumption method is: " + concAssumpMethod.getText());
      } */
    //staining method is the last mandatory choice in intro page
    public void setStainingMethodPapanicolaou() {
        click(stainingMethod);
        click(stainingMethodPapanicolaou);
        highlightElementTime(stainingMethodPapanicolaou, "blue");
        System.out.println("Staining method is: " + stainingMethod.getText());
        click(btnStartTest);
        highlightElementTime(btnStartTest, "green");
    }
}