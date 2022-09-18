package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDownDeneme {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void Test01(){
        // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //dropdown menüyü locate et ve webelemente ata, select objesi oluştur ve parametreyi ddm seç, elemanlardan birini seç
        WebElement ddm1=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options=new Select(ddm1);
        options.selectByIndex(1);
        System.out.println(options.getFirstSelectedOption().getText());
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        options.selectByValue("2");
        System.out.println(options.getFirstSelectedOption().getText());
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        options.selectByVisibleText("Option 1");
        System.out.println(options.getFirstSelectedOption().getText());
        //	4.Tüm dropdown options'i yazdırın
        List<WebElement>optionsList=options.getOptions();
        for (WebElement each:optionsList
             ) {
            System.out.println(each.getText());
            //	5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
            //	degilse False yazdırın.
            if (optionsList.size()==4){
                System.out.println("true");
            }else System.out.println("false");
        }

    }








}
