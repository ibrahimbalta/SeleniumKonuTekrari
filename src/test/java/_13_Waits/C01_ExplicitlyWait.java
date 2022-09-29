package _13_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBaseBeforeAfter {

    /*
    1. Bir class olusturun : WaitTest
    2. Iki tane metod olusturun : implicitWait() , explicitWait()
    Iki metod icin de asagidaki adimlari test edin.
    3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    4. Remove butonuna basin.
    5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    6. Add buttonuna basin
    7. It’s back mesajinin gorundugunu test edin
     */

    @Test
    public void implicitWaitTesti() {


        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick=\"swapCheckbox()\"]")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
        //Burada TestBase class'ı içindeki driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // kısmını kapatırsak test Faıled verir çünkü siteye gidip beklemesi gereken süreyi beklememiş olur

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"It's back!\"]")).isDisplayed());

    }

    @Test
    public void explicitWaitTesti() {

        //Iki metod icin de asagidaki adimlari test edin.

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        WebElement removeButton =driver.findElement(By.xpath("//*[@onclick=\"swapCheckbox()\"]"));
        removeButton.click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        /*
         ExplicitlyWait kısmında mesajın görüntülrndiğini kontrol etmek için yine
         TestBase class'ı içindeki driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         kısmını kapatarak işlem yapacağız
         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        /*
        WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//*[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi)); //Burada locate edilmiş elementi yazıyoruz
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        Yazının görünür olduğunu beklerken yazının locate'ini kullanmak sorun oluşturur
        çünkü henüz görünmeyen bir yazının locate edilmesi de mümkün olmayabilir
        (HTML kodları yazan developer farklı uygulamalar yapabilir)
        Bu durumda bekleme işlemi ve locate'i birlikte yapmalıyız.
         */
        WebElement itsGoneYaziElementi = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        //Burada ise locate etme işlemini aynı yerde gerçekleştiriyoruz.
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());



        //6. Add buttonuna basin
        WebElement addButton = driver.findElement(By.xpath("//*[text()='Add']"));
        addButton.click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYaziElementi = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackYaziElementi.isDisplayed());


    }
}
