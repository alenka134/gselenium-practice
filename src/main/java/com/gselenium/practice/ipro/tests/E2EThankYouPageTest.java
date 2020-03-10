package com.gselenium.practice.ipro.tests;

import com.gselenium.practice.ipro.pageobjects.ConcentrationPage;
import com.gselenium.practice.ipro.pageobjects.E2EThankYouPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2EThankYouPageTest extends BaseTest {

    @Test(priority = 1, description = "Thank you page title verification")
    public void setThankYouPageTestHeadingTest() {
        try {
            ConcentrationPage concentrationPage = new ConcentrationPage(driver);
            concentrationPage.setConcentrationPageTestHeading();
            concentrationPage.setConcentrationAssessment();

            E2EThankYouPage e2EThankYouPage = new E2EThankYouPage(driver);
            e2EThankYouPage.setThankYouPageTestHeading();
            System.out.println("Test 1: Thank you page is displayed");
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s ", e));
        }
    }
    @Test(priority = 2, description = "Print 'Thank you page' text")
    public void isInfoThankYouPageAppearTest() {
        try {
            E2EThankYouPage e2EThankYouPage = new E2EThankYouPage(driver);
            e2EThankYouPage.isInfoThankYouPageAppear();
            System.out.println("Test 1: Thank you page text is displayed");
        } catch (Exception e) {
            Assert.fail(String.format("*****Failed on error %s ", e));
        }
    }
}
