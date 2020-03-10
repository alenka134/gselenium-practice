package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Set;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement el) {
        el.click();
    }

    public void click8(WebElement el) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            //click the button
            el.click();
            count++;
            //wait 500 millis
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Element count is: " + count);
    }

    public void click5(WebElement el) {
        el.click();
        el.click();
        el.click();
        el.click();
        el.click();
    }

    public void click3(WebElement el) {
        el.click();
        el.click();
        el.click();
    }

    public void fillText(WebElement el, String text) {
        el.clear();
        el.sendKeys(text);
    }

    public String getText(WebElement el) {
        return el.getText();
    }

    public void switchBetweenWindow() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//below code will switch to new tab
        driver.switchTo().window(tabs.get(1));
        System.out.println("Text from link is: " + driver.getCurrentUrl());
//perform whatever actions you want in new tab then close it
        driver.close();
//Switch back to your original tab
        driver.switchTo().window(tabs.get(0));
    }

    public void moveToNewWindow() {
        String main = driver.getWindowHandle();
        Set<String> list = driver.getWindowHandles();
        for (String win : list) {
            driver.switchTo().window(win);
        }
        driver.close();
        driver.switchTo().window(main);
    }

    public void acceptAlert(WebElement el) {
        // Switching to Alert
        Alert alert = driver.switchTo().alert();
        // Capturing alert message.
        String alertMessage = driver.switchTo().alert().getText();
        // Displaying alert message
        System.out.println(alertMessage);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Accepting alert
        alert.accept();
    }

    /*
     * Call this method with your element and a color like (red,green,orange etc...)
     */
    protected void highlightElementTime(WebElement el, String color) {
        //keep the old style to change it back
        String originalStyle = el.getAttribute("style");
        String newStyle = "border: 10px solid " + color + ";" + originalStyle;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Change the style
        js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
                el);

        // Change the style back after few milliseconds
        js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
                + originalStyle + "');},2000);", el);
    }
}
