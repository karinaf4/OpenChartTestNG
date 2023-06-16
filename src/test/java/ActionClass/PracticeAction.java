package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class PracticeAction {
    @Test
    public void practiceDragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        Actions actions=new Actions(driver);
        actions.scrollByAmount(200,200);
        WebElement drop= driver.findElement(By.cssSelector("#draggable"));
        Thread.sleep(2000);
        WebElement drag= driver.findElement(By.cssSelector("#droppable"));
        actions.dragAndDrop(drop,drag).perform();



    }
    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        Thread.sleep(2000);
        WebElement accept= driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        accept.click();
        Thread.sleep(2000);
        WebElement drop= driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        WebElement notaccept= driver.findElement(By.cssSelector("#notAcceptable"));
        Thread.sleep(2000);
        Actions actions=new Actions(driver);

        actions.scrollByAmount(200,200);

        actions.clickAndHold(notaccept).moveToElement(drop).release().perform();


    }

}
