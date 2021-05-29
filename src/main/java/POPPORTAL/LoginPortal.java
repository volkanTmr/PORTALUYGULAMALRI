package POPPORTAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPortal {

    WebDriver driver;

    public LoginPortal(WebDriver driver)
    {
        this.driver=driver;
    }

    By username = By.cssSelector("input[placeholder='Kullanıcı Adı']");
    By password = By.xpath("//input[@formcontrolname='password']");
    By buttonEnter = By.cssSelector("button[class='login-btn mat-raised-button mat-button-base']");

    public WebElement UserId()
    {
        return driver.findElement(username);
    }

    public WebElement PassId()
    {
        return driver.findElement(password);
    }

    public WebElement ButtonClick()
    {
        return driver.findElement(buttonEnter);
    }


}
