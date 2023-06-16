package FrameAndIFrame;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void NestedFramePractice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        WebElement leftFrame= driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(leftFrame);
        driver.switchTo().parentFrame();
        WebElement middleFrame= driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(middleFrame);
        WebElement middle=driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        System.out.println(BrowserUtils.getText(middle));
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);// Bottom
        WebElement bottom= driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottom));

    }
}
