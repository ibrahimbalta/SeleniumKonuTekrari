package _03_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Nutella {
    public static void main(String[] args) {

        /*
        1-C01_TekrarTesti isimli bir class olusturun
        2- https://www.google.com/ adresine gidin
        3- cookies uyarisini kabul ederek kapatin
        4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        5- Arama cubuguna “Nutella” yazip aratin
        6-Bulunan sonuc sayisini yazdirin
        7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        8-Sayfayi kapatin

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.google.com/");

        String baslik ="Google";
        if (driver.getTitle().contains(baslik)){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nutella", Keys.ENTER);


        //Sonuc sayısı istendiği zaman bunu bir List e atayıp öyle çözmeliyiz
        List<WebElement> aramaSonucu = driver.findElements(By.xpath("//*[@id='result-stats']"));
        String sonucSayisi = aramaSonucu.get(0).getText();
        System.out.println("sonucSayisi = " + sonucSayisi);


        driver.close();


    }
}
