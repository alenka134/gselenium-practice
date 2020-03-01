package com.gselenium.practice.ipro.tests;

import com.gselenium.practice.ipro.pageobjects.IntroWho4AutoVisionPap;
import com.gselenium.practice.ipro.pageobjects.LoginPagePass;
import org.testng.annotations.Test;

public class IntroWho4AutoVisionPapTest extends BaseTest {

    @Test(priority = 2, description = "Batch number verification")
    public void enterBatchNumberTest() {
        LoginPagePass loginPagePass = new LoginPagePass(driver);
        loginPagePass.login("elena@mes-ltd.com", "123456");
        IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
        introWho4AutoVisionPap.getBatchNumber("B31102019");
        System.out.println("Test 2: Batch number verification");
    }

    @Test(priority = 3, description = "this method for WHO4, but we can change criteria to WHO5 or WHO4")
    public void setNoReplicateWho4Test() {
        IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
        introWho4AutoVisionPap.setNoReplicateWho4();
        System.out.println("Test 3: select WHO4");
    }
    @Test(priority = 4, description = "choose automatic method")
    public void setNoReplicateWhoAutomaticTest() {
        IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
        introWho4AutoVisionPap.setNoReplicateWhoAutomatic();
        System.out.println("Test 4: select Automatic");
    }
    @Test(priority = 5, description = "select device type - Vision")
    public void setDeviceTypeSqaVisionTest() {
        IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
        introWho4AutoVisionPap.setDeviceTypeSqaVision();
        System.out.println("Test 5: select device type - VISION");
    }
    @Test(priority = 6, description = "select PAP staining method")
    public void setStainingMethodPapanicolaouTest() {
        IntroWho4AutoVisionPap introWho4AutoVisionPap = new IntroWho4AutoVisionPap(driver);
        introWho4AutoVisionPap.setStainingMethodPapanicolaou();
        System.out.println("Test 6: select Pap staining method");
    }
}
