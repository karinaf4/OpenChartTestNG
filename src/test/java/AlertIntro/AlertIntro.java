package AlertIntro;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void AlertIntroPractice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        String actual = alert.getText().trim();
        String expectedText = "I am a JS Alert";
        Assert.assertEquals(actual, expectedText);
        alert.accept();// will click OK button
        WebElement message = driver.findElement(By.cssSelector(".result"));
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(BrowserUtils.getText(message), expectedMessage);


    }

    @Test
    public void AlertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement JsConfirm = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        JsConfirm.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement message = driver.findElement(By.xpath("//p[contains(@id,'resul')]"));
    }

    @Test
    public void AlertPractice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt= driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Thread.sleep(1000);
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Homework is important");
        alert.accept();
        WebElement message= driver.findElement(By.cssSelector("#result"));

    }
}