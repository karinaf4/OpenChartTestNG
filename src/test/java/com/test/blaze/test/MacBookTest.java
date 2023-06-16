package com.test.blaze.test;

import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.Home;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookPro;
import org.testng.annotations.Test;

public class MacBookTest extends balzeTest {
    @Test
    public void validateMacBookPrice() throws InterruptedException {
        Home homePage=new Home(driver);
        homePage.chooseCategory("Laptops");
        LaptopPage laptopPage=new LaptopPage(driver);
        laptopPage.chooseLaptopBrand("MacBook Pro");
        MacBookPro macBookPro=new MacBookPro(driver);
        macBookPro.macBookProInfo("MacBook Pro","$1100 *includes tax","Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        macBookPro.clickButton(driver,"Product added");
        CartPage cartPage=new CartPage(driver);
        cartPage.clickCart();
        cartPage.validation("MacBook Pro","1100");





    }

}
