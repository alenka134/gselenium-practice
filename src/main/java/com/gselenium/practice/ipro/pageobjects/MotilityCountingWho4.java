package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MotilityCountingWho4 extends BasePage {
    @FindBy(css = "button[class='btn btn-primary navbtn']")
    WebElement btnStartTest;

    public MotilityCountingWho4(WebDriver driver) {
        super(driver);
    }
}
