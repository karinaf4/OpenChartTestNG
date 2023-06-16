package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public void HeaderOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.cars.com/");
        WebElement car= driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(car,"lexus","value");
        Thread.sleep(2000);
        WebElement models= driver.findElement(By.id("models"));
        BrowserUtils.selectBy(models,"lexus-rx_350","value");
        WebElement price= driver.findElement(By.id("make-model-max-price"));
        WebElement miles= driver.findElement(By.id("make-model-maximum-distance"));
        BrowserUtils.selectBy(miles,"40","value");
        Thread.sleep(1000);
        WebElement zip= driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zip.clear();
        zip.sendKeys("60056");
        Thread.sleep(2000);

        WebElement buttonnnn= driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        buttonnnn.click();
        Thread.sleep(1000);
        WebElement text= driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        String actual= text.getText().trim();
        String expected="New Lexus RX 350 for sale".trim();
        Assert.assertEquals(actual,expected);
        Thread.sleep(1000);

        WebElement searchB= driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(searchB,"list_price","value");
        Thread.sleep(2000);

        List<WebElement> cars=driver.findElements(By.xpath("//h2[@class='title']"));

       //// for (WebElement car1:cars) {
        //    if (car1.getText().contains("Lexus RX 350")){
         //       System.out.println("passed");
          //      break;
          //  }else{
          //      System.out.println("failed");
            for (WebElement car1:cars){
                Assert.assertTrue(BrowserUtils.getText(car1).contains("Lexus RX 350"));
                System.out.println(BrowserUtils.getText(car1));
            }

            List<WebElement> allPrices=driver.findElements(By.cssSelector(".primary-price"));
            List<Integer> actualprice= new ArrayList<>();
            List<Integer> expectedprice=new ArrayList<>();
        for (int i = 0; i < allPrices.size(); i++) {
            actualprice.add(Integer.parseInt(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","")));
            expectedprice.add(Integer.parseInt(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","")));

        }
        Collections.sort(expectedprice);
        Assert.assertEquals(expectedprice,actualprice);








    }
}
