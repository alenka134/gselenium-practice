package com.gselenium.practice.solutions.eplay.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement el) {
        el.click();
    }

    public void fillText(WebElement el, String text) {
        el.clear();
        el.sendKeys(text);
    }

}
