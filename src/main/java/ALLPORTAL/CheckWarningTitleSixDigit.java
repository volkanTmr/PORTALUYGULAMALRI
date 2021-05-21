package ALLPORTAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckWarningTitleSixDigit {  // JIRA 6. ODEV( girilen şifre haneden az uyarı yazısı geliyor mu/hayır)

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAMSUNG\\chrome_web_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://185.99.199.194:8181/portal/#/login");
        driver.findElement(By.cssSelector("input[placeholder='Kullanıcı Adı']")).sendKeys("gokman");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345");
        Thread.sleep(3000);

        if (driver.findElement(By.cssSelector("div[class='mat-form-field-infix']")).getText().contains("6 haneden az giremezsiniz") ) {
            System.out.println("(6 haneden az giremezsiniz) uyari yazısı geldi");
        }

        else{
            System.out.println("uyarı yazısı gelmedi");
        }

    }

}
