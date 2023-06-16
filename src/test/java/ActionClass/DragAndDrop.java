package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDrop {
    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Actions actions=new Actions(driver);
        actions.scrollByAmount(200,200).perform();
        WebElement orangeBox= driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actual= BrowserUtils.getText(orangeBox);
        String expected="... Or here.";
        Assert.assertEquals(actual,expected);
        String actualColor=orangeBox.getCssValue("background-color");
        WebElement circle= driver.findElement(By.xpath("//div[@id='draggable']"));
        Thread.sleep(2000);
        actions.dragAndDrop(circle,orangeBox).perform();



    }
    @Test
    public void DragAndDrop1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement blueBox= driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessage=BrowserUtils.getText(blueBox);
        String expectedMessage="Drag the small circle here ...";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualColor=blueBox.getCssValue("background-color");
        String expectedColor="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor,expectedColor);
        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));

        Actions action=new Actions(driver);
        action.clickAndHold(draggable).moveToElement(blueBox).release().perform();
    }
}
