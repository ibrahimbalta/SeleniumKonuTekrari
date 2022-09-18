package _05_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    Amazon ana sayfaya gidin
    3 farklı test methodu oluşturarark aşağıdaki görevleri yapın
    1- Url'in amazon içerdiğini test edin
    2- title in facebook içermediğini test edin
    3- sol üst kosede amazon logosunun göründüğünü test edin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test1(){
        // 1- Url'in amazon içerdiğini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
    }

    @Test
    public void test2(){
        //2- title in facebook içermediğini test edin
        Assert.assertFalse(driver.getTitle().contains("facebook"));
    }

    @Test
    public void test3(){
        // 3- sol üst kosede amazon logosunun göründüğünü test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='/ref=nav_logo']")).isDisplayed());
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }


}
