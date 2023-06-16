package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorIntro2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/kylek/Downloads/Techtorial.html");

        //LinkText locator

        WebElement JavaLink=driver.findElement(By.linkText("Java"));
        JavaLink.click();
        WebElement javaHeader= driver.findElement(By.tagName("h1"));
        String actualHeader=javaHeader.getText().trim();
        String expectedHeader="Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "correct" : "false");

        driver.navigate().back();
        WebElement Selenium=driver.findElement(By.linkText("Selenium")); // it has tagname and text
        Selenium.click();
        WebElement SeleniumHeader= driver.findElement(By.tagName("h1"));
        String actualSelenium=SeleniumHeader.getText().trim();
        String expectedSelenium="Selenium automates browsers. That's it!";
        System.out.println(actualSelenium.equals(expectedSelenium) ? "correct s" : "false S");

        driver.navigate().back();
        WebElement cucumber=driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        WebElement cucumberHeader= driver.findElement(By.tagName("h1"));
        String actualCucumber=cucumberHeader.getText().trim();
        String expectedCucumber="Tools & techniques that elevate teams to greatness";
        System.out.println(actualCucumber.equals(expectedCucumber) ? "correct C" : "false C");


        driver.navigate().back();
        WebElement testNG=driver.findElement(By.linkText("TestNG"));
        testNG.click();
        WebElement testNGHeader=driver.findElement(By.tagName("h2"));
        String actualtestNG=testNGHeader.getText().trim();
        String expectedtestNG="TestNG";
        System.out.println(actualtestNG.equals(expectedtestNG) ? "CORRECT" : "INCORRECT");
        driver.navigate().back();

     //PARTIAL LINKEDTEXT

        WebElement restApi= driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getTitle());




    }
}
