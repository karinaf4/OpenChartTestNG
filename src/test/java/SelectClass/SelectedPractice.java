package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectedPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote=allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/kylek/Downloads/Techtorial.html");

        Thread.sleep(2000);
        WebElement optionsCountr= driver.findElement(By.xpath("//select[@name='country']"));
        Select countries=new Select(optionsCountr);
        String actual=countries.getFirstSelectedOption().getText().trim();
        String expected="UNITED STATES";
        Assert.assertEquals(actual,expected);
        Thread.sleep(2000);

        List<WebElement>countries2=countries.getOptions();
        int counter=0;
        for (WebElement cntr:countries2){
            System.out.println(cntr.getText().trim());
            counter++;
        }
        System.out.println(counter);
        Thread.sleep(2000);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");

        countries.selectByVisibleText("RUSSIA");
        Thread.sleep(2000);
        countries.selectByValue("215");
        Thread.sleep(2000);
        countries.selectByIndex(3);
        Thread.sleep(2000);
    }
}
