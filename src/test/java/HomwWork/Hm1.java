package HomwWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hm1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement name= driver.findElement(By.xpath("//input[@id='userName']"));
        name.sendKeys("Karina Faizullina");

        WebElement email= driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("karina@gmail.com");

        WebElement address= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        address.sendKeys("123 Halsted St, Chicago");

        WebElement address2= driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        address2.sendKeys("345 Halsted St, Chicago");
        Thread.sleep(3000);

        WebElement button1=driver.findElement(By.xpath("//button[@id='submit']"));
        button1.click();

        WebElement h1=driver.findElement(By.xpath("//p[@id='name']"));
        String actualH1= h1.getText().trim();
        String expectedH1="Name:Karina Faizullina";
        if (actualH1.equals(expectedH1)){
            System.out.println(h1.getText());
        }else {
            System.out.println("wrong");
        }


        WebElement h2= driver.findElement(By.xpath("//p[@id='email']"));
        String actualH2=h2.getText().trim();
        String expectedH2="Email:karina@gmail.com";
        if (actualH2.equals(expectedH2)){
            System.out.println(h2.getText());
        }else {
            System.out.println("wrong");
        }

        WebElement h3=driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String actualH3=h3.getText().trim();
        String expectedH3="Current Address :123 Halsted St, Chicago";
        if (actualH3.equals(expectedH3)){
            System.out.println(h3.getText());
        }else{
            System.out.println("wrong");
        }

        WebElement h4=driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String actualH4= h4.getText().trim();
        String expectedH4="Permananet Address :345 Halsted St, Chicago";
        if (actualH4.equals(expectedH4)){
            System.out.println(h4.getText());
        }else {
            System.out.println("wrong");
        }
    }
}
