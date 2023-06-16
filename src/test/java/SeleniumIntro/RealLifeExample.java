package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RealLifeExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.godaddy.com/");
        String actualTitle=driver.getTitle();
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        if (actualTitle.equals(actualTitle)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.godaddy.com/";
        if (actualUrl.equals(expectedUrl)){
            System.out.println("Url is passed");
        }else{
            System.out.println("url is failed");
        }
        driver.close();
    }
}
