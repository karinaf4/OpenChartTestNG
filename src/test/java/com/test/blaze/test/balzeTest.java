package com.test.blaze.test;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class balzeTest {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
       // WebDriverManager.chromedriver().setup();
        //ChromeOptions chromeOptions=new ChromeOptions();
       // chromeOptions.addArguments("--remote-allow-origins=*");
       // driver=new ChromeDriver(chromeOptions);
       // driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver= DriverHelper.getDriver();
        driver.get("https://www.demoblaze.com/#");
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws IOException {
        if (!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"blazePictures");
        }
      driver.quit();
    }
}
