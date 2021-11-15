package com.gselenium.practice.ipro.tests;

import com.gselenium.practice.ipro.pageobjects.IntroWho4AutoVisionPap;
import com.gselenium.practice.ipro.pageobjects.LoginPagePass;
import com.gselenium.practice.ipro.pageobjects.MorphologyCountingWho4;
import com.gselenium.practice.ipro.pageobjects.MotilityCountingWho4;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MotilityCountingWho4Test extends BaseTest {
    @Test(priority = 1, description = "verify motility counter main buttons")
    public void setMotilityButtonsTest() throws InterruptedException {
        LoginPagePass loginPagePass = new LoginPagePass(driver);
        loginPagePass.login("elena@mes-ltd.com", "123456");

        IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
        introWho4AutoVisionPap.getBatchNumber("B31102019");

      //  introWho4AutoVisionPap.setNoReplicateWho4();
        //introWho4AutoVisionPap.clickCancelAlertAndStartTest();
       // introWho4AutoVisionPap.setNoReplicateWhoAutomatic();
        introWho4AutoVisionPap.setDeviceTypeSqaVision();
      //  introWho4AutoVisionPap.setStainingMethodPapanicolaou();

        MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
        motilityCountingWho4.setMotilityButtons();
        Assert.assertTrue(motilityCountingWho4.setMotilityButtons(), "Problems-> some video buttons are not displayed on the page");
        System.out.println("Test #1: Motility counter video buttons verification: " + motilityCountingWho4.setMotilityButtons());
    }

    @Test(priority = 2, description = "check Page title", enabled = true)
    public void setMotilityTestHeadingTest() {
        MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
        motilityCountingWho4.setMotilityTestHeading();
        System.out.println("Test 2: check Motility page title");
    }

    @Test(priority = 3, description = "verify Link PDFMotility Instruction", enabled = true)
    public void getLinkPDFMotilityInstructionTest() {
        MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
        motilityCountingWho4.getLinkPDFMotilityInstruction();
        System.out.println("Test 3: verify Link PDF Motility Instruction");
    }

    @Test(priority = 4, description = "verify Link WHO 4TH Guidelines", enabled = true)
    public void getLinkWHO4THGuidelinesTest() {
        MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
        motilityCountingWho4.getLinkWHO4THGuidelines();
        System.out.println("Test 4: verify Link WHO 4TH Guidelines");
    }

    @Test(priority = 5, description = "select Tally Counter", enabled = true)
    public void setTallyCounterTest() {
        MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
        motilityCountingWho4.setTallyCounter();
        System.out.println("Test 5: select Tally Counter (Motility)");
    }

    //Count enabled Video Examples, use Next Field button
    //Note!!! The count should be = 8
    @Test(priority = 6, description = "Count enabled Video Examples, use Next Field button", enabled = true)
    public void setVideoNextFieldCountTest() {
        MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
        motilityCountingWho4.setVideoNextFieldCount();
        System.out.println("Test 6: Count enabled Video Examples, use Next Field button");
    }

    @Test(priority = 7, description = "enter values to Label Counter and SaveAndContinue button verification", enabled = true)
    public void setLabelCounterTest() {
        try {
            MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
            motilityCountingWho4.setLabelCounter();
           // motilityCountingWho4.clickSaveAndContinue();
            System.out.println("Test 7: select Label Counter and values input, jumping to Morphology Counter");
            Assert.assertTrue(motilityCountingWho4.setSaveAndContinue(), "'Save and Continue' button is not displayed on the page");
            System.out.println("'Save and Continue' button is displayed:  --> " + motilityCountingWho4.setSaveAndContinue());
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s " + " and the picture you can found: /Users/alenka/Desktop/Screenshots/testCaseName .jpg", e));
        }
    }

    @Test(priority = 8, description = "jump to Morphology Counter", enabled = false)
    public void setSaveAndContinueTest() {
        try {
            MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
            motilityCountingWho4.clickSaveAndContinue();
            System.out.println("Test 8: jump to Morph");
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s " + " and the picture you can found: /Users/alenka/Desktop/Screenshots/testCaseName .jpg", e));
        }
    }
}
