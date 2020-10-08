import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_HardAssert {
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
    public void test01(){
        driver.get("http://amazon.com");
        String title = driver.getTitle();
        boolean iceriyorMu = title.contains("Car");
        Assert.assertTrue(iceriyorMu); // True olup olmadigi kontrol ediliyor
    }

    @Test
    public void test02(){
        driver.get("http://amazon.com");
        String title = driver.getTitle();

        //sayfa title inda google kelimesinin gcip gecmedigini kontrol edelim
        boolean falseMu = title.contains("Google");
        Assert.assertFalse(falseMu); // icerisi false oldugu icin testimiz basarili
    }

    @Test
    public void test03(){
        driver.get("http://amazon.com");
        String title = driver.getTitle();

        //iki farkli degeri karsilastirmak icin kullanilir
        Assert.assertEquals("Amazon.com", title);

        //Expected :Amazon.com
        //Actual   :Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more
    }

}
