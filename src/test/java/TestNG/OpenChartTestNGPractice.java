package TestNG;

import Utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNGPractice {
    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(ConfigReader.readProperty("QA_url"));

        WebElement name=driver.findElement(By.id("input-username"));
        name.sendKeys(ConfigReader.readProperty("QA_openChart_username"));

        WebElement pass= driver.findElement(By.id("input-password"));
        pass.sendKeys(ConfigReader.readProperty("QA_openChart_password"));
        Thread.sleep(2000);
        WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(),"Dashboard");


    }
    @Test
    public void negativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement pass= driver.findElement(By.id("input-password"));
        pass.sendKeys("DEMOO");
        Thread.sleep(2000);
        WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button.click();
        Thread.sleep(3000);
        WebElement error= driver.findElement(By.id("alert"));
        System.out.println(error.getText());
    }

    @Test
    public void validationOfCatalog() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement name=driver.findElement(By.id("input-username"));
        name.sendKeys("demo");

        WebElement pass= driver.findElement(By.id("input-password"));
        pass.sendKeys("demo");
        Thread.sleep(2000);
        WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button.click();
        Thread.sleep(3000);

        WebElement buttonClose= driver.findElement(By.cssSelector(".btn-close"));
        buttonClose.click();
        WebElement catalog= driver.findElement(By.id("menu-catalog"));
        catalog.click();
        Thread.sleep(2000);
        WebElement product= driver.findElement(By.linkText("Products"));
        String actual= product.getText().trim();
        String expected="Products";
        Assert.assertEquals(actual,expected);
        Assert.assertTrue(product.isDisplayed());


    }
    @Test
    public void BoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement name=driver.findElement(By.id("input-username"));
        name.sendKeys("demo");

        WebElement pass= driver.findElement(By.id("input-password"));
        pass.sendKeys("demo");
        Thread.sleep(2000);
        WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button.click();
        Thread.sleep(3000);

        WebElement buttonClose= driver.findElement(By.cssSelector(".btn-close"));
        buttonClose.click();
        WebElement catalog= driver.findElement(By.id("menu-catalog"));
        catalog.click();
        Thread.sleep(2000);
        WebElement product= driver.findElement(By.linkText("Products"));
        product.click();
        Thread.sleep(3000);

        List<WebElement> elemens=driver.findElements(By.xpath("//input[@type='checkbox']"));
        //for (WebElement Allelemens:elemens) {
       //     Thread.sleep(3000);
         //   Assert.assertTrue(Allelemens.isDisplayed());
           // Assert.assertTrue(Allelemens.isEnabled());
            //Assert.assertFalse(Allelemens.isSelected());
            //if (!Allelemens.isSelected()){
              //  Allelemens.click();
            //}
            //Thread.sleep(2000);
            //Assert.assertTrue(Allelemens.isSelected());
            //Allelemens.sendKeys(Keys.ARROW_DOWN);
        //}
        for (int i=1; i<=elemens.size();i++){
            Thread.sleep(2000);
        // Assert.assertTrue(elemens.get(i).isDisplayed());
         //Assert.assertTrue(elemens.get(i).isEnabled());
            elemens.get(i).click();
            elemens.get(i).sendKeys(Keys.ARROW_DOWN);
            elemens.get(i).sendKeys(Keys.ARROW_DOWN);
            elemens.get(i).sendKeys(Keys.ARROW_DOWN);

        }
    }
    @Test
    public void Ascending() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement name=driver.findElement(By.id("input-username"));
        name.sendKeys("demo");

        WebElement pass= driver.findElement(By.id("input-password"));
        pass.sendKeys("demo");
        Thread.sleep(2000);
        WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button.click();
        Thread.sleep(3000);

        WebElement buttonClose= driver.findElement(By.cssSelector(".btn-close"));
        buttonClose.click();
        WebElement catalog= driver.findElement(By.id("menu-catalog"));
        catalog.click();
        Thread.sleep(2000);
        WebElement product= driver.findElement(By.linkText("Products"));
        product.click();
        Thread.sleep(3000);

       WebElement ProductButton= driver.findElement(By.cssSelector(".asc"));
       ProductButton.click();
       Thread.sleep(2000);

       List<WebElement> AllElements=driver.findElements(By.cssSelector(".text-start"));
       List<String> actual=new ArrayList<>();
       List<String> expected=new ArrayList<>();
       for (int i=1; i<=AllElements.size();i++){
           actual.add(AllElements.get(i).getText().toLowerCase().trim());
           expected.add(AllElements.get(i).getText().toLowerCase().trim());

       }
        Collections.sort(expected);
        System.out.println(actual);
        System.out.println(expected);
       Assert.assertEquals(actual,expected);
    }
    @Test

    public void descending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement name=driver.findElement(By.id("input-username"));
        name.sendKeys("demo");

        WebElement pass= driver.findElement(By.id("input-password"));
        pass.sendKeys("demo");
        Thread.sleep(2000);
        WebElement button= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button.click();
        Thread.sleep(3000);

        WebElement buttonClose= driver.findElement(By.cssSelector(".btn-close"));
        buttonClose.click();
        WebElement catalog= driver.findElement(By.id("menu-catalog"));
        catalog.click();
        Thread.sleep(2000);
        WebElement product= driver.findElement(By.linkText("Products"));
        product.click();
        Thread.sleep(3000);

        WebElement ProductButton= driver.findElement(By.cssSelector(".asc"));
        ProductButton.click();
        Thread.sleep(2000);

        List<WebElement> AllElements=driver.findElements(By.cssSelector(".text-start"));
        List<String> actual=new ArrayList<>();
        List<String> expected=new ArrayList<>();
        Thread.sleep(3000);
        for (int i=1; i<=AllElements.size();i++){
            actual.add(AllElements.get(i).getText().toLowerCase().trim());
            expected.add(AllElements.get(i).getText().toLowerCase().trim());

        }
        Collections.sort(expected);
        Collections.reverse(expected);
        System.out.println(actual);
        System.out.println(expected);
        Assert.assertEquals(actual,expected);

    }
    }


