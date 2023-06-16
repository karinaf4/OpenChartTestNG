package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    @Test
    public void practiceMultipleWindows(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        String mainPage= driver.getWindowHandle();
        Set<String>allPages=driver.getWindowHandles();
        for (String id:allPages) {
            if (!id.equals(mainPage)){
                driver.switchTo().window(id);
                break;
            }
        }
        BrowserUtils.switchByTitle(driver,"Contact us");
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Kickstart");
        System.out.println(driver.getTitle());


    }
    @Test
    public void realTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button4 = driver.findElement(By.id("newTabsBtn"));
        button4.click();
        Thread.sleep(1000);
        BrowserUtils.switchByTitle(driver, "Basic Controls");
        Thread.sleep(1000);
        WebElement name = driver.findElement(By.id("firstName"));
        name.sendKeys("Karina");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Faizullina");
        Thread.sleep(1000);
        WebElement buttonG= driver.findElement(By.id("femalerb"));
        buttonG.click();
        WebElement language= driver.findElement(By.id("englishchbx"));
        language.click();
        WebElement email= driver.findElement(By.id("email"));
        email.sendKeys("karina@gmail.com");
        WebElement pass= driver.findElement(By.id("password"));
        pass.sendKeys("12345");
        WebElement register= driver.findElement(By.id("registerbtn"));
        register.click();
        WebElement msg= driver.findElement(By.id("msg"));
        String expected="Registration is Successful".trim();
        Assert.assertEquals(BrowserUtils.getText(msg),expected);
        BrowserUtils.switchByTitle(driver,"Window Handles");
        WebElement header= driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String expectedHeader="Window Handles Practice".trim();
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Thread.sleep(1000);
        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement buttonClick= driver.findElement(By.id("promptBox"));
        buttonClick.click();
        driver.quit();
    }
}
