package _06_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {

    //DROPDOWN DEYİNCE AKLİNA SELECT GELSİN

    /*
    amazon'a gidip
    dropdown'dan books secenegini secip
    Java aratalim
    ve arama sonuclarinin Java icerdigini test edelim
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test(){
        driver.get("http://www.amazon.com/");

        // dropdown'da bir option secmek icin 3 adim vardir
        // 1- dropdown'i locate edelim

        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));

        // 2- bir Select objesi olusturup
        // parametre olarak bir onceki adimda locate ettigimiz ddm'yu girelim

        Select select = new Select(dropDownMenu);

        // 3- Dromdown'da var olan option'lardan istedigimiz bir taneyi secelim

        select.selectByVisibleText("Books"); //text olan kısımlar ise |> butonuna basınca aşağıya doğru uzanan listededi isimlerdir en çok bu kullanılır
        //select.selectByIndex(5); // Index ise baştan aşağıya istediğimiz ürünü sayıp bularak yazarız
        //select.deselectByValue("search-alias=stripbooks-intl-ship"); //options tagında yer alan value kısmı kopyalanıp buraya yazılır
                                                                      // ama uzun olabilir çok tercih edilmez.

        // arama kutusuna Java yazdiralim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);

        // arama sonuclarinin Java icerdigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='1-16 of over 30,000 results for']")).isDisplayed());

    }

    @After
    public void tearDown(){
        driver.quit();
    }





}
