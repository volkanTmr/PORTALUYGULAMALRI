package ALLPORTAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckWarningTitleOfEnterPassword {   // JIRA 5. ODEV( mouse ile şifre üzerine gidip bişey yazmadığımızda uyarı yazısı geliyor mu)

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAMSUNG\\chrome_web_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://185.99.199.194:8181/portal/#/login");

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector("input[formcontrolname='password']"))).click().build().perform();
        a.moveToElement(driver.findElement(By.cssSelector("input[formcontrolname='userName']"))).click().build().perform();
        Thread.sleep(15000);


        if (driver.findElement(By.cssSelector("div[class='text-danger ng-star-inserted']")).getText().contains("Şifre giriniz")) {
            System.out.println("(Şifre giriniz) uyarı yazısı göründü");
            System.out.println("successs");

        }

        else{
            System.out.println("görünmedi");
        }
    }
}
