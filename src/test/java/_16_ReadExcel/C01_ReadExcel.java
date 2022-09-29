package _16_ReadExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "C:\\Users\\Zeliha Öznük\\Desktop\\ZELİHA\\SeleniumKonuTekrari\\src\\resources\\ulkeler (2).xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis); //workbook objesiyle işleme fis objesi ile akışa
        // aldığımız dosyamızda bir excel dosyası create ettik

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1"); //Excel'de dosyamızda çalışmak istediğimiz sayfayı bu şekilde seçeriz.

        //12. Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3); //sayfa 1 deki 3. satırı bu şekilde seçeriz

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3);   //Satır seçimi yapıldıktan sonra hücre seçimi bu şekilde yapılır
        //(Satirdaki hucre indexi)
        System.out.println(cell);

        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin

        String expectedData = "Cezayir";
        String actualData = cell.toString();
        Assert.assertEquals(expectedData,actualData);
        Assert.assertEquals(expectedData,cell.getStringCellValue());




    }
}
 /*
        Ara-->dosyaYolu
        Windows Gezgini ile ac-->FileInputStream
        Excel i ac-->Workbook
        Sayfa1 e git-->Sheet
        Satiri bul-->Row
        Sutunu bul-->Cell
         */

        /*
        Kısayol hali :
        String actualData = workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();

         */

        /*
        Excelde index 0 dan başlar

         Excel icin daha once inceledigimiz Web Table yapisina
         benzer bir yapi vardir.

         ➢ Excel’de bir hucredeki bilgiye ulasmak icin
         dosya/sayfa/satir/sutun sirasiyla ilerlemeliyiz

         ➢ Excel ile ilgili otomasyonda web table’da oldugu gibi sutun
         yapisi yoktur, ihtiyac duyarsak kodla sutunu elde edebiliriz
         ancak bir dataya ulasmak icin sutun kullanamayiz

         Workbook excel dosyamiz

         Sheet Her açık excel sekmesi (Sheet1, Sheet2, etc)

         Row(satir) Java, yalnızca içeride veri varsa satırları sayar.

         Default olarak, Java perspektifinden satır sayısı 0'dır

         Cells (hucre) Java her satıra bakar ve yalnızca hücrede
         veri varsa hücre sayısını sayar.
         */
