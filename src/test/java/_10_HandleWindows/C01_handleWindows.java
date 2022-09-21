package _10_HandleWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        //Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        Thread.sleep(2000);
        //Nutella olarak arama yapın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        /*
        CDwindow-A1CE1DB001F1C70098F7CEA8E679C681
        bu kod açılan sayfanın unique hash kodudur.
        Selenium sayfalar arası geçişte bu window handle değerini kullanır

        Eğer sayfalar arasında driver'imizi gezdiriyorsak ve herhangi bir sayfadan
        şu anda bulunduğumuz sayfaya geçmek istiyorsak
        driver.switchTo().window("CDwindow-A1CE1DB001F1C70098F7CEA8E679C681");
        bu sayfanın window handle değerini girerek bu sayfaya geçişi sağlayabiliriz.

         */

        // 3- ilk ürünün resmini tıklayarak farklı bir tab da(sayfada) açın
        WebElement ilkUrunResmi = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandığımızda driver otomatik olarak oluştulan
        new Tab a geçer
        Yeni tab da görevi gerçekleştirmek için adımları baştan yapmamız gerekir
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        // 4- Yeni tab da açılan ürünün tiitle i yazdırın
        WebElement urunTitleElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText());

        //Burada açılan sayfa Url'i
        System.out.println(driver.getCurrentUrl());

        //İlk sayfaya geçip Url'i yazdıralım
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());


    }
    /**
    1 ) Icinde oldugumuz sayfanin window handle degerini alma
                              driver.getWindowHandle();
    2 ) Pencereler arasında geçiş yapma(switch)
                             driver.switchTo().window(sayfa1HandleDegeri);
    3 ) Yeni tab olusturup geçiş yapma(switch)
                             driver.switchTo().newWindow(WindowType.TAB);
    4 ) Yeni window olusturup geçiş yapma(switch)
                              driver.switchTo().newWindow(WindowType.WINDOW);

     */




}
