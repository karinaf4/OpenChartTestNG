package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    public static void main(String[] args) throws InterruptedException {
        //locators ia a way to find elementd and manipulate them

        // id locator

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.navigate().to("file:///C:/Users/kylek/Downloads/Techtorial.html");
        driver.manage().window().maximize();
        WebElement header= driver.findElement(By.id("techtorial1"));
        String actualHeader= header.getText().trim();// it gets text element
        String expectedHeader="Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader) ? "correct" : "wrong");
        WebElement header2=driver.findElement(By.id("details2"));
        System.out.println(header2.getText());
WebElement header3= driver.findElement(By.id("signOn"));
        System.out.println(header3.getText());

        //NAME LOCATOR

        WebElement firstName= driver.findElement(By.name("firstName"));
        firstName.sendKeys("Karina");

        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Faiz");


        //CLASS LOCATOR

        WebElement AllTools= driver.findElement(By.className("group_checkbox"));
        System.out.println(AllTools.getText());

        WebElement javaBox= driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isSelected()? "selected ":" not selected");

        WebElement Cucumber= driver.findElement(By.id("cond4"));
        if (Cucumber.isDisplayed() && !Cucumber.isSelected()){
            Cucumber.click();
        }
        WebElement TestNG= driver.findElement(By.id("cond3"));
        if (TestNG.isDisplayed()&& !TestNG.isSelected()){
            TestNG.click();

        }
  //Tag name locator

       WebElement header5=driver.findElement(By.tagName("h1")) ;
        System.out.println(header5.getText());
WebElement header6= driver.findElement(By.tagName("u"));
        System.out.println(header6.getText());
        Thread.sleep(2000);
        driver.quit();
    }
}
