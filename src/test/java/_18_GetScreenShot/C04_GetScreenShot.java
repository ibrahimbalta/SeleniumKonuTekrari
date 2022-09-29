package _18_GetScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilites.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBaseBeforeAfter {

    @Test
    public void test1() throws IOException {

        //Amazon sayfasına gidelim tüm sayfanın resmini alalım
        driver.get("https://amazon.com");
       /*
        Bir web sayfanin resmini alabilmek icin TakesScreenshot class'indan obje olusturup
        gecici bir File class'indan degiskene TakesScreenShot'tan olusturdugum obje'den
        tss.getScreenshotAs method'unu kullanarak gecici bir file olustururuz
       */

        TakesScreenshot ts = (TakesScreenshot) driver;

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(formater);
        System.out.println(date);
        System.out.println(tarih);


        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/allPage.jpeg"));


        /*
        Uzun Hali:

        driver.get("https://www.amazon.com");
        TakesScreenshot ts=(TakesScreenshot) driver;
        File TumResim=new File("target/ekranGoruntusu/allPage.jpeg");
        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,TumResim);
         */



    }


    @Test
    public void test2() throws IOException {

        //Amazon sayfasına gidelim tüm sayfanın resmini alalım
        driver.get("https://www.hepsiburada.com/");
       /*
        Bir web sayfanin resmini alabilmek icin TakesScreenshot class'indan obje olusturup
        gecici bir File class'indan degiskene TakesScreenShot'tan olusturdugum obje'den
        tss.getScreenshotAs method'unu kullanarak gecici bir file olustururuz
       */

        TakesScreenshot ts = (TakesScreenshot) driver;

        /*
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(formater);

         */
        System.out.println(date);
        System.out.println(tarih);


        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/allPage"+tarih+".jpeg"));

        //resmi resmin uzerine degil de yeni bir resim olarak alabilmek icin image ismine tarih ekleyip atadik
        //tarih in normal formati dosya isimlendirmeye uygun olmadigi icin tarih yazim formati ile oynayip uygun hale getirdik
        //sonra bu sekil bize her zaman lazim olabilir diye TestDataBase imize attik


    }


}

/*
Get Screenshot / Tum Sayfa

Selenium 3 ile tum sayfanin fotografini alabiliyorduk, Selenium 4 ile gelen guzel ozelliklerden bir tanesi de
istedigimiz WebElement’in fotografini almamiza imkan tanimasi

1.Adim : Bir TakeScreenhot objesi olusturup driver’imizi TakeScreenhot’a cast yapalim
TakesScreenshot ts = (TakesScreenshot) driver;

2.Adim : kaydettigimiz ekran goruntusunu projede istedigimiz yere kaydedebilmek icin path ile yeni bir File olusturalim
File tumSayfaResim=new File ("target/ekranGoruntuleri/"+tarih+".jpeg")

3.Adim : Takescreenshot objesini kullanarak getScreenshotAs( ) methodunu calistiralim ve gelen resmi gecici bir file’a assign edelim
File geciciDosya=ts.getScreenshotAs(OutputType.FILE)

4.Adim : Kaydettigimiz goruntuyu, saklamak istedigimiz dosyaya kopyalayalim
FileUtils.copyFile(geciciDosya,tumSayfaResim)

 */
