package _13_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C05_Homework extends TestBaseBeforeAfter {

    @Test
    public void test3() {

        /*
        Ödev 3

1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a  kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
5."username" ve  "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
8.Ok diyerek Popup'i kapatin
Ilk sayfaya geri donun
Ilk sayfaya donuldugunu test edin
   */
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a  kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement loginPortal = driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));

        //3."Login Portal" a tiklayin
        loginPortal.click();

        //4.Diger window'a gecin
        List<String> windowHandle = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandle.get(1));

        //5."username" ve  "password" kutularina deger yazdirin
        //username
        WebElement username = driver.findElement(By.xpath("//*[@placeholder='Username']"));
        actions.clickAndHold();
        username.sendKeys(faker.name().username());
        //password
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        actions.clickAndHold();
        password.sendKeys(faker.internet().password());

        //6."login" butonuna basin
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String axpectedPopup ="validation failed";
        String actualPopup = driver.switchTo().alert().getText();
        Assert.assertEquals(actualPopup,axpectedPopup);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //Ilk sayfaya geri donun
        driver.switchTo().window(windowHandle.get(0));

        //Ilk sayfaya donuldugunu test edin
        Assert.assertTrue(loginPortal.isDisplayed());

        driver.quit();
    }

}
