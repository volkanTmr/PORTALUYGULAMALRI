import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class PortalWithTestNG {   // JIRA 1. ODEV( ad dolu şifre boş iken button passive mi)

    public static void main(String[] args) throws InterruptedException {


            System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAMSUNG\\chrome_web_driver\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://185.99.199.194:8181/portal/#/login");
            driver.findElement(By.cssSelector("input[placeholder='Kullanıcı Adı']")).sendKeys("gokman");
            driver.findElement(By.cssSelector("input[type='password']")).sendKeys("");
            Thread.sleep(3000);

            if(driver.findElement(By.cssSelector("button[class='login-btn mat-raised-button mat-button-base']")).getAttribute("disabled").contains("true"))
            {
                System.out.println("button passive");
                System.out.println("success");

            }

            else
            {
                System.out.println("button active");
            }

        }

    }


