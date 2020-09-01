import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_XPath {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        //driver'i kullanilabilir hale getirdik
        WebDriverManager.chromedriver().setup();
        //driver nesnesi olusturduk
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("http://a.testaddressbook.com/");
        WebElement signInLinki = driver.findElement(By.linkText("Sign in"));
        signInLinki.click();

        Thread.sleep(2000);
        List<WebElement> tumLinkler = driver.findElements(By.tagName("a"));
        for (WebElement w: tumLinkler) {
            System.out.println(w.getText());
        }

        WebElement mailBox = driver.findElement(By.cssSelector("#session_email"));
        mailBox.sendKeys("ishksengul@hotmail.com.tr");
        WebElement passBox = driver.findElement(By.cssSelector(".form-control"));
        passBox.sendKeys("123456");
        WebElement signIn = driver.findElement(By.cssSelector(".btn.btn-primary"));
        signIn.click();

        // findElements By.xpath("//*") // o sayfadaki tüm webelementlerini bulur.
        /*List<WebElement> tumElementler = driver.findElements(By.xpath("//*"));
        for(WebElement w : tumElementler){
            System.out.println(w.getText());
        }*/

        WebElement tumYazilar = driver.findElement(By.tagName("body"));
        System.out.println(tumYazilar.getText());

    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }
}
