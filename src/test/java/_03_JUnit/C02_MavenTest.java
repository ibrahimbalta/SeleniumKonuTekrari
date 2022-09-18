package _03_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        1. http://zero.webappsecurity.com sayfasina gidin
        2. Signin buttonuna tiklayin
        3. Login alanine “username” yazdirin
        4. Password alanine “password” yazdirin
        5. Sign in buttonuna tiklayin
        6. Pay Bills sayfasina gidin(Önce online banking kısmına tıkla)
        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        8. tarih kismina “2020-09-10” yazdirin
        9. Pay buttonuna tiklayin
        10. “The payment was successfully submitted.” mesajinin ciktigini control edin

         */

        driver.get("http://zero.webappsecurity.com");

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");

        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        driver.navigate().back(); //Burada back yapmamızın sebebi hata almamak

        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();

        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("150");

        driver.findElement(By.xpath("//input[@name='date']")).sendKeys("2020-09-10");

        driver.findElement(By.id("pay_saved_payees")).click();

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        if (sonucYazisiElementi.isDisplayed()){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        driver.close();
    }

}
