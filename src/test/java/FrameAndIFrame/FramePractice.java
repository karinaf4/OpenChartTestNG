package FrameAndIFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FramePractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        WebElement header= driver.findElement(By.tagName("h3"));
        String expectedHeader="An iFrame containing the TinyMCE WYSIWYG Editor".trim();
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Thread.sleep(1000);
        driver.switchTo().frame("mce_0_ifr"); //IFrame Switch
        WebElement paragr= driver.findElement(By.id("tinymce"));
        paragr.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        System.out.println(BrowserUtils.getText(header));
    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes");
       // driver.switchTo().frame("Framename1");
        WebElement pavilion= driver.findElement(By.xpath("//a[contains(text(),'Pavilion')]"));
        pavilion.click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation");
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        WebElement selenium= driver.findElement(By.xpath("//header[@class='header-bar']//ul[@id='primary-menu']//span[contains(text(),'Selenium')]"));
        actions.moveToElement(selenium).perform();
        Thread.sleep(1000);
        Actions actions2=new Actions(driver);
        WebElement SePython= driver.findElement(By.xpath("//ul[@id='primary-menu']//span[contains(text(),'Selenium-Python')]"));
        actions2.click(SePython).perform();
        Thread.sleep(1000);
        WebElement header= driver.findElement(By.tagName("h1"));
        String expectedHeader="Selenium-Python Tutorial".trim();
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Thread.sleep(1000);
        List<WebElement> allLinks=driver.findElements(By.xpath("//p//a"));
        for (WebElement links:allLinks){
            links.getAttribute("href");

            System.out.println(links);
        }


    }
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes");
        driver.switchTo().frame("Framename1");
        WebElement category= driver.findElement(By.xpath("//a[contains(text(),'Category1')]"));
        category.click();
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation");
        WebElement header= driver.findElement(By.tagName("h1"));
        String expectedHeader="Category Archives: SeleniumTesting".trim();
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Thread.sleep(1000);
        List<WebElement> links=driver.findElements(By.xpath("//h3//a"));
        for (WebElement allLinks:links) {
            System.out.println(allLinks.getAttribute("href"));

        }
    }
    @Test
    public void practice3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes");
        driver.switchTo().frame("Framename1");
        WebElement category = driver.findElement(By.xpath("//a[contains(text(),'Category1')]"));
        category.click();
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().parentFrame(); // we use it to switch frames
        driver.switchTo().frame("Frame2");
        Thread.sleep(1000);
        WebElement category3= driver.findElement(By.xpath("//a[contains(text(),'Category3')]"));
        category3.click();
    }

}
