package com.gselenium.practice.practice4.pageobject;

import org.openqa.selenium.*;

import java.util.List;

public class TasksPage extends BasePage {
    WebElement simpleTaskField;
    WebElement btnAddTask;
    WebElement areaSearch;
    WebElement btnAddNewList;
    WebElement newList;


    public TasksPage(WebDriver driver) {
        super(driver);
        simpleTaskField = driver.findElement(By.cssSelector("#task"));
        btnAddTask = driver.findElement(By.cssSelector("#newtask_submit"));
        areaSearch = driver.findElement(By.cssSelector("input[type=text][name='search']"));
        btnAddNewList = driver.findElement(By.cssSelector("#lists > div.mtt-tabs-add-button"));
        newList = driver.findElement(By.xpath("//span[text()='Elena List']"));
    }

    //Actions
    public void addSimpleTask(String task) {
        simpleTaskField.sendKeys(task);
        btnAddTask.click();
    }

    //Tasks search and count
    public void enterTaskSearch(String keyWord) throws InterruptedException {
        areaSearch.sendKeys(keyWord);

        Thread.sleep(3000);
        List<WebElement> allTaskSearched = driver.findElements(By.cssSelector("span[id='total']"));

        for (WebElement taskNumber : allTaskSearched) {
            System.out.println("\nTasks Number corresponded to my search is : " + taskNumber.getText());
            Thread.sleep(3000);
        }
    }

    public void clickBtnAddNewList() throws InterruptedException {
        btnAddNewList.click();
        Thread.sleep(3000);
    }

    public void createNewList() throws InterruptedException {

        try {
            Thread.sleep(5000);
            // sure you are not checking for the alert too soon.
            Alert alt = driver.switchTo().alert();
            alt.sendKeys("Elena List");
            alt.accept();

        } catch (NoAlertPresentException noe) {
            // No alert found on page, proceed with test.
        }
    }

    public void clickNewList() throws InterruptedException {
        Thread.sleep(3000);
        newList.click();
    }

    //Actions

    public void addSimpleTaskNewList(String addTask) {
        simpleTaskField.sendKeys(addTask);
        btnAddTask.click();
        btnAddTask.click();
    }

    //Check that in the list are 2 tasks
    public void taskCheckList() throws InterruptedException {
        List<WebElement> allTaskSearched = driver.findElements(By.cssSelector("span[id='total']"));

        for (WebElement taskNumber : allTaskSearched) {
            System.out.println("\nTasks Number in the 2nd list --> " + taskNumber.getText());
            Thread.sleep(3000);
        }
    }
}
