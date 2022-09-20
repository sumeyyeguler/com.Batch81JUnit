package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void readExcelTesti() throws IOException {

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        // sayfa 2'ye gidip
        // satir sayisinin , kullanilan satir sayisinin ise 12 oldugunu test edin

        int sonSatirIndex=workbook
                .getSheet("Sayfa2")
                .getLastRowNum();
        int expectedSatirSayisi=24;
        Assert.assertEquals(expectedSatirSayisi,sonSatirIndex+1);


        int kullanilanSatirSayisi=workbook
                .getSheet("Sayfa2")
                .getPhysicalNumberOfRows();

        int expectedKullanilanSatirsayisi=12;
        Assert.assertEquals(expectedKullanilanSatirsayisi,kullanilanSatirSayisi);

    }
}
