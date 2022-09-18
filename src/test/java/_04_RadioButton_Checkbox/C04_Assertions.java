package _04_RadioButton_Checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void test(){
        /**
        Eğer Test methodumuzda hiçbit test yoksa,test çalıştıktan sonra
        hiçbir problemle karşılaşmadığını raporlamak için "tests passed" yazısı çıkar.

        Eğer testleri if ile yaparsak
        test faıled olsa bile kodlar problemsiz çalıştığı için
        kod çalışması bittiğinde
        ekranın sol alt kısmında test passed yazacaktır
         */

        driver.get("https://www.amazon.com/");

        /*
        //URL'in https://www.facebook.com olduğunu test edin
        if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

         */

        String expectedUrl = "https://www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        //Assert.assertEquals(expectedUrl,actualUrl); //Burada test faıled olur çünkü url farklıdır ve eşit değildir
        /**
        Assert ile yaptığımız testlerde assertion faıled olursa java kodların çalışmasını bırakır ve
        Assert Class'ı bizi hata ile ilgili bilgilendirir
                                       org.junit.ComparisonFailure:
                                       Expected :https://www.facebook.com
                                       Actual   :https://www.amazon.com/
                                       <Click to see difference>
        Böylece hatanın ne olduğunu araştırmamıza gerek kalmadan JUnit bize raporlamış olacak.

         */
        Assert.assertNotEquals(expectedUrl,actualUrl); //Burada ise sonuç passed olur çünkü eşit değildir dedik

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }


}
