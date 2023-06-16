package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void Practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement uploadB = driver.findElement(By.cssSelector("#file-upload"));
        uploadB.sendKeys("C:\\Users\\kylek\\Downloads\\usa.png");
        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();
        Thread.sleep(1000);
        WebElement message = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(BrowserUtils.getText(message), "File Uploaded!".trim());

    }

    @Test
    public void Practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement file= driver.findElement(By.cssSelector("#uploadfile_0"));
        file.submit();
        Thread.sleep(1000);
        file.sendKeys("C:\\Users\\kylek\\Downloads\\usa.png");
        WebElement msg= driver.findElement(By.xpath("//b[contains(text(),'Select file')]"));
        Assert.assertEquals(BrowserUtils.getText(msg),"Select file to send(max 196.45 MB)".trim());
        Thread.sleep(1000);
        WebElement terms= driver.findElement(By.cssSelector("#terms"));
        terms.click();
        Thread.sleep(1000);
        WebElement submitB= driver.findElement(By.cssSelector("#submitbutton"));
        submitB.click();
        Thread.sleep(2000);
        //WebElement text= driver.findElement(By.xpath("//center[contains(text(),'1 file')]"));
       //Assert.assertEquals(BrowserUtils.getText(text),"1 file".trim());
        WebElement text2=driver.findElement(By.xpath("//h3//center"));
        System.out.println(BrowserUtils.getText(text2));






    }
}