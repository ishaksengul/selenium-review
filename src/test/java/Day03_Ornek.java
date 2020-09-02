import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day03_Ornek {
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
    // 1. DropDown'da Books sec
    // 2. Arama kutusuna JAVA yaz
    // 3. Toplam sonuc sayisini ekrana yaz
    // 4. ilk urune tikla
    // 5. Back to results linki varsa true yoksa false donsun

    @Test
    public void amazonDropDownTest(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByIndex(5);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("JAVA"+ Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("Toplam cikan sonuc: "+result.getText());
        WebElement First = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        First.click();
        WebElement bactToResult = driver.findElement(By.id("breadcrumb-back-link"));
        Assert.assertTrue(bactToResult.isDisplayed());


    }
}
