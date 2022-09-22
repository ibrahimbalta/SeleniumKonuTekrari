package _11_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C06_KeyboardActions extends TestBaseBeforeAfter {

    @Test
    public void test01() throws InterruptedException {
        // facebook anasayfaya gidip
        driver.get("https:///facebook.com");

        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        // isim kutusunu locate edip,
        WebElement isimKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));

        // geriye kalan alanlari TAB ile dolasarak formu doldurun
        Actions actions = new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys("Taha")
                .sendKeys(Keys.TAB)
                .sendKeys("Ustaoglu")
                .sendKeys(Keys.TAB)
                .sendKeys("taha1@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("taha1@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("123456")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("07")
                .sendKeys(Keys.TAB)
                .sendKeys("Eyl")
                .sendKeys(Keys.TAB)
                .sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN) //ASAGİ OKLA ERKEK SECİMİ YAPABİLDİK
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();




    }
}
