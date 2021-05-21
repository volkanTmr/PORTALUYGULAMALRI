package ALLPORTAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckWarningTitleOfEnterUsername {  //JIRA 4. ODEV(mouse ile ad a gelip gidince uyarı yazısı geliyor mu kontrol)


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAMSUNG\\chrome_web_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://185.99.199.194:8181/portal/#/login");

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector("input[formcontrolname='userName']"))).click().build().perform();
        a.moveToElement(driver.findElement(By.cssSelector("input[formcontrolname='password']"))).click().build().perform();
        Thread.sleep(15000);

        if (driver.findElement(By.cssSelector("div[class='mat-form-field-infix']")).getText().contains("Kullanıcı adı giriniz")) {
            System.out.println(" (Kullanıcı adı giriniz) uyarı yazısı göründü");
            System.out.println("success");
        }

        else{
            System.out.println("görünmedi");
        }
    }
}
