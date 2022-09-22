package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Deneme1 {
// Yeni bir class olusturun: WindowHandle

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void Test01(){
        // Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        // Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle=driver.getWindowHandle();
        // Sayfa title’nin “Amazon” icerdigini test edin
        String arananKelime="Amazon";
        Assert.assertTrue(driver.getTitle().contains(arananKelime));
        // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        // Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String arananKelime1="TECHPROEDUCATION";
        Assert.assertFalse(driver.getTitle().contains(arananKelime1));
        // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        // Sayfa title’nin “Walmart” icerdigini test edin
        String arananKelime2="Walmart";
        Assert.assertTrue(driver.getTitle().contains(arananKelime2));
        // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandle);
        Assert.assertTrue(driver.getTitle().contains(arananKelime));


    }
    @After
    public void tearDown(){
      driver.quit();
    }

}
