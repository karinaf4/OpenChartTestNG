package com.test.spruce.pages;

import com.test.spruce.tests.SpruceBaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageSpruce extends SpruceBaseTest {
    public MainPageSpruce(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredients;
    @FindBy(xpath = "//a[.='Fish & Seafood']")
    WebElement fishAndSeaFood;

    public void pickCategory(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        Actions actions=new Actions(driver);
        actions.moveToElement(ingredients).perform();
        Thread.sleep(2000);
        actions.click(fishAndSeaFood).perform();
    }
}
