package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BankTestBase {
    @Test
    public void validateAddCustomerFunctionality() throws InterruptedException {
       // WebDriverManager.chromedriver().setup();
       // ChromeOptions options = new ChromeOptions();
       // options.addArguments("--remote-allow-origins=*");
        //WebDriver driver = new ChromeDriver(options);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // driver.manage().window().maximize();
       // driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addPublicFunctionality(driver, "Karina", "Faiz", "444477", "Customer added successfully with customer id :6");
        Thread.sleep(2000);
    }

    @Test
    public void validateAccountFunctionality() throws InterruptedException {
       // WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
       // options.addArguments("--remote-allow-origins=*");
       // WebDriver driver = new ChromeDriver(options);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // driver.manage().window().maximize();
       // driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage = new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addPublicFunctionality(driver, "Karina", "Faiz", "444477", "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Karina Faiz", "Dollar", "Account created successfully with account Number :1016");
    }

    @Test
    public void validateCustomerFunctionality() throws InterruptedException {
        //WebDriverManager.chromedriver().setup();
       // ChromeOptions options = new ChromeOptions();
       // options.addArguments("--remote-allow-origins=*");
       // WebDriver driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();
       // driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addPublicFunctionality(driver,"Karina","Faiz","444477","Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver,"Karina Faiz","Dollar","Account created successfully with account Number :1016");
        bankManagerPage.customersButtonFunctionality("Karina","Faiz","444477");

    }
    @Test
    public void validateCustomerFunctionality2() throws InterruptedException {
       // WebDriverManager.chromedriver().setup();
       // ChromeOptions options = new ChromeOptions();
       // options.addArguments("--remote-allow-origins=*");
       // WebDriver driver = new ChromeDriver(options);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      //  driver.manage().window().maximize();
        // driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.addPublicFunctionality(driver,"Karina","Faiz","444477","Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver,"Karina Faiz","Dollar","Account created successfully with account Number :1016");
        bankManagerPage.customersButtonFunctionality("Karina","Faiz","444477");
        bankLoginPage.clickHomeButton();
        bankLoginPage.clickCustomerButton();
        bankLoginPage.selectUser("6");
        bankLoginPage.clickLoginButton();
        bankLoginPage.clickDepositButton();
        bankLoginPage.sendDeposit("500");
        bankLoginPage.clickSubmitDeposit();
        bankLoginPage.validateMessage("Deposit Successful");
        bankLoginPage.clickWithdrawlButton();
        Thread.sleep(1000);
        bankLoginPage.sendWithdrawlMoney("300");
        Thread.sleep(1000);
        bankLoginPage.clickWithdrawSubmitButton();
        bankLoginPage.transactionFunctionality();



    }
}

