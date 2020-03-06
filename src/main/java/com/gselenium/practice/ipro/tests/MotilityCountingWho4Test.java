package com.gselenium.practice.ipro.tests;

import com.gselenium.practice.ipro.pageobjects.IntroWho4AutoVisionPap;
import com.gselenium.practice.ipro.pageobjects.LoginPagePass;
import com.gselenium.practice.ipro.pageobjects.MotilityCountingWho4;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MotilityCountingWho4Test extends BaseTest {
    @Test(priority = 1, description = "verify motility counter main buttons")
    public void setMotilityButtonsTest() throws InterruptedException {
        LoginPagePass loginPagePass = new LoginPagePass(driver);
        loginPagePass.login("elena@mes-ltd.com", "123456");

        IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
        introWho4AutoVisionPap.getBatchNumber("B31102019");
        introWho4AutoVisionPap.setNoReplicateWho4();
        introWho4AutoVisionPap.setNoReplicateWhoAutomatic();
        introWho4AutoVisionPap.setDeviceTypeSqaVision();
        introWho4AutoVisionPap.setStainingMethodPapanicolaou();


        MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
        motilityCountingWho4.setMotilityButtons();
        Assert.assertTrue(motilityCountingWho4.setMotilityButtons(), "Problems-> some video buttons are not displayed on the page");
        System.out.println("Test #1: Motility counter video buttons verification: " + motilityCountingWho4.setMotilityButtons());
    }

    @Test(priority = 2, description = "select Tally Counter", enabled = true)
    public void setTallyCounterTest() {
        MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
        motilityCountingWho4.setTallyCounter();
        System.out.println("Test 2: select Tally Counter");
    }

    @Test(priority = 3, description = "enter values to Label Counter", enabled = false)
    public void setLabelCounterTest() {
        MotilityCountingWho4 motilityCountingWho4 = new MotilityCountingWho4(driver);
        motilityCountingWho4.setLabelCounter();
        System.out.println("Test 3: select Label Counter and values input");
    }
}
