package com.test.spruce.tests;

import Utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SpruceBaseTest {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.navigate().to("https://www.thespruceeats.com/");
    }
    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }
}
