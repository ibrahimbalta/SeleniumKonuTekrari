package _19_JSExecutors;

import org.junit.Test;
import utilites.TestBaseBeforeAfter;

public class C03_JSExecutors extends TestBaseBeforeAfter {

    @Test
    public void test1() {

        //1- Yeni bir class olusturun : ScroolInto
        //2- hotelmycamp anasayfasina gidin
        driver.get("https://www.hotelmycamp.com/");

        //3- 2 farkli test method’u olusturarak actions clasi ve
        //Js Executor kullanarak asagidaki oda turlerinden
        //ust sira ortadaki odayi tiklayin
        //4- istediginiz oda inceleme sayfasi acildigini test
        //edin


    }

    @Test
    public void test2() {

    }
}
/**
 1.Adım: Actions class’ta bir object oluşturulur.
 Actions actions= new Actions(driver);

 ➢ 2. Adım: Üzerinde çalışmak istediğiniz WebElement
 öğesini bulunur.
 WebElement element = driver.findElement(By.id("ID"));

 ➢ 3.Adim : Ardından bu webelement üzerinde action
 gerçekleştirilir. Örneğin tıklamak için.
 actions.click(element).perform( );
 NOT : Action Class’ini her kullanmak istedigimizde yeniden obje olusturmamiz gerekmez.
 action objesi kullanilarak baslayan her komut, calismak icin perform( ) bekler.
 */

/*
1.Adim : JavascriptExecutor kullanmak icin ilk adim olarak driver’imizi JavascriptExecutor’a cast edelim
1-JavascriptExecutor jse=(JavascriptExecutor)driver;

2.Adim : Kullanacagimiz WebElement’I locate edelim
 2-WebElement xElement=driver.findElement(//Locate)

 3.Adim : Js driver ile executeScript method’unu calistiralim, icine parameter olarak ilgili script ve webelemnt’I yazalim
3-jse.executeScript("arguments[0].scrollIntoView(true);",xElement)

4.Adim : xElement elementine click yapmak icin
4-jse.executeScript("arguments[0].click();",xElement)
 */