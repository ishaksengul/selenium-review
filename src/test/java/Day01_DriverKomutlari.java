import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Day01_DriverKomutlari {
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // driver'i tam ekran yaptik
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // elemenetlerin yuklemesini 5 sn bekle
        driver.get("http://www.google.com");

        driver.navigate().to("http://amazon.com");
        driver.navigate().back(); // bir oceki sayfaya geri doner.
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit(); // driver'i kapatmak icin kullanilir
        driver.close(); // acik olan sekmeyi kapatmak icin kullanilir
    }
}
