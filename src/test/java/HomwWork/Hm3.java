package HomwWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hm3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com");

        WebElement name= driver.findElement(By.xpath("//input[@id='user-name']"));
        name.sendKeys("standard_user");

        WebElement pass= driver.findElement(By.xpath("//input[@id='password']"));
        pass.sendKeys("secret_sauce");

        WebElement loginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        Thread.sleep(3000);

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        if (actualUrl.equals(expectedUrl)){
            System.out.println(driver.getCurrentUrl());
        }else{
            System.out.println("Failed");
        }
    }
}
