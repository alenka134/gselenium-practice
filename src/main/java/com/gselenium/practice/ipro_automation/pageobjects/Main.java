package com.gselenium.practice.ipro_automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/alenka/automation/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.e-sperm.com/I-PRO/#/");

        HomePage homePage = new HomePage(driver);
        homePage.getLogo();

    /*    LoginPageFailed loginPageFailed = new LoginPageFailed(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        // Use incorrect login
        loginPageFailed.login1("tester@test", "46464664");
        loginPageFailed.getErrorMessage();
        loginPageFailed.forgotYourPassword();
        //Verification Contact form and all icons
        contactUsPage.getContactIcons();
        //printout MES contact email
        contactUsPage.isInfoMesEmailAppear();
        //Enter all contact details and pay attention phone number should be 10-12 digits
        contactUsPage.fillContactUs("Lena", "Tester", "elena@tester", "1234567891", "mes", "contact");
*/
        // Use correct login and enter to Proficiency Test Page
        LoginPagePass loginPagePass = new LoginPagePass(driver);
        loginPagePass.login("elena@mes-ltd.com", "123456");

        IntroWho4AutoVisionPap introWho4AutomaticVisionPap = new IntroWho4AutoVisionPap(driver);
        //enter Test Batch number: B31102019 and select WHO5
        introWho4AutomaticVisionPap.getBatchNumber("B31102019");
        //enter WHO5 criteria
        introWho4AutomaticVisionPap.setNoReplicateWho4();
        //choose Concentration Assumption method: Automatic
        introWho4AutomaticVisionPap.setNoReplicateWhoAutomatic();
        Thread.sleep(2000);
        //Select device type
        introWho4AutomaticVisionPap.setDeviceTypeSqaVision();
        Thread.sleep(2000);
        //last selection: staining Pap and start testing
        introWho4AutomaticVisionPap.setStainingMethodPapanicolaou();
        // driver.quit();
    }
}