package ALLPORTAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckIfGırısButtonActive {  //JIRA 2. ODEV( ad ve şifre doluyken button active mi)

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAMSUNG\\chrome_web_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://185.99.199.194:8181/portal/#/login");
        driver.findElement(By.cssSelector("input[placeholder='Kullanıcı Adı']")).sendKeys("gokman");
        Thread.sleep(3000);
        if (driver.findElement(By.cssSelector("div[class='mat-form-field-infix'] input")).getAttribute("class").contains("ng-valid")) {
            System.out.println("isim kısmı doludur");
        }

        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345678");
        Thread.sleep(3000);

        if (driver.findElement(By.cssSelector("input[placeholder='Şifre']")).getAttribute("aria-invalid").equalsIgnoreCase("false")) {
            System.out.println("şifre kısmı doludur");
        }

        WebElement buttonGiriş=driver.findElement(By.cssSelector("button.login-btn.mat-raised-button.mat-button-base"));
        Thread.sleep(15000);

        if(buttonGiriş.isDisplayed()){
            System.out.println("giriş buton active");
            System.out.println("success");
        }
        else{
            System.out.println("giriş buton passive");
        }

    }

}
