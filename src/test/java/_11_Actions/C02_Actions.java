package _11_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01() throws InterruptedException {
        // amazon anasayfaya gidip
        driver.get("https://amazon.com");


        // account menusunden create a list linkine tiklayalim

        //todo 3 Adımda gerçekleştirilir:

        // ➢ 1.Adım: Actions class’ta bir object oluşturulur.
        Actions actions = new Actions(driver);

        // ➢ 2. Adım: Üzerinde çalışmak istediğiniz WebElement öğesini bulunur.
        WebElement acountLinki = driver.findElement(By.xpath("//*[text()='Account & Lists']"));

        // ➢ 3.Adim : Ardından bu webelement üzerinde action gerçekleştirilir.
        actions.moveToElement(acountLinki).perform(); //moveToElement() methodu ile mausu istediğimiz web elementin üzerinde tutar
        // moveToElement() su elemente yanas diyoruz

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }


}
//todo moveToElement() methodu ile mausu istediğimiz web elementin üzerinde tutar
// actions.doubleClick () : WebElement’e çift tıklama yapar
// .clickAndHold () : Uzerinde click yapili olarak bekler
// .dragAndDrop () : Bir noktadan diğerine sürükler ve bırakır
// .moveToElement () : Mouse’u istedigimiz WebElement’in uzerinde tutar
// .contextClick (): : Mouse ile istedigimiz WebElement’e sag tiklama yapar.
// actions.sendKeys() : Öğeye bir dizi anahtar gönderir
// .keyDown () : Klavyede tuşa basma işlemi gerçekleştirir
// .keyUp () : Klavyede tuşu serbest bırakma işlemi gerçekleştirir
/**
 Actions class klavye ve mause ile yapabildiğimiz tüm işlemleri
 selenyumla driver e yaptırabilmek için selenium un oluşturmuş olduğu bir classdır.

 ➢ TestNg’de Actions class’ini kullanarak mouse ve klavye
 ile yapabilecegimiz tum islevleri gerceklestirebiliriz.

 ➢ Actions Class birçok kullanışlı mouse ve klavye
 işlevine sahiptir.

 ➢ Çift tıklama (double click), sürükleme ve bırakma(drag
 and drop), mouse’u hareket ettirme (mouse actions)
 gibi karmaşık mouse eylemleri icin
 veya Keyboard ile yapabilecegimiz pageUp, pageDown,
 shift, arrowDown gibi islemleri Actions classindan object
 ureterek driver ile yapabiliriz.


 3 Adımda gerçekleştirilir:
 ➢ 1.Adım: Actions class’ta bir object oluşturulur.
 Actions actions= new Actions(driver);

 ➢ 2. Adım: Üzerinde çalışmak istediğiniz WebElement öğesini bulunur.
 WebElement element = driver.findElement(By.id("ID"));

 ➢ 3.Adim : Ardından bu webelement üzerinde action gerçekleştirilir.
 Örneğin tıklamak için.
 actions.click(element).perform( );

 todo NOT : Action Class’ini her kullanmak istedigimizde yeniden obje olusturmamiz gerekmez.
 action objesi’ni bir kere olusturunca, istediginiz kadar action. ile baslayan komut yazar ve calismasi
 icin sonuna perform( ) yazariz
 todo action objesi kullanilarak baslayan her komut, calismak icin perform( ) bekler.

 */
