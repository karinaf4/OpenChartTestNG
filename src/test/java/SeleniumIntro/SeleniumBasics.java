package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Set;

public class SeleniumBasics {
    //setting up automation
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //Create your driver to start automation
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        String actualTitle= driver.getTitle();
        String expectedTitle="Amazon.com. Spend less. Smile more.";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com/";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("url is passed");
        }else {
            System.out.println("url is failed");
        }
      driver.close();
    }
}
