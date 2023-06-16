package AlertIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class HtmlAndJSPractice {
    @Test
    public void practiceBoth(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");
        WebElement preview1= driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        preview1.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        WebElement preview2= driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        preview2.click();
       WebElement button= driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
       button.click();


    }
}
