import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_isDisplayed {

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
    public void isDisplayed(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement baslik = driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
        boolean gorunuyorMu = baslik.isDisplayed();
        System.out.println("baslik gorunuyor mu? : " +gorunuyorMu);
    }

    @Test
    public void isSelected(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement secimElementi = driver.findElement(By.xpath("//input[@type='checkbox']"));
        System.out.println("checkBox secili mi? 1: "+secimElementi.isSelected());
        secimElementi.click();
        System.out.println("checkBox secili mi? 2: "+secimElementi.isSelected());
    }

    @Test
    public void isEabled() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableTextBox = driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("textBox aktif mi? 1: "+enableTextBox.isEnabled());
        WebElement enableButton = driver.findElement(By.xpath("//*[.='Enable']"));
        enableButton.click();
        Thread.sleep(5000);
        System.out.println("textBox aktif mi? 2: "+enableTextBox.isEnabled());


    }
}
