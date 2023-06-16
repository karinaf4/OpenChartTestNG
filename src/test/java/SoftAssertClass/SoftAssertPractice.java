package SoftAssertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SoftAssertPractice {
    @Test
    public void Practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://hyrtutorials.com/p/alertsdemo.html");
        WebElement alertBox= driver.findElement(By.cssSelector("#alertBox"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",alertBox);
        alertBox.click();
        Alert alert=driver.switchTo().alert();
        String actualAlert=alert.getText();
        String expectedAlert="I am an alert box!";
        Assert.assertEquals(actualAlert,expectedAlert);
        alert.accept();
        Thread.sleep(1000);
        WebElement confirmBox= driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();
        Thread.sleep(2000);
        Alert alert2=driver.switchTo().alert();
        String expectedmsg="Press a button!";
        Assert.assertEquals(alert2.getText(),expectedmsg);
        alert2.dismiss();
        Thread.sleep(1000);
        WebElement promtBox= driver.findElement(By.cssSelector("#promptBox"));
        promtBox.click();
        Thread.sleep(1000);
        Alert alert3=driver.switchTo().alert();
        alert3.sendKeys("Karina");
        alert3.accept();


    }
}


