package com.gselenium.practice.ipro.tests;

import com.gselenium.practice.ipro.pageobjects.LoginPagePass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPassTest extends BaseTest {
    @Test(priority = 1, description = "'here' pdf link to Instruction is clickable and navigates to the correct page ")
    public void getHerePDFInstructionLinkTest() {
        LoginPagePass loginPagePass = new LoginPagePass(driver);
        loginPagePass.login("elena@mes-ltd.com", "123456");
        loginPagePass.getHerePDFInstructionLink();
        System.out.println("Test 1: 'here' pdf link to Instruction ");
    }
}