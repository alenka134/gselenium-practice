package com.gselenium.practice.practice4.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestPage extends BasePage{
    WebElement btnNewTaskAdv;
    WebElement date;
    WebElement taskArea;
    WebElement noteArea;
    WebElement tagsArea;
    WebElement btnSave;


    public TestPage(WebDriver driver) {
        super(driver);
        btnNewTaskAdv = driver.findElement(By.cssSelector("#newtask_adv"));
        date = driver.findElement(By.xpath("//*[@id='duedate']"));
        taskArea = driver.findElement(By.xpath("//*[@id='taskedit_form']/div[4]/input"));
        noteArea = driver.findElement(By.xpath("//textarea[@name='note']"));
        tagsArea = driver.findElement(By.xpath("//input[@type='text'][@name='tags']"));
        btnSave = driver.findElement(By.cssSelector("input[type=submit][value='Save']"));
    }
    //Actions
    public void clickAddTask() {
        btnNewTaskAdv.click();
    }

    public void fillTaskWindow(String enterDate, String newTask, String note, String tag) {
        Select sPrioritySelection = new Select(driver.findElement(By.xpath("//div[@class='form-row form-row-short']/Select")));
        List<WebElement> sPrioritySelectionOptions = sPrioritySelection.getOptions();

        //Select Priority
        for (WebElement s : sPrioritySelectionOptions) {
            System.out.println("Selection priority: " + s.getText());
        }
        System.out.println("Number of priority options in list is: " + sPrioritySelectionOptions.size());
        sPrioritySelection.selectByValue("2");
        // Fill Date
        date.sendKeys(enterDate);
        // Clear and enter new task
        taskArea.clear();
        taskArea.sendKeys(newTask);
        //Enter note
        noteArea.sendKeys(note);
        //Enter tag
        tagsArea.sendKeys(tag);
        //Tap Save button
        btnSave.click();
    }

    //Add additional test with other parameters
    public void fillNewTaskWindow(String enterDate, String newTask, String note, String tag) {
        Select sPrioritySelection = new Select(driver.findElement(By.xpath("//div[@class='form-row form-row-short']/Select")));
        sPrioritySelection.selectByValue("1");
        date.sendKeys(enterDate);
        taskArea.clear();
        taskArea.sendKeys(newTask);
        noteArea.sendKeys(note);
        tagsArea.sendKeys(tag);
        btnSave.click();
    }
}