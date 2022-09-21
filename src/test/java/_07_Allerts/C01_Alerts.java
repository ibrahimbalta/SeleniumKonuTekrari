package _07_Allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {

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
        //driver.quit();
    }


    @Test
   public void test(){

        /**
        Herhangi bir web sitesine gidince veya
        bir web sitesinde herhangi bir işlem yaptığımızda ortaya çıkan uyarılara allerts diyoruz

        Eğer bir alert inspect yapılabiliyorsa o alert otomasyon ile kullanılabilir
        bu tür alertlere html alert denir ve bunlar için ekstra bir işlem yapmaya gerek yoktur
        tüm webelementler gibi locate edip istediğimiz işlemleri yapabiliriz
        driver.get("https://www.facebook.com"); da çıkan alert vb. gibi

        Ancak web uygulamalarında HTML alert yanında java script alert de bulunabilir
        java script alertler locate edilemezler
        Seleniumda JS alert'ler için özel bir yöntem geliştirilmiştir.

         //accept( ) => Bir uyarıda(alert) OK'ı tıklamakla aynı.
         //                 driver.switchTo( ).alert( ).accept( );

         //● dismiss() => Bir uyarıda(alert) Cancel'ı tıklamakla aynı.
         //                 driver.switchTo( ).alert( ).dismiss( );

         //● getText() => Uyarıdaki(alert) mesajı almak için.
         //                 driver.switchTo( ).alert( ).getText( );

         //● sendKeys(“Text”) => Uyarı(alert) text kutusuna text göndermek için
         //                 driver.switchTo( ).alert( ).sendKeys("Text")

         //switchTo() ---> değiştir ya da geçiş yap demektir

         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Çıkan ilk butona basalım
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //Çıkan ekranda işlem yani locate yapabilmenin tek yolu ok tuşuna tıklamaktır bunun ise kodlarla şu şekilde yaparız
        driver.switchTo().alert().accept();

        //Daha sonra "You successfully clicked an alert" yazısının çıktığını kontrol edelim

        //1. yol:Burada gözümüzle kontrol ettiğimiz için direkt true yaptım
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']")).isDisplayed());

        //2. yol: Burada ise istenilen yazının  bu olduğunu test et dediğimiz için ise String ve WebElement atamasını yaptık.
        String expectedResuld = "You successfully clicked an alert";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));
        String actualResultYazisi = sonucYaziElementi.getText();
        Assert.assertEquals(expectedResuld,actualResultYazisi);



    }


}
