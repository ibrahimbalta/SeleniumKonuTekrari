package _13_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C02_ExplicitlyWait extends TestBaseBeforeAfter {

    @Test
    public void isEnabledTesti() {

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement enableHutusu =driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableHutusu.isEnabled()); //Burada etkin olmasığını false ile kontrol ettik

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));//Obje oluşturulur öncelikle
        /*Element locate edilebildiği için burada locate işlemini aynı satırda yapma zorunluluğu yoktur*/
        wait.until(ExpectedConditions.elementToBeClickable(enableHutusu));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]")).isDisplayed());

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(enableHutusu.isEnabled()); //Burada etkin olduğunu true ile kontrol ettik
    }
}
