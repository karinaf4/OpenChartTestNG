package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

        WebElement button= driver.findElement(By.cssSelector("#btn-make-appointment"));
        button.click();
        WebElement name= driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(name.getAttribute("value")); // john doe
        System.out.println(name.getAttribute("type")); // text

        WebElement pass= driver.findElement(By.xpath("//input[@value='ThisIsNotAPassword']"));
        System.out.println(pass.getAttribute("value"));



    }
}
