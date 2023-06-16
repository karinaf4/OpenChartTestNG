package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        WebElement clickButton= driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        clickButton.click();
        WebElement text= driver.findElement(By.tagName("h3"));
        System.out.println(driver.getWindowHandle());
        String mainId= driver.getWindowHandle();
        Set<String>allPagesId=driver.getWindowHandles();
        for (String id:allPagesId){
            if (!id.equals(mainId)){
                driver.switchTo().window(id);
                break;
            }
            System.out.println(driver.getWindowHandle());
        }
        text= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(text));

    }
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement button2= driver.findElement(By.cssSelector("#newTabBtn"));
        Thread.sleep(1000);
        button2.click();
        Thread.sleep(1000);
        WebElement header= driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Thread.sleep(1000);
        String mainId= driver.getWindowHandle();
        Set<String>allPages = driver.getWindowHandles();
        for (String id:allPages) {
            if (!id.equals(mainId)){
                driver.switchTo().window(id);
            }

        }
        header= driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        System.out.println(BrowserUtils.getText(header) + driver.getTitle());
        Thread.sleep(1000);
        WebElement button1= driver.findElement(By.cssSelector("#alertBox"));
        button1.click();
    }
}
