package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {
    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".mainHeading")
    WebElement header;
    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement ManagerLogin;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homeButton;
    @FindBy(css = "#userSelect")
    WebElement userSelect;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;
    @FindBy(tagName = "input")
    WebElement depositBox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositSubmitButton;
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement message;
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawlButton;
    @FindBy(tagName = "input")
    WebElement withdrawlBox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement withdrawSubmitButton;
    @FindBy(xpath = "//div[@ng-hide='noAccount']//strong[2]")
    WebElement balance;
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactions;
    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement depositCredit;
    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement withdrawDebit;


    public void LoginPageComponentsValidation(String expectedHeader){ //hard coding
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertTrue(customerLogin.isDisplayed()&& customerLogin.isEnabled());
        Assert.assertTrue(ManagerLogin.isDisplayed()&&ManagerLogin.isEnabled());
    }
    public void clickManagerButton(){
        ManagerLogin.click();
    }
    public void clickHomeButton(){
        homeButton.click();
    }
    public void clickCustomerButton(){
        customerLogin.click();
    }
    public void selectUser(String valueNum){
        BrowserUtils.selectBy(userSelect,valueNum,"value");
    }
    public void clickLoginButton(){
        loginButton.click();

    }
    public void clickDepositButton(){
        depositButton.click();

    }
    public void sendDeposit(String moneyAmount){
        depositBox.sendKeys(moneyAmount);
    }
    public void clickSubmitDeposit(){
        depositSubmitButton.click();
    }
    public void validateMessage(String expectedMessage){
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);

    }
    public void clickWithdrawlButton(){
        withdrawlButton.click();
    }
    public void sendWithdrawlMoney(String moneyAmount){
        withdrawlBox.sendKeys(moneyAmount);
    }
    public void clickWithdrawSubmitButton(){
        withdrawSubmitButton.click();
    }
    public void transactionFunctionality() throws InterruptedException {
        int actualBalance=Integer.parseInt(BrowserUtils.getText(balance));
        Thread.sleep(2000);
        transactions.click();

        int expectedBalance=(Integer.parseInt(BrowserUtils.getText(depositCredit))-Integer.parseInt(BrowserUtils.getText(withdrawDebit)));
        Assert.assertEquals(actualBalance,expectedBalance);
    }
}
