package com.test.spruce.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.http.WebSocketHandshakeException;

public class FishAndSeaFood {
    public FishAndSeaFood(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@aria-label='Search Input']")
    WebElement searchInput;

    public void FindRecipe(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",searchInput);
        searchInput.click();
        Thread.sleep(2000);
        searchInput.sendKeys("Fish for dinner");
    }
}
