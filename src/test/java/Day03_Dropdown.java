import com.sun.tools.internal.ws.processor.modeler.annotation.WebServiceAp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Day03_Dropdown {

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
    public void DropDown01() throws InterruptedException {
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        //gecerli olan option(secimi) alabiliriz
        select.getFirstSelectedOption();

        Thread.sleep(1000);
        //biz farkli bir kategori secmek istersek 3 yolumuz var
        //1. secenek
        select.selectByVisibleText("Baby"); // secenegin text'ini kukullanarak secim yapmamizi saglar
        Thread.sleep(1000);
        select.selectByIndex(5); // index ile seci yapmamizi sagliyor
        Thread.sleep(1000);
        select.selectByValue("search-alias=computers-intl-ship");// option'in value attribute kullanarak secim yapmamizi saglar

        List<WebElement> allOptions = select.getOptions(); //dropDown icindeki tum secenekleri almak icin
        for(WebElement w:allOptions){
            System.out.println(w.getText());
        }
        System.out.println("toplam categori sayisi : " +allOptions.size());

        WebElement secili = select.getFirstSelectedOption();
        System.out.println("secili olan option : " +secili.getText());

    }

}
