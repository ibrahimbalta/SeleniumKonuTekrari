package utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public abstract class TestBaseBeforeClassAfterClass {

    //abstract yapmamızın tek sebebi bu classdan obje üretilmesinin önüne geçmektir

    protected static WebDriver driver;
    protected static Actions actions;

    protected static Faker faker;



    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions = new Actions(driver);
        faker = new Faker();


    }

    @AfterClass
    public static void tearDown(){
        // driver.quit();
    }

}
