package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriverMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        //Maximizes the screen
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        //***
        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back(); // it will go back to google , we were in youtobe
        System.out.println(driver.getTitle());
        driver.navigate().forward();
        System.out.println(driver.getTitle());


        System.out.println(driver.getPageSource());// it gets the html structure

        driver.quit();// it closes all pages opened from 1 automation
    }
}
