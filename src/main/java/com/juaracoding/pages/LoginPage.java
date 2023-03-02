package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//button[@name='login']")
    WebElement btnLogin;

    //tetap
    @FindBy(xpath = "//section[@class='noo-page-heading ']")
    WebElement txtDashboard;
    @FindBy(xpath = "/html/head/script[2]")
    WebElement loginTitle;

    @FindBy(xpath = "//strong[normalize-space()='ERROR']")
    WebElement txtInvalidCredentials;

    public String getLoginTitle(){

        return loginTitle.getText();
    }
    public String getTxtDashboard(){

        return txtDashboard.getText();
    }
    public String getTxtInvalidCredentials(){

        return txtInvalidCredentials.getText();
    }

    public void login(String username, String password){
        this.username.sendKeys("farhanramadhany98@gmail.com");
        this.password.sendKeys("Farhanramadhany98!");
        btnLogin.click();
    }

}
