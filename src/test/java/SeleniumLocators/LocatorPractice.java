package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.openqa.selenium.By.*;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName= driver.findElement(name("firstname"));
        firstName.sendKeys("Karina");

        WebElement lastName= driver.findElement(name("lastname"));
        lastName.sendKeys("Faizullina");

        WebElement genderBox= driver.findElement(id("sex-1"));
            genderBox.click();


        Thread.sleep(3000);

        WebElement expBox= driver.findElement(id("exp-4"));
            expBox.click();

        Thread.sleep(3000);
        WebElement date= driver.findElement(id("datepicker"));
        date.sendKeys("5/17/2023");

         Thread.sleep(3000);
        WebElement tool= driver.findElement(By.id("tool-2"));
            tool.click();


        Thread.sleep(3000);
        WebElement prof= driver.findElement(id("profession-0"));
            prof.click();

Thread.sleep(3000);
        WebElement prof1= driver.findElement(id("profession-1"));
            prof1.click();

        Thread.sleep(3000);
        WebElement button= driver.findElement(id("submit"));
        button.click();
    }
}
