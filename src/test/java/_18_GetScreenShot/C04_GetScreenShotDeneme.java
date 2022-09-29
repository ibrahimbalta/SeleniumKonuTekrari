package _18_GetScreenShot;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilites.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShotDeneme extends TestBaseBeforeAfter {

    @Test
    public void test1() throws IOException {

        //Amazon sayfasına gidelim tüm sayfanın resmini alalım
        driver.get("https://amazon.com");
       /*
        Bir web sayfanin resmini alabilmek icin TakesScreenshot class'indan obje olusturup
        gecici bir File class'indan degiskene TakesScreenShot'tan olusturdugum obje'den
        tss.getScreenshotAs method'unu kullanarak gecici bir file olustururuz
       */

        Faker faker = new Faker();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);

        //FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/allPage.jpeg"));
        //FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/"+faker.name().name()+"allPage.jpeg"));
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/"+driver.getTitle()+"AllPage.jpeg"));


    }


}
