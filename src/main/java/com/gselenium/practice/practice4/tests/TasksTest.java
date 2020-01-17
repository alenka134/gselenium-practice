package com.gselenium.practice.practice4.tests;

import com.gselenium.practice.practice4.pageobject.TasksPage;
import com.gselenium.practice.practice4.pageobject.TestPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TasksTest {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrom.driver", "/Users/alenka/automation/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.mytinytodo.net/demo/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        TasksPage tasksPage = new TasksPage(driver);
        tasksPage.addSimpleTask("Elena added Simple Task");

        TestPage testPage = new TestPage(driver);
        testPage.clickAddTask();
        testPage.fillTaskWindow("01/11/2019"," +Elena's new Se task", "Elena should complete all Selenium HW", "tag - Selenium" );

        //additional testPage task
        testPage.clickAddTask();
        testPage.fillNewTaskWindow("10/11/2019"," +Elena's additional new testPage Se task", "Enter additional notes, tags, comments ", "Automation");

        //task search by keyword and count
        tasksPage.enterTaskSearch("Elena");

        //Add new list and input tasks
       // TestNewList testNewList = new TestNewList(driver);
        tasksPage.clickBtnAddNewList();

        tasksPage.createNewList();
        Thread.sleep(3000);

        //Add tasks in the new list & check the list
        tasksPage.clickNewList();

        tasksPage.addSimpleTaskNewList("Elena added the Simple Task in the 2nd list");
        Thread.sleep(3000);
        tasksPage.taskCheckList();
    }
}
