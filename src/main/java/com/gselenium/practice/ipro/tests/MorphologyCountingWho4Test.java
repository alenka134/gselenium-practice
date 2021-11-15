package com.gselenium.practice.ipro.tests;

import com.gselenium.practice.ipro.pageobjects.IntroWho4AutoVisionPap;
import com.gselenium.practice.ipro.pageobjects.LoginPagePass;
import com.gselenium.practice.ipro.pageobjects.MorphologyCountingWho4;
import com.gselenium.practice.ipro.pageobjects.MotilityCountingWho4;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MorphologyCountingWho4Test extends BaseTest {
    @Test(priority = 1, description = "broken start Morphology test", enabled = true)
    public void startMorphologyInstructionTest(){
        try {
            LoginPagePass loginPagePass = new LoginPagePass(driver);
            loginPagePass.login("elena@mes-ltd.com", "123456");

            IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
            try {
                introWho4AutoVisionPap.getBatchNumber("B31102019");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //    introWho4AutoVisionPap.checkAlert();
            //    introWho4AutoVisionPap.switchBetweenWindow();
            //   introWho4AutoVisionPap.setNoReplicateWho4();

            //   introWho4AutoVisionPap.setNoReplicateWhoAutomatic();
            introWho4AutoVisionPap.setDeviceTypeSqaVision();
            //   introWho4AutoVisionPap.setStainingMethodPapanicolaou();
            System.out.println("Test : check Motility Label Counter data: ");
            MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
            motilityCountingWho4.setLabelCounter();
            motilityCountingWho4.clickSaveAndContinue();

            MorphologyCountingWho4 morphologyCountingWho4 = new MorphologyCountingWho4(driver);
            morphologyCountingWho4.setSaveAndContinue();
        }catch (Exception e) {
            Assert.fail(String.format("Test 1 *****Failed on error %s ", e));
        }

    }

    @Test(priority = 2, description = "check Page title and pdf link", enabled = true)
    public void setMorphologyTestHeadingTest() throws InterruptedException {
        MorphologyCountingWho4 morphologyCountingWho4 = new MorphologyCountingWho4(driver);
        morphologyCountingWho4.setMorphologyTestHeading();
        morphologyCountingWho4.getLinkPDFMorphologyInstruction();
        System.out.println("Test 2: check Morphology page title and pdf link");
    }

    @Test(priority = 3, description = "check morphology buttons", enabled = true)
    public void setMorphologyButtonsTest() {
        MorphologyCountingWho4 morphologyCountingWho4 = new MorphologyCountingWho4(driver);
        morphologyCountingWho4.setMorphologyButtons();
        System.out.println("Test 3: check Morphology buttons");
    }

    @Test(priority = 4, description = "select Tally Counter", enabled = true)
    public void setTallyCounterTest() {
        MorphologyCountingWho4 morphologyCountingWho4 = new MorphologyCountingWho4(driver);
        morphologyCountingWho4.setTallyCounter();
        System.out.println("Test 4: select Tally Counter (Morphology)");
    }

    //Count enabled Video Examples, use Next Field button
    //Note!!! The count should be = 8
    @Test(priority = 5, description = "Count enabled Video Examples, use Next Field button", enabled = true)
    public void setVideoNextFieldCountTest() {
        MorphologyCountingWho4 morphologyCountingWho4 = new MorphologyCountingWho4(driver);
        morphologyCountingWho4.setVideoNextPapFieldCount();
        System.out.println("Test 5: Count enabled Video Examples, use Next Field button");
    }

    @Test(priority = 6, description = "enter values to Label Counter and SaveAndContinue button verification", enabled = true)
    public void setLabelCounterTest() {
        try {
            MorphologyCountingWho4 morphologyCountingWho4 = new MorphologyCountingWho4(driver);
            morphologyCountingWho4.setLabelCounter();
            System.out.println("Test 6: select Label Counter and values input, jumping to Morphology Counter");
            Assert.assertTrue(morphologyCountingWho4.setSaveAndContinue(), "'Save and Continue' button is not displayed on the page");
            System.out.println("'Save and Continue' button is displayed:  --> " + morphologyCountingWho4.setSaveAndContinue());
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s " + " and the picture you can found: /Users/alenka/Desktop/Screenshots/testCaseName .jpg", e));
        }
    }

    @Test(priority = 7, description = "jump to Concentration Page", enabled = true)
    public void setSaveAndContinueTest() {
        try {
            MorphologyCountingWho4 morphologyCountingWho4 = new MorphologyCountingWho4(driver);
            morphologyCountingWho4.setSaveAndContinue();
            System.out.println("Test 7: jump to Concentration Page");
            Thread.sleep(500);
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s " + " and the picture you can found: /Users/alenka/Desktop/Screenshots/testCaseName .jpg", e));
        }
    }
}
