package _18_GetScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilites.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenShotWE extends TestBaseBeforeAfter {

    @Test
    public void test1() throws IOException {

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Nutella aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        //Arama sonucunun resmini alalım
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu = aramaSonucu.getScreenshotAs(OutputType.FILE);
        // sadece webelementin resmini alacaksak TakeScreenShot class'ini kullanmama gerek yok
        // locate ettigimiz webelementi direk gecici bir file'a atip FileUtils ile kopyalayip
        // yolunu (path) belirtiriz
        FileUtils.copyFile(nutellaAramaSonucu,new File("target/ekranGoruntusuWE/WebESS.jpeg"));

        //tüm sayfa olunca loceter almaya gerek yoktur, kesit isteniyorsa loceter ihtiyac var

        /*
        // WebElement'in screenshot'ını alırken, tüm sayfanınkini alırken yaptığımız
        // TakeScreenShot class'ından obje üretme işlemini yapmıyoruz.
        // Bunun yerine locate'ini aldığımız WebElement üzerinden
        // getScreenshot method'unu çalıştırıyoruz
         */

    }
}
