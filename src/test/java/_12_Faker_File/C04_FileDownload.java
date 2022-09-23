package _12_Faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {

        // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        // 2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        // 3. somefile.txt dosyasını indirelim
        WebElement somefileLinki=driver.findElement(By.xpath("//a[text()='some-file.txt']"));
        somefileLinki.click();
        Thread.sleep(5000);
        // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        // DOSYA DOWLOANDS'A indirilecektir, bize downloads'un dosya yolu lazim
        String farkliKisim=System.getProperty("user.home"); // herkes kendi bilgisayarinin ozel kismini cagiriyor
        String ortakKisim="\\Downloads\\some-file.txt"; // bu dosyayi hepimiz indirdik
        String arananDosyayolu = farkliKisim+ortakKisim;
        //geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyayolu)));
    }
}
