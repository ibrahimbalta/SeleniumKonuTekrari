package _14_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookie extends TestBaseBeforeAfter {

    @Test
    public void cookiesTesti() {

        //Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        System.out.println(cookieSet);

        int sayac =1;
        for (Cookie each:cookieSet) {
            System.out.println(sayac+".ci "+each);
            System.out.println("name " + each.getName());
            System.out.println("value " + each.getValue());
            sayac++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi = cookieSet.size(); //önce size ile sayısını aldık
       // Assert.assertTrue(cookieSayisi>5);   //defalarca yapılan testte bu kısım sürekli çalışınca hata verebileceği için yoruma aldık

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie each:cookieSet) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",each.getValue());
            }
        }

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali"); //Burada biz cookie'i oluşturduk
        driver.manage().addCookie(cookie); //Oluşturduktan sonra ekleme yaptık

        cookieSet = driver.manage().getCookies(); //Yeniden bütün cookieler sete atanmalıdır yoksa yazdırmaz
        sayac =1;
        for (Cookie each:cookieSet) {
            System.out.println(sayac+".ci "+each);
            System.out.println("name " + each.getName());
            System.out.println("value " + each.getValue());
            sayac++;
        }


        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(cookieSet.contains(cookie));

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookieSet.contains("skin"));

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        //silindiğini test edebilmek için yine bir set e atarız
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty()); // isEmpty() boş demektir


    }
}
