package _13_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Homework extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {

        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverOverMeFirstButton = driver.findElement(By.xpath("//*[text()=\"Hover Over Me First!\"]"));
        actions.moveToElement(hoverOverMeFirstButton).perform(); //Üstüne gelin dediği için üzeine gelip bekledik

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("//*[text()='Link 1']")).click();

        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();


        //"Click and hold" kutusuna basili tutun
        WebElement clickHoldButton = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickHoldButton).perform();
        Thread.sleep(3000);

        //"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHoldButton.getText());

        //"Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.xpath("//*[@id='double-click']"));
        actions.doubleClick(doubleClick);

    }
}
