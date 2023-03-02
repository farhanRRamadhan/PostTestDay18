package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToChartPage {
        private WebDriver driver;
        public AddToChartPage(){
            this.driver = DriverSingleton.getDriver();
            PageFactory.initElements(driver, this);
        }

        //button ke Dashboard
        @FindBy(id = "//a[@class='custom-logo-link']//img[@alt='ToolsQA Demo Site']")
        WebElement Mywishlistdsh;

        //halaman Baju
    @FindBy(xpath = "//div[@class='tp-bgimg defaultimg ']")
    WebElement pagebaju;

        //klik baju
        @FindBy(xpath = "//a[normalize-space()='black lux graphic t-shirt']")
        WebElement pilihbaju;
//halaman baju
        @FindBy(xpath = "//section[@class='noo-page-heading ']")
        WebElement inputbaju;

        //memilih warna
        @FindBy (id = "pa_color")
        WebElement warna;

        //memilih size
        @FindBy ( id = "pa_size")
        WebElement size;

        @FindBy ( xpath = "//input[@id='noo-quantity-6853']")
        WebElement qty;

        //Button Add To Chart
        @FindBy(xpath = "//button[normalize-space()='Add to cart']")
        WebElement btnaddtochart;
//halaman chart
        @FindBy(xpath ="//h1[@class='page-title']")
        WebElement pagechart;


    public String getPagebaju(){
        return pagebaju.getText();
    }

    public String getInputbaju(){
        return inputbaju.getText();
    }
    public String getCartPage(){
        return pagechart.getText();
    }

    public void Addtochart(){

        Mywishlistdsh.click();
        this.pagebaju.isDisplayed();
        pilihbaju.click();
        this.inputbaju.isDisplayed();
        warna.sendKeys("Black");
        size.sendKeys("32");
        qty.sendKeys("3");
        btnaddtochart.click();
        this.pagechart.isDisplayed();
    }
}
