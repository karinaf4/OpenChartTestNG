package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

public class CartPage {
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@onclick='addToCart(15)']")
    WebElement addToCartButton;
    @FindBy(css = "#cartur")
    WebElement cartButton;
    @FindBy(xpath = "//td")
    List<WebElement> list;


    public void clickAddToCartButton(WebDriver driver,String expectedAlert) throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),expectedAlert);
        alert.accept();

    }
    public void clickCart() throws InterruptedException {
        cartButton.click();
        Thread.sleep(3000);
    }
    public void validation(String expectedTitle,String expectedPrice){
        List<String>expectedInfo= Arrays.asList("",expectedTitle,expectedPrice,"");
        for (int i = 0; i < list.size()-1; i++) {
            Assert.assertEquals(BrowserUtils.getText(list.get(i)),expectedInfo.get(i));

        }

        }

    }

