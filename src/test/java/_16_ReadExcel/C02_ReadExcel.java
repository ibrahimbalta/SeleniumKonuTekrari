package _16_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void readExcelTest1() throws IOException {

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "C:\\Users\\Zeliha Öznük\\Desktop\\ZELİHA\\SeleniumKonuTekrari\\src\\resources\\ulkeler (2).xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu); //oluşturmuş olduğumuz dosyayı sistemde işleme alır.

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis); //workbook objesiyle işleme fis objesi ile akışa
        // aldığımız dosyamızda bir excel dosyası create ettik

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        //12. Row objesi olusturun sheet.getRow(index)
        //13. Cell objesi olusturun row.getCell(index)

        //Bir önceki classı'ın Kısayol'u
        String actualData = workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();
        System.out.println(actualData);
    }

}
