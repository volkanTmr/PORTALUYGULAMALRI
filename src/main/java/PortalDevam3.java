import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PortalDevam3 {


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
        driver.findElement(By.cssSelector("button[class='new-button mat-raised-button mat-button-base']")).click();
        WebElement tanımlarPopUpChart = driver.findElement(By.xpath("//div/mat-dialog-container"));
        Thread.sleep(5000);

        if(tanımlarPopUpChart.isDisplayed()){

            System.out.println(" yeni tanım popUpChart is visible" );
            System.out.println("success");
        }
        else {
            System.out.println(" yeni tanım popUpChart not visible");
        }
    }

    }
