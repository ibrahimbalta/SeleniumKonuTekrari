package _11_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test() throws InterruptedException {

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim

        //➢ 1.Adım: Actions class’ta bir object oluşturulur.
        Actions actions = new Actions(driver);
        // ➢ 2. Adım: Üzerinde çalışmak istediğiniz WebElement öğesini bulunur.
        WebElement popUp = driver.findElement(By.id("hot-spot"));
        // ➢ 3.Adim : Ardından bu webelement üzerinde action gerçekleştirilir.
        actions.contextClick(popUp).perform(); //perform yapmadan çalışmaz

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedYazi = "You selected a context menu";
        String actualYazi = driver.switchTo().alert().getText(); //Burada öncelikle yapmış olduğumuz işlen driver'i swich'e geçirmektir
                                                                 //Eğer bu işlemi yapmazsak çıkan ekranda inceleme yapamadığımız
                                                                 // kısımadaki bölüm üzerinde çalışma yapamayız.
        Assert.assertEquals(expectedYazi,actualYazi);


        //5- Tamam diyerek alert’i kapatalim
        //Tamam diyebilmek için önce driver.switchTo().alert(); ile alerte geçmemiz gerekiyor bunun için
        Thread.sleep(3000);
        driver.switchTo().alert().accept();//yukarıdaki kısma tamam demek için bu şekilde yazılmalıdır

        Thread.sleep(3000);

        //6- Elemental Selenium linkine tiklayalim

        //Erol H.
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String> windowlist = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));


        /*  todo Ahmet H.
        String ilkSayfaWHDegeri = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click(); //todo BURADA YENİ SAYFAYA GİDECEGİ İCİN YUKARİDA ESKİ SAYFANIN HANDLE DEGERİNİ ALMALİYİM

        Set<String> handleSeti=driver.getWindowHandles(); // 2. sayfanında handle degerini bulalim
        String ikinciSayfaWHDegeri="";
        System.out.println(handleSeti);
        for (String each: handleSeti
        ) {
            if (!each.equals(ikinciSayfaWHDegeri)){
                ikinciSayfaWHDegeri=each;
            }
        }


         */

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        // Erol H.
        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());

        /*todo Ahmet H.
         driver.switchTo().window(ikinciSayfaWHDegeri); // burada 2.sayfanin handle degerini kullandik ve driver'imiz 2. sayfaya gecmis oldu
        WebElement yaziElementi=driver.findElement(By.tagName("h1"));
        String expectedYazi1 ="Elemental Selenium";
        String actualYazi1=yaziElementi.getText();
        Assert.assertEquals(expectedYazi1,actualYazi1);
         */

        driver.quit();
    }

}

//todo driver.switchTo().alert.accept() *Uyarida OK tiklar
// driver.switchTo().alert.dismiss() *Uyarida Cancel tiklar
// driver.switchTo().alert.getText() *Uyari mesajini getirir
// driver.switchTo().alert.sendKeys("Text) *Uyariya texti gonderir
