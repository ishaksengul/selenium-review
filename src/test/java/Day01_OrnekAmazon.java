import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_OrnekAmazon {
    // 1. Amazon.com'a gideceğiz.
    // 2. Arama kutusuna "baby stroller"
    // 3. 2. Sıradaki ürüne tıklayacağız.
    // 4. Ürün sayfasına gittikten sonra, ürünün toplam fiyatını alacağız.
    // 5. Ürünün ortalama puanını (5 üzerinden) alacağız.
    @Test
    public void amazonTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("baby stroller" + Keys.ENTER);
        WebElement stroll = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        stroll.click();
        String fiyat = driver.findElement(By.id("price_inside_buybox")).getText();
        System.out.println("Urunun fiyati : "+fiyat);
        String puan = driver.findElement(By.id("averageCustomerReviews")).getText();
        System.out.println("Urunun puanlamasi : "+puan);
    }

    @Test
    public void test02(){
        // 1. Google.com'a gecis yapalim (navigate.to()) kullanalim
        // 2. arama kutusuna kemal ozden yazip arayalim
        // 3. karsimiza cikan sonuc sayisini ekrana yazdiralim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.google.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Kemal Ozden"+Keys.ENTER);
        System.out.println("Toplam sonuc : "+driver.findElement(By.id("result-stats")).getText());


    }
}
