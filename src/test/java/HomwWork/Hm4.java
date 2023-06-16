package HomwWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.ws.WebSocket;
import org.openqa.selenium.By;
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

public class Hm4 {
    @Test
    public void Task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle= driver.getTitle();
        String expectedTitle="Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);
        Thread.sleep(2000);
        WebElement name= driver.findElement(By.id("ctl00_MainContent_username"));
        name.sendKeys("Tester");
        Thread.sleep(1000);
        WebElement password= driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        Thread.sleep(1000);
        WebElement button= driver.findElement(By.id("ctl00_MainContent_login_button"));
        button.click();
        WebElement webOrders= driver.findElement(By.tagName("h1"));
        String expectedName="Web Orders".trim();
        Assert.assertEquals(BrowserUtils.getText(webOrders),expectedName);
        Thread.sleep(1000);
        WebElement listOfOrders= driver.findElement(By.tagName("h2"));
        String expectedName2="List of All Orders".trim();
        Assert.assertEquals(BrowserUtils.getText(listOfOrders),expectedName2);
        Thread.sleep(1000);
        driver.quit();

    }
    @Test
    public void Task2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement name= driver.findElement(By.id("ctl00_MainContent_username"));
        name.sendKeys("Tester");
        Thread.sleep(1000);
        WebElement password= driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        Thread.sleep(1000);
        WebElement button= driver.findElement(By.id("ctl00_MainContent_login_button"));
        button.click();
        Thread.sleep(1000);
        WebElement productsButton= driver.findElement(By.xpath("//a[contains(text(),'View all products')]"));
        productsButton.click();
        Thread.sleep(3000);
        //Assert.assertTrue(productsButton.isSelected());
        //Thread.sleep(1000);
        WebElement listOfProducts= driver.findElement(By.tagName("h2"));
        String expectedListName="List of Products".trim();
        Assert.assertEquals(BrowserUtils.getText(listOfProducts),expectedListName);
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("Product"));
        driver.quit();
    }
    @Test
    public void Task3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement name= driver.findElement(By.id("ctl00_MainContent_username"));
        name.sendKeys("Tester");
        Thread.sleep(1000);
        WebElement password= driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        Thread.sleep(1000);
        WebElement button= driver.findElement(By.id("ctl00_MainContent_login_button"));
        button.click();
        Thread.sleep(1000);
        List<WebElement>links=driver.findElements(By.xpath("//li//a"));
        List<String> expectedLinks= Arrays.asList("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx",
                "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Products.aspx",
                "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Process.aspx");
        for (WebElement allLinks:links) {
            System.out.println(allLinks.getAttribute("href"));
            Assert.assertEquals(allLinks.getAttribute("href"),expectedLinks);
        }


    }

    @Test
    public void Task4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement name = driver.findElement(By.id("ctl00_MainContent_username"));
        name.sendKeys("Tester");
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        Thread.sleep(1000);
        WebElement button = driver.findElement(By.id("ctl00_MainContent_login_button"));
        button.click();
        Thread.sleep(1000);
        WebElement order= driver.findElement(By.className("#aspnetForm"));
        order.click();
    }
}
