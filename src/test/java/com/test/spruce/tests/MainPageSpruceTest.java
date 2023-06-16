package com.test.spruce.tests;

import com.test.spruce.pages.MainPageSpruce;
import org.testng.annotations.Test;

public class MainPageSpruceTest extends SpruceBaseTest{
    @Test
    public void MainPageSpruceTest() throws InterruptedException {
        MainPageSpruce mainPageSpruce=new MainPageSpruce(driver);
        mainPageSpruce.pickCategory(driver);
    }
}
