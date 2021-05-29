package POPPORTAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TargetWorkers {

    WebDriver driver;

    public TargetWorkers(WebDriver driver) { this.driver=driver; }

    By targetworker = By.cssSelector("td[text()='Ahmet Yılmaz']");

    public WebElement WorkerAhmet()
    {
        return driver.findElement(targetworker);
    }

}
