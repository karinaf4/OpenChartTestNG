package SelectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectMidLevelPractice {
    @Test
    public void validateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote=allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement type = driver.findElement(By.xpath("//input[@value='oneway']"));
        type.click();
        Thread.sleep(2000);
        WebElement passng = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select choice = new Select(passng);
        choice.selectByValue("4");
        Thread.sleep(2000);
        WebElement depart = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select choice2 = new Select(depart);
        String actual = choice2.getFirstSelectedOption().getText().trim();
        String expected = "Acapulco";
        Assert.assertEquals(actual, expected);
        Thread.sleep(2000);
        WebElement date = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select choice3 = new Select(date);
        choice3.selectByValue("3");
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.xpath("//input[@value='First']"));
        button.click();
        Thread.sleep(2000);
        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select choice4 = new Select(airline);
        choice4.selectByVisibleText("Unified Airlines");
        Thread.sleep(2000);
        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        Thread.sleep(2000);
        WebElement text = driver.findElement(By.xpath("//font[@size='4']"));
        String actual1 = text.getText().trim();
        String expected1 = "After flight finder - No Seats Avaialble".trim();
        Assert.assertEquals(actual1, expected1);


    }

    @Test
    public class SelectMidLevelPracticeShortCut {
        @Test
        public void validateOrderMessage() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote=allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

            WebElement type = driver.findElement(By.xpath("//input[@value='oneway']"));
            type.click();
            Thread.sleep(2000);
            WebElement passng = driver.findElement(By.xpath("//select[@name='passCount']"));
           // Select choice = new Select(passng);
           // choice.selectByValue("4");
            BrowserUtils.selectBy(passng,"4","value");
            Thread.sleep(2000);
            WebElement depart = driver.findElement(By.xpath("//select[@name='fromPort']"));
            BrowserUtils.selectBy(depart,"Acapulo","value");

            Thread.sleep(2000);
            WebElement date = driver.findElement(By.xpath("//select[@name='fromMonth']"));
            BrowserUtils.selectBy(date,"3","value");
            Thread.sleep(2000);
            WebElement button = driver.findElement(By.xpath("//input[@value='First']"));
            button.click();
            Thread.sleep(2000);
            WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
            //Select choice4 = new Select(airline);
          //  choice4.selectByVisibleText("Unified Airlines");
            BrowserUtils.selectBy(airline,"Unified Airlines","text");
            Thread.sleep(2000);
            WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
            continueButton.click();
            Thread.sleep(2000);
            WebElement text = driver.findElement(By.xpath("//font[@size='4']"));
            String actual1 = text.getText().trim();
            String expected1 = "After flight finder - No Seats Avaialble".trim();
            Assert.assertEquals(BrowserUtils.getText(text), expected1);
        }
    }
}