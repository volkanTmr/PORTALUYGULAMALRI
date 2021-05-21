import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TryPortal {

    WebDriver driver;
    
    @BeforeMethod
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAMSUNG\\chrome_web_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://185.99.199.194:8181/portal/#/login");
    }

    @Test
    public  void CheckIfButtonPassive() throws InterruptedException {   // JIRA 1. ODEV( ad dolu şifre boş iken button passive mi)

            driver.findElement(By.cssSelector("input[placeholder='Kullanıcı Adı']")).sendKeys("gokman");
            //driver.findElement(By.cssSelector("input[type='password']")).sendKeys(""); - iki şekilde olabilir 1. hiçbirşey girmeden boş bırakılarak
            Actions a = new Actions(driver);// - 2. actions objesiyle mouse ile password üzerine gelip hiçbir şey yazmadan sadece click yapıyoruz
            a.moveToElement(driver.findElement(By.cssSelector("input[type='password']"))).click().build().perform();
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

    @Test
    public void CheckIfEnterButtonActive() throws InterruptedException {  //JIRA 2. ODEV( ad ve şifre doluyken button active mi)

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

            WebElement buttonEnter=driver.findElement(By.cssSelector("button.login-btn.mat-raised-button.mat-button-base"));
            Thread.sleep(15000);

            if(buttonEnter.isDisplayed()){
                System.out.println("giriş buton active");
                System.out.println("success");
            }
            else{
                System.out.println("giriş buton passive");
            }

        }

    @Test
    public void CheckIfEnterButtonPassive() throws InterruptedException {   // JIRA 3. ODEV( ad boş şifre dolu iken button passive mi)

        driver.findElement(By.cssSelector("input[placeholder='Kullanıcı Adı']")).sendKeys("");
        Thread.sleep(3000);

        if (driver.findElement(By.cssSelector("div[class='mat-form-field-infix'] input")).getAttribute("class").contains("ng-valid")) {
            System.out.println("isim kısmı doludur");
        } else {
            System.out.println("isim kısmı boştur");
        }
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345678");
        Thread.sleep(3000);

        if (driver.findElement(By.cssSelector("input[placeholder='Şifre']")).getAttribute("aria-invalid").equalsIgnoreCase("false")) {
            System.out.println("şifre kısmı doludur");
        }

        WebElement buttonEnter = driver.findElement(By.cssSelector("button.login-btn.mat-raised-button.mat-button-base"));

        if (buttonEnter.getAttribute("disabled").contains("true")) {

            System.out.println("giriş buton passive");
            System.out.println("success");
        } else {
            System.out.println("giriş buton active");
        }

    }

    @Test
    public void CheckWarningTitleOfEnterUsername() throws InterruptedException {  //JIRA 4. ODEV(mouse ile ad a gelip gidince uyarı yazısı geliyor mu kontrol)

            Actions a = new Actions(driver);
            a.moveToElement(driver.findElement(By.cssSelector("input[formcontrolname='userName']"))).click().build().perform();
            a.moveToElement(driver.findElement(By.cssSelector("input[formcontrolname='password']"))).click().build().perform();
            Thread.sleep(15000);

            if (driver.findElement(By.cssSelector("div[class='mat-form-field-infix']")).getText().contains("Kullanıcı adı giriniz")) {
                System.out.println(" (Kullanıcı adı giriniz) uyarı yazısı göründü");
                System.out.println("success");
            }

            else{
                System.out.println("görünmedi");
            }
        }

    @Test
    public void CheckWarningTitleOfEnterPassword() throws InterruptedException {   // JIRA 5. ODEV( mouse ile şifre üzerine gidip bişey yazmadığımızda uyarı yazısı geliyor mu)

            Actions a = new Actions(driver);
            a.moveToElement(driver.findElement(By.cssSelector("input[formcontrolname='password']"))).click().build().perform();
            a.moveToElement(driver.findElement(By.cssSelector("input[formcontrolname='userName']"))).click().build().perform();
            Thread.sleep(15000);


            if (driver.findElement(By.cssSelector("div[class='text-danger ng-star-inserted']")).getText().contains("Şifre giriniz")) {
                System.out.println("(Şifre giriniz) uyarı yazısı göründü");
                System.out.println("successs");

            }

            else{
                System.out.println("görünmedi");
            }
        }


    @Test
    public void CheckWarningTitleSixDigit() throws InterruptedException {  // JIRA 6. ODEV( girilen şifre haneden az uyarı yazısı geliyor mu/hayır)

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

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }



}

