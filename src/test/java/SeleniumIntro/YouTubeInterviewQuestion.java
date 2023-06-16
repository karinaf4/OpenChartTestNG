package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YouTubeInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.youtube.com/");
        Thread.sleep(2000);

        WebElement search= driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Rihanna");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        List<WebElement>songs=driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement song:songs ){
            if (song.getAttribute("title").equals("Rihanna - Needed Me")){
                Thread.sleep(3000);
                song.sendKeys(Keys.ARROW_DOWN);
                song.click();
                break;
            }
        }
    }
}
