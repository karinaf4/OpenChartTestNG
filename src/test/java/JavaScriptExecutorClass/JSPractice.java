package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/radio-button");
        WebElement yesButton= driver.findElement(By.xpath("//input[@id='yesRadio']"));
        Actions actions=new Actions(driver);
        actions.click(yesButton).perform();
        Thread.sleep(1000);
        WebElement text= driver.findElement(By.cssSelector(".text-success"));
        String expected="Yes";
        Assert.assertEquals(BrowserUtils.getText(text),expected);
        Thread.sleep(1000);
        WebElement impressive= driver.findElement(By.id("impressiveRadio"));
        Actions actions2=new Actions(driver);
        actions2.click(impressive).perform();
        Thread.sleep(1000);
        WebElement text2= driver.findElement(By.cssSelector(".text-success"));
        String expected2="Impressive";
        Assert.assertEquals(BrowserUtils.getText(text2),expected2);
        Thread.sleep(1000);
        WebElement no= driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertTrue(!no.isEnabled());

    }
    @Test
    public void ScrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");

        WebElement findOutCourse= driver.findElement(By.xpath("//span[contains(text(),'which course']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",findOutCourse);
        Thread.sleep(1000);

    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement contains= driver.findElement(By.xpath("//div[contains(text(), 'Copyright')]"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",contains);
        Thread.sleep(1000);
        String expected="Copyright © 2023".trim();
        Assert.assertEquals(BrowserUtils.getText(contains),expected);
        Thread.sleep(1000);
        WebElement Apply= driver.findElement(By.cssSelector("#menuItem_1594985863854_2"));
        JavascriptExecutor js2=(JavascriptExecutor) driver;
        js2.executeScript("arguments[0].scrollIntoView(true)",Apply);
        Thread.sleep(1000);
        js2.executeScript("arguments[0].click()",Apply);
        Thread.sleep(1000);
        WebElement title= driver.findElement(By.xpath("//span[contains(text(),'APPLY NOW!')]"));
        String expectedTitle="APPLY NOW!";
        Assert.assertEquals(BrowserUtils.getText(title),expectedTitle);
       Thread.sleep(1000);
       List<WebElement> lists=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
       ArrayList<String> actual=new ArrayList<>();
        for (WebElement list: lists) {
            actual.add(BrowserUtils.getText(list));



        }
        System.out.println(actual);




    }
}
