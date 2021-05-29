package POPPORTAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class ManagePageOfPortal {


    @Test
    public void setUp() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAMSUNG\\chrome_web_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://185.99.199.194:8181/portal/#/login");

        LoginPortal lp=new LoginPortal(driver);
        lp.UserId().sendKeys("gokman");
        lp.PassId().sendKeys("12345678");
        lp.ButtonClick().click();
        Thread.sleep(5000);

        AkıllıBinFirstPage akbin=new AkıllıBinFirstPage(driver);
        akbin.ButtonOfWorkers().click();
        Thread.sleep(5000);

        List<WebElement> iterThis = driver.findElements(By.cssSelector("td[class='mat-cell cdk-column-name mat-column-name ng-tns-c14-15 ng-star-inserted']"));
        Iterator<WebElement> iter = iterThis.iterator();
        System.out.println(iter);


        //TargetWorkers tw=new TargetWorkers(driver);
        //tw.WorkerAhmet().click();
    }

}
