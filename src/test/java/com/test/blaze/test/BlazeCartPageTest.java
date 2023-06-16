package com.test.blaze.test;

import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.Home;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookPro;
import org.testng.annotations.Test;

public class BlazeCartPageTest extends balzeTest{
    @Test
    public void BlazeCartPageTest() throws InterruptedException {
        Home homePage=new Home(driver);
        homePage.chooseCategory("Laptops");
        LaptopPage laptopPage=new LaptopPage(driver);
        laptopPage.chooseLaptopBrand("MacBook Pro");
        MacBookPro macBookPro=new MacBookPro(driver);
        macBookPro.clickButton(driver,"Product added");
        CartPage cartPage=new CartPage(driver);
        cartPage.clickCart();
        cartPage.validation("MacBook Pro","1100");
    }
}
