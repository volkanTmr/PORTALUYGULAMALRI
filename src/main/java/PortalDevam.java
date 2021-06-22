import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PortalDevam {  // tanımlar menusune tıklayınca lookup page geliyor mu

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAMSUNG\\chrome_web_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://185.99.199.194:8181/portal/#/login");

        driver.findElement(By.cssSelector("input[placeholder='Kullanıcı Adı']")).sendKeys("gokman");
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345678");
        driver.findElement(By.cssSelector("button[class='login-btn mat-raised-button mat-button-base']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("(//div[@class='mat-list-item-content'])[1]")).click();
        WebElement targetTitle= driver.findElement(By.xpath("//mat-header-cell[@class='mat-header-cell cdk-column-parentvalue mat-column-parentvalue ng-star-inserted']"));
        System.out.println(targetTitle.getText());

        if(targetTitle.getText().contains("Lookup")){

            System.out.println(" lookup page is visible" );
            System.out.println("success");
        }
        else {
            System.out.println("lookup page not visible");
        }

    }

}
