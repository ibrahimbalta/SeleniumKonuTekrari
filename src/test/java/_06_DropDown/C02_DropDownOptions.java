package _06_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions {

     /*
     amazon'a gidip
     dropdown menuden  books'u secelim
     sectigimiz option'i yazdiralim

     dropdown'daki opsiyonlarin toplam sayisinin
     28 oldugunu test edin
     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");

        // dropdown'da bir option secmek icin 3 adim vardir
        // 1- dropdown'i locate edelim

        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        // 2- bir Select objesi olusturup
        // parametre olarak bir onceki adimda locate ettigimiz ddm'yu girelim

        Select select = new Select(ddm);

        // 3- Dromdown'da var olan option'lardan istedigimiz bir taneyi secelim
        select.selectByVisibleText("Books");

        // bir dropdown ile calisirken son secilen option'a ulasmak isterseniz
        // select.getFirstSelectedOption() method'unu kullanmalisiniz
        // bu method bize WebElement dondurur
        // uzerindeki yaziyi yazdirmak icin getText() unutulmamalidir

        System.out.println(select.getFirstSelectedOption().getText()); //seçilen opsiyonu görerek getText() ile yazdırırız

        // dropdown'daki opsiyonlarin toplam sayisinin
        //28 oldugunu test edin

        List<WebElement> optionList = select.getOptions();

        //getOptions() web elementlerden oluşan bir liste döndürür
        //fakat bununla bir işlem yapmak istiyorsal bir List oluşturmak zorundayız

        int actualOptionSayisi = optionList.size(); // olan    //size()= o listenin eleman sayısıdır.
        int expectedOptionSayisi = 28; // beklenen

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

    }

    @After
    public void tearDown(){
        driver.quit();
    }







}
