package POPPORTAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class akıllıbinalarsilersinsonra {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAMSUNG\\chrome_web_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://185.99.199.194:8181/portal/#/login");

        driver.findElement(By.cssSelector("input[placeholder='Kullanıcı Adı']")).sendKeys("gokman");
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345678");
        driver.findElement(By.cssSelector("button[class='login-btn mat-raised-button mat-button-base']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@routerlink='employee']/div")).click();

        List<WebElement> depo= driver.findElements(By.xpath("//tbody[@role='rowgroup']/tr"));
        System.out.println(depo.size());


    }

}
