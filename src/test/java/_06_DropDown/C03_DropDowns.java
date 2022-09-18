package _06_DropDown;

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

import java.time.Duration;
import java.util.List;

public class C03_DropDowns {

    /*
    Bir class oluşturun: C3_DropDownAmazon
    ● https://www.amazon.com/ adresine gidin.
    - Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    oldugunu test edin
    -Test 2
    1. Kategori menusunden Books secenegini secin
    2. Arama kutusuna Java yazin ve aratin
    3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin
     */

    static WebDriver driver;

    static Select select;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test1() throws InterruptedException {
        /*
        - Test 1
        Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        oldugunu test edin
         */

        Thread.sleep(2000);

        // dropdown'da bir option secmek icin 3 adim vardir
        // 1- dropdown'i locate edelim
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        // 2- bir Select objesi olusturup
        // parametre olarak bir onceki adimda locate ettigimiz ddm'yu girelim

        select = new Select(ddm);

        //Bizden sayısını istediği için bir list'e atama yaparız

        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //olmadığı test edin

        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddmList.size());

        //Daha sonra kategori sayısını bulabilmek için  options u int değere atarız

        int actualOptionSayisi = ddmList.size();
        int expectedOptionSayisi = 45;

        Assert.assertNotEquals(expectedOptionSayisi,actualOptionSayisi);

    }

    @Test
    public void test2(){

        /*
        -Test 2
    1. Kategori menusunden Books secenegini secin
    2. Arama kutusuna Java yazin ve aratin
    3. Bulunan sonuc sayisini yazdirin
    4. Sonucun Java kelimesini icerdigini test edin
     */

        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        WebElement sonucSayisi = driver.findElement(By.xpath("//*[text()='1-48 of over 8,000 results for']"));
        System.out.println(sonucSayisi.getText());

        Assert.assertTrue(sonucSayisi.isDisplayed());

    }



}
