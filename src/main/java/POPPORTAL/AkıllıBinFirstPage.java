package POPPORTAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class AkıllıBinFirstPage {

    WebDriver driver;

    public AkıllıBinFirstPage(WebDriver driver)
    {
        this.driver=driver;
    }

    By workers=By.xpath("//a[@routerlink='employee']/div");

    public WebElement ButtonOfWorkers() { return driver.findElement(workers);}



        }



