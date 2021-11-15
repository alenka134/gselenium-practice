package com.gselenium.practice.ipro.tests;

import com.gselenium.practice.ipro.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConcentrationTest extends BaseTest {
    @Test(priority = 1, description = "verify heading of the Concentration Assessment page", enabled = true)
    public void setConcentrationAssessmentTitleTest() {
        try {
            LoginPagePass loginPagePass = new LoginPagePass(driver);
            loginPagePass.login("elena@mes-ltd.com", "123456");

            IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
            try {
                introWho4AutoVisionPap.getBatchNumber("B31102019");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            introWho4AutoVisionPap.setDeviceTypeSqaVision();
            //   introWho4AutoVisionPap.setStainingMethodPapanicolaou();
            System.out.println("Test : check Motility Label Counter data: ");
            MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
            motilityCountingWho4.setLabelCounter();
            motilityCountingWho4.clickSaveAndContinue();

            MorphologyCountingWho4 morphologyCountingWho4 = new MorphologyCountingWho4(driver);
            // morphologyCountingWho4.setMorphologyTestHeading();
            morphologyCountingWho4.setLabelCounter();
            morphologyCountingWho4.setSaveAndContinue();
        }catch (Exception e) {
            Assert.fail(String.format("Test 1 *****Failed on error %s ", e));
        }
        ConcentrationPage concentrationPage = new ConcentrationPage(driver);
        concentrationPage.setConcentrationPageTestHeading();
        System.out.println("Test 1: verify Heading of the Concentration Assessment page");
    }
    @Test(priority = 2, description = "verify PDF link", enabled = false)
    public void getLinkPDFConcentrationTestInstructionTest() throws InterruptedException {
        ConcentrationPage concentrationPage = new ConcentrationPage(driver);
        concentrationPage.getLinkPDFConcentrationTestInstruction();
        System.out.println("Test 2: verify PDF Concentration Assessment link");
    }
    @Test(priority = 3, description = "verify concentration input, save data and navigate to final test page", enabled = false)
    public void setConcentrationAssessmentTest() throws InterruptedException {
        ConcentrationPage concentrationPage = new ConcentrationPage(driver);
      //  concentrationPage.setConcentrationPageTestHeading();
        concentrationPage.setConcentrationAssessment();
        System.out.println("Test 3: verify concentration input and navigate to final test page");
    }
}
