package _11_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_KeyboardAvtions extends TestBaseBeforeAfter {

    @Test
    public void test(){

        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://amazon.com");

        //3- Arama kutusuna actions method’larine kullanarak
        //nutella ve Enter’a basarak arama yaptirin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        // once arama kutusuna click yapip
        // sonra harh harf Nutella yazisini yazdiralim
        // sonra da ENTER tuwsuna basalim

        Actions actions = new Actions(driver);
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT) // BUYUK HARF ILE "N" YAZDİK
                .sendKeys("n")
                .keyUp(Keys.SHIFT) // BUYUK HARFTEN ELİMİZİ CEKTİK KUCUGE DONDU
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER)
                .perform();

        // keyDown() hangi tusunu girmek istiyorsam icine yaziyorum
        // keyUp() tıkladigim tustan elimi kaldiriyorum
        // SHIFT klavyede bu tusa basili yazinCa buyuk harf yaziyor bu sebeple bunu girdik


        //4- aramanin gerceklestigini test edin
        WebElement aramaSonucu=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(aramaSonucu.isDisplayed());

    }

}

//➢ Action Class’indan kullanacagimiz method’lar ile
//klavyedeki tuslari kontrol edebiliriz.
//➢ Bunun icin 3 method kullaniriz.
//■ sendKeys ( ): Öğeye bir dizi anahtar gönderir
//■ keyDown ( ): Klavyede tuşa basma işlemi gerçekleştirir
//■ keyUp ( ): Klavyede tuşu serbest bırakma işlemi gerçekleştirir
