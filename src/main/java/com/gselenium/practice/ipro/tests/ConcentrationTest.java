package com.gselenium.practice.ipro.tests;

import com.gselenium.practice.ipro.pageobjects.ConcentrationPage;
import org.testng.annotations.Test;

public class ConcentrationTest extends BaseTest {
    @Test(priority = 1, description = "verify heading of the Concentration Assessment page", enabled = true)
    public void setConcentrationAssessmentTitleTest() {
        ConcentrationPage concentrationPage = new ConcentrationPage(driver);
        concentrationPage.setConcentrationPageTestHeading();
        System.out.println("Test 1: verify Heading of the Concentration Assessment page");
    }
    @Test(priority = 2, description = "verify PDF link", enabled = true)
    public void getLinkPDFConcentrationTestInstructionTest() {
        ConcentrationPage concentrationPage = new ConcentrationPage(driver);
        concentrationPage.getLinkPDFConcentrationTestInstruction();
        System.out.println("Test 2: verify PDF Concentration Assessment link");
    }
    @Test(priority = 3, description = "verify concentration input, save data and navigate to final test page", enabled = true)
    public void setConcentrationAssessmentTest() {
        ConcentrationPage concentrationPage = new ConcentrationPage(driver);
        concentrationPage.setConcentrationAssessment();
        System.out.println("Test 3: verify concentration input and navigate to final test page");
    }
}
