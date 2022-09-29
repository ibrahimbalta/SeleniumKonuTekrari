package _16_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void readExcelTest1() throws IOException {

        // belirtilen satir no ve sutun no degerlerini parametre olarak alip


        // o cell'deki datayi konsola yazdirin


        int satir = 12;
        int sutun = 2;

        String dosyaYolu= "C:\\Users\\Zeliha Öznük\\Desktop\\ZELİHA\\SeleniumKonuTekrari\\src\\resources\\ulkeler (2).xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String actualData = workbook.getSheet("Sayfa1").getRow(satir-1).getCell(sutun-1).toString(); //index 0 dan basladığı için biz burada 1- ile yazdık
        //index 0'dan basladigi icin bizden istenen satira ulasabilmek icin bir eksigini aliriz
        //SatirNo ve SutunNo'dan sonra -1 yapmamizin sebebi index'in 0 dan baslamasi.

        System.out.println(actualData);

        // Sonucun konsolda yazanla ayni oldugunu dogrulayin
        String expectedData = "Baku";
        Assert.assertEquals(expectedData,actualData);

        /*
        Bu şekilde de yapılabilirdi:
        String filePath="src/recourses/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(filePath);//Olusturmus oldugumuz dozya yolu
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);
        String actualData = workbook.getSheet(sheet).getRow(row).getCell(cell).toString();
        System.out.println(actualData);
         */


        /*
        Method olarak da bu şekilde yapılır:

        public Cell yazdir(String sheet, int satir, int sutun) throws IOException {

        String patch = "src/recources/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(patch);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Cell data = workbook.getSheet(sheet).getRow(satir).getCell(sutun);

        return data;
         }
         */

    }

}
