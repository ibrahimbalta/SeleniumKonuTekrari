package _11_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C04_Actions extends TestBaseBeforeAfter {

    @Test
    public void test() throws InterruptedException {

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragMe = driver.findElement(By.xpath("//*[text()='Drag me']"));
        Thread.sleep(3000);
        WebElement dropDown = driver.findElement(By.xpath("//div[@class='drop-box ui-droppable']"));
        actions.dragAndDrop(dragMe,dropDown).perform();//actions perform olmadan çalışmaz!!!!!

        //***dragAndDrop() DOSYAYI HEDEFE TASIR***

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Dropped!']")).isDisplayed());

    }


}
