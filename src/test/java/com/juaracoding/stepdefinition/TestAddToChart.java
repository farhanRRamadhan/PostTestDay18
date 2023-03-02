package com.juaracoding.stepdefinition;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddToChartPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAddToChart {
    public static WebDriver driver;
    public LoginPage loginPage;
    public AddToChartPage addToChartPage;


    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
        addToChartPage = new AddToChartPage();
        //driver.get("https://shop.demoqa.com/my-account/");
        //loginPage.login("farhanramadhany98@gmail.com","Farhanramadhany98!");
    }

    @Test(priority = 1)
    public void testUrl(){

        driver.get("https://shop.demoqa.com/");
        //step verify
        Assert.assertEquals(loginPage.getLoginTitle(),"Login");
    }

    @Test(priority = 2)
    public void testValidLogin(){
        loginPage.login("farhanramadhany98@gmail.com","Farhanramadhany98!");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard");
    }
    @Test (priority = 3)
    public void testAddCandidate(){
    delay(3);
    addToChartPage.getCartPage();
    Assert.assertEquals(loginPage.getTxtDashboard(),"Invalid credentials");

    }

    @AfterClass
    public void quitBrowser(){
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

