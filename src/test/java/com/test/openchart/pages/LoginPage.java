package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "#input-username")
    WebElement userName;
    @FindBy(css = "#input-password")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

public void loginFunctionality(String name,String password){
    userName.sendKeys(name);
    this.password.sendKeys(password);
}
public void clickLoginButton(){
    loginButton.click();
}
}
