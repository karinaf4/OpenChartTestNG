package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MacBookPro {
    public MacBookPro(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(tagName = "h2")
    WebElement header;
    @FindBy(tagName = "h3")
    WebElement price;
    @FindBy(xpath = "//div[@id='myTabContent']")
    WebElement description;
    @FindBy(linkText = "Add to cart")
    WebElement addButton;
    public void macBookProInfo(String expectedHeader,String expectedPrice,String expectedDescription){
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price),expectedPrice);
       Assert.assertEquals(BrowserUtils.getText(description),expectedDescription);

    }
    public void clickButton(WebDriver driver,String expectedAlert) throws InterruptedException {
        addButton.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedAlert);
        alert.accept();

    }
}
