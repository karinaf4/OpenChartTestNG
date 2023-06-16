package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathhealthProject {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement button= driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        button.click();

        WebElement name= driver.findElement(By.xpath("//input[@id='txt-username']"));
        name.sendKeys("John Doe");

        WebElement pass= driver.findElement(By.xpath("//input[@id='txt-password']"));
        pass.sendKeys("ThisIsNotAPassword");

        WebElement loginBtn= driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginBtn.click();

        Thread.sleep(2000);

        WebElement facility= driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Hongkong CURA Healthcare Center");

        WebElement checkBox= driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        checkBox.click();

        WebElement medicId= driver.findElement(By.xpath("//input[@value='Medicaid']"));
        medicId.click();

        WebElement date= driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("5/19/2023");

        WebElement comment= driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("Comment");

        Thread.sleep(3000);

        WebElement button2= driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        button2.click();

        WebElement apptText= driver.findElement(By.xpath("//h2[contains(text(), 'Appointment Confirmation')]"));
        String actualText= apptText.getText().trim();
        String expectedText="Appointment Confirmation";

       if (actualText.equals(expectedText)){
           System.out.println("Confirmed");
       }

        WebElement h1= driver.findElement(By.xpath("//p[contains(text(), 'Hongkong CURA Healthcare Center')]"));
        System.out.println(h1.getText());

        WebElement h2= driver.findElement(By.xpath("//p[contains(text(), 'Yes')]"));
        System.out.println(h2.getText());

        WebElement h3= driver.findElement(By.xpath("//p[contains(text(), 'Medicaid')]"));
        System.out.println(h3.getText());

        WebElement h4= driver.findElement(By.xpath("//p[contains(text(), '05/07/2023')]"));
        System.out.println(h4.getText());

        WebElement h5= driver.findElement(By.xpath("//p[contains(text(), 'Comment')]"));
        System.out.println(h5.getText());

        WebElement HomePage= driver.findElement(By.xpath("//a[contains(text(), 'Go to Homepage')]"));
        HomePage.click();
        driver.quit();
    }
}
