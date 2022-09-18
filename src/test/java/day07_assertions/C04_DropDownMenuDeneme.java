package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenuDeneme {
    /* amazon'a gidip
      dropdown'dan books secenegini secip
      Java aratalim
      ve arama sonuclarinin Java icerdigini test edelim
    */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        // driver.close();
    }


    @Test
    public void Test02() {
        //dropdowndan bir option seçmek için 3 adım vardım
        //1- dropdown menüyü locate et ve bir WebElemente ata
        driver.get("https://www.amazon.com");
        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2-Select objesi oluştur ve paramaetre olarak dropDown ı locate ettiğimiz  WebElementini gönder.
        Select dropDown=new Select(dropDownMenu);
        //3- sayfadaki options elementlerinden birini seç
        dropDown.selectByVisibleText("Computers");  //bu kısım görünür isimdir.Yani >baby<,>auto< bizim gördüğümüz seçeneklerdir.
        //dropDown.selectByIndex(7); //index sıfırdan başlar, ilk index AllDepartment'dir
        //dropDown.selectByValue("search-alias=computers-intl-ship");
        WebElement aramaButonu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaButonu.sendKeys("Java"+ Keys.ENTER);
        String aramaSonucu=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        Assert.assertTrue(aramaSonucu.contains("Java"));


    }
}

