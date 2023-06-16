package HomwWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hm2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement name= driver.findElement(By.xpath("//input[@id='user-name']"));
        name.sendKeys("Java");

        WebElement pass= driver.findElement(By.xpath("//input[@id='password']"));
        pass.sendKeys("Selenium");

        WebElement login= driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        WebElement error= driver.findElement(By.xpath("//div[@class='error-message-container error']"));
        System.out.println(error.getText());
    }
}
