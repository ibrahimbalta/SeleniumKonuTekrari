package _11_Actions;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class C01_TestBaseFirstClass extends TestBaseBeforeAfter {

    //Burada extends yaparak birçok çalışmayı diğerlerinden alabilme amacıyla kullandık

    @Test
    public void test1(){
        driver.get("https://amazon.com");

    }

    /**
     ●TestBase, testlerden önce ve sonra tekrar tekrar
     kullandığımız kodları içermektedir.

     ●İçerisindeki metodları kullanabilmemiz icin extends
     yapıyoruz. Bu sayede test class’ımızda sadece test
     case’ler bulunmaktadır.

     ● Utilities package’da TestBase’i oluşturuyoruz.
     ○ setUp method
     ○ reports (Raporlar)
     ○ tearDown method

     ●TestBase class’i abstract yapabiliriz (Olmasada
     olabilir) , extends yaparak kullanabiliriz. Ve bu
     class’da object create edemeyiz.
     ● olusturdugumuz driver’in farkli package’lardan kullanabilmek icin PROTECTED yapariz

     */


}
