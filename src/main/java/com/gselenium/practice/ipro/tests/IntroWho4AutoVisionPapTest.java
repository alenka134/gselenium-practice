package com.gselenium.practice.ipro.tests;

import com.gselenium.practice.ipro.pageobjects.IntroWho4AutoVisionPap;
import com.gselenium.practice.ipro.pageobjects.LoginPagePass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IntroWho4AutoVisionPapTest extends BaseTest {

    @Test(priority = 1, description = "Batch number verification")
    public void enterBatchNumberTest() throws InterruptedException {
        LoginPagePass loginPagePass = new LoginPagePass(driver);
        loginPagePass.login("elena@mes-ltd.com", "123456");
        IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
        introWho4AutoVisionPap.getBatchNumber("B31102019");
        System.out.println("Test 1: Batch number verification");

    }

    @Test(priority = 2, description = "Notification about Final Test Date")
    public void getNotificationFinalTestDateTest() {
        try {
            IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
            introWho4AutoVisionPap.getNotificationFinalTestDate();
            System.out.println("Test 2: get Notification about Final Test Date");
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s " + " and the picture you can found: /Users/alenka/Desktop/Screenshots/testCaseName .jpg", e));
        }
    }

    @Test(priority = 3, description = "this method for WHO4, but we can change criteria to WHO5 or WHO4")
    public void setNoReplicateWho4Test() {
        try {
            IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
            introWho4AutoVisionPap.setNoReplicateWho4();
            System.out.println("Test 3: select WHO4");
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s " + " and the picture you can found: /Users/alenka/Desktop/Screenshots/testCaseName .jpg", e));
        }
    }

    @Test(priority = 4, description = "choose automatic method")
    public void setNoReplicateWhoAutomaticTest() {
        try {
            IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
            introWho4AutoVisionPap.setNoReplicateWhoAutomatic();
            System.out.println("Test 4: select Automatic");
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s " + " and the picture you can found: /Users/alenka/Desktop/Screenshots/testCaseName .jpg", e));
        }
    }

    @Test(priority = 5, description = "select device type - Vision")
    public void setDeviceTypeSqaVisionTest() {
        try {
            IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
            introWho4AutoVisionPap.setDeviceTypeSqaVision();
            System.out.println("Test 5: select device type - VISION");
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s " + " and the picture you can found: /Users/alenka/Desktop/Screenshots/testCaseName .jpg", e));
        }
    }

    @Test(priority = 6, description = "select PAP staining method")
    public void setStainingMethodPapanicolaouTest() {
        try {
            IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
            introWho4AutoVisionPap.setStainingMethodPapanicolaou();
            System.out.println("Test 6: select Pap staining method");
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s " + " and the picture you can found: /Users/alenka/Desktop/Screenshots/testCaseName .jpg", e));
        }
    }
   /* @Test(priority = 6, description = "click Start Test button ")
    public void setStartTestTest() {
        IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
        introWho4AutoVisionPap.setStartTest();
        System.out.println("Test 6: click Start Test button");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */
}

