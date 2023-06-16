package com.test.openchart.tests;

import com.test.openchart.pages.LoginPage;
import org.testng.annotations.Test;

public class loginPageTest extends openChartTestBase{
    @Test
    public void validationOfLoginPage(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginFunctionality("demo","demo");
        loginPage.clickLoginButton();

    }
}
