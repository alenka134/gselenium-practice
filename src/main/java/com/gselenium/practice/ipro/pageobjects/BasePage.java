package com.gselenium.practice.ipro.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
    public String getValue(WebElement el) {
        return el.getTagName();
    }

    public void backToPreviousPage() {
        driver.navigate().back();
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
