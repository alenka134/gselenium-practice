package com.gselenium.practice.solutions.eplay.mycomp.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement el) {
        el.click();
    }

    public void fillText(WebElement el, String text) {
        el.clear();
        el.sendKeys(text);
    }
    //  loginPage.highLightElement();
    public void highlightElement(WebElement el) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments
        //Here I pass values based on css style. Green background color with solid blue color border.
        js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 10px solid blue;');", el);
        el.click();
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

