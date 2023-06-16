package com.test.blaze.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class Home {


    public Home(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "#itemc")
    List<WebElement> allCategories;


    public void chooseCategory(String option){
        for (WebElement category:allCategories) {
            if (BrowserUtils.getText(category).equals(option)){
                category.click();
                break;
            }

        }

    }

}

