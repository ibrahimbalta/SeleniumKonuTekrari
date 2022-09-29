package _16_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void readExcelTest1() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        String dosyaYolu= "C:\\Users\\Zeliha Öznük\\Desktop\\ZELİHA\\SeleniumKonuTekrari\\src\\resources\\ulkeler (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //-Turkce baskentler sutununu yazdiralim
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum(); //İşlem görmüş son satırı index olarak verir
        System.out.println("Satir sayisi :"+sonSatir);
        //getLastRowNum() methodu bize excel sayfasındaki tüm satır numarasını verir

        String turkceBaskentler = "";
        for (int i = 0; i <= sonSatir; i++) {
            turkceBaskentler = workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);
        }
        //Yukarıda for döngüsünde yapılan işlem sonSatir dan kucuk veya eşit olarak yazılır ve bir döngüye alınır
        //Daha sonra turkceBaskentler(hiçlik olarak) = workbook[excel].getSheet(Sayfa başlığı).getRow(Hangi satır).getCell(Hangi sutun).toString();
                                                                                                     // -->Stringe atandığı için toString() yapıldı.


        /**
        Lambda ile:

        List<String> list=new ArrayList<>();
        for (int i = 0; i <=sonsatir ; i++) {
            list.add(workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        }
        list.forEach(t-> System.out.println(t));
         */




        /*
        Ara-->dosyaYolu
        Windows Gezgini ile ac-->FileInputStream
        Excel i ac-->Workbook
        Sayfa1 e git-->Sheet
        Satiri bul-->Row
        Sutunu bul-->Cell
         */


        /*
Exceldeki bir dosyaya ve dosyadaki bir bölüme ulaşmak istediğimizde
uygulayacağımız aşamalar :
Ara-->dosyaYolu      --> String dosyaYolu="src/resources/ulkeler.xlsx";
Windows Gezgini ile ac- ->FileInputStream    --> FileInputStream fis = new FileInputStream(dosyaYolu);
Excel i ac              -->Workbook        --> Workbook workbook = WorkbookFactory.create(fis)
workbook olusturduktan sonra :
String actualData = workbook.
                getSheet("Sayfa1")
                .getRow(3)
                .getCell(3)
                .toString();
Sayfa1 e git-->Sheet    --> getSheet()
Satiri bul-->Row       --> getRow()
Sutunu bul-->Cell     --> getCell()
Secilen bolumu getir  --> toString()
         */

    }


}
