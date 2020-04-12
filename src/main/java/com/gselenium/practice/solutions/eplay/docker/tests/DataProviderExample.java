package com.gselenium.practice.solutions.eplay.docker.tests;

import com.gselenium.practice.solutions.eplay.docker.pageobjects.LoginPage;
import com.gselenium.practice.solutions.eplay.docker.utilites.Excel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample extends BaseTest {
    @Test(priority = 1, description = "get and assert the message: 'username or password was incorrect' ")
    public void loginFailedMessage() {
        //Should check that we get right message
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lena1@informup.com", "a1234567");

        LoginPage loginPage1 = new LoginPage(driver);
        String actual = loginPage1.getErrorMessage();
        String expected = "Sorry, either your username or password was incorrect.";

        Assert.assertEquals(actual, expected);
        System.out.println("Test #1 --> An actual message is: " + actual);
    }

    /*
     * In order to use DDT (Data Driven Testing) you should:
     * 1. create method to read from with @DataProvider annotation (in this example it called getData())
     * 2. add dataProvider="getData" parameter to the @Test
     */
    @Test(dataProvider = "getDataFromExcel", description = "use incorect login information")
    public void l1_loginFailed(String user, String password) {
        //login failed
        LoginPage loginPage = new LoginPage(driver);
        //Using the variables we get from the @DataProvider method
        loginPage.login(user, password);

        //Should check that we get the right message
        String expected = "Sorry, either your username or password was incorrect.";
        String actual = loginPage.getErrorMessage();
        Assert.assertEquals(actual, expected);
    }

    /*
     * This is example of a method that return 2 dimensional object (like a table)
     * Using the @DataProvider the method above will get the parameters for each iteration.
     */
  /*  @DataProvider
    public Object[][] getData() {
        Object[][] myData = {
                {"user1", "123"},
                {"gal", "123"},
                {"yonit", "1#444"},
                {"gal", "123456878"},
        };
        return myData;

    }
    /*
     * Use the Excel class to read data from excel
     */
    @DataProvider
    public Object[][] getDataFromExcel() {
        String excelPath = System.getProperty("user.dir") + "/src/main/java/com/gselenium/practice/solutions/eplay/docker/data/input3.xls";
        System.out.println(excelPath);
        Object[][] table = Excel.getTableArray(excelPath, "Login");
        return table;
    }

}

