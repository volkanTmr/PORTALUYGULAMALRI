import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MigrosNG {

    WebDriver driver;

    @BeforeMethod
    public  void setUp() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAMSUNG\\chrome_web_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.migros.com.tr/");
        Thread.sleep(80000);
        driver.manage().deleteAllCookies();
        MigrosNG mig=new MigrosNG();
        mig.Choose();
    }

    @Test
    public void Choose(){

        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.xpath("//a[@class='category-card ng-tns-c335-3']")).click();
    }
}
//JavascriptExecutor js = (JavascriptExecutor) driver;
//String el = "document.getElementById('butonunIDsi').click()";
//js.executeScript(el);