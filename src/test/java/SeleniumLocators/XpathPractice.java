package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName= driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Karina");

        WebElement lastNme= driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastNme.sendKeys("Faiz");

        WebElement email= driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("karinaaaaaaaa1997@gmail.com");

        WebElement tel= driver.findElement(By.xpath("//input[@id='input-telephone']"));
        tel.sendKeys("123456");

        WebElement pass= driver.findElement(By.xpath("//input[@id='input-password']"));
        pass.sendKeys("5555");

        WebElement pass2= driver.findElement(By.xpath("//input[@id='input-confirm']"));
        pass2.sendKeys("5555");

        WebElement checkbox= driver.findElement(By.xpath("//input[@name='agree']"));
        checkbox.click();

        WebElement buttonC= driver.findElement(By.xpath("//input[@value='Continue']"));
        buttonC.click();


    }
}
