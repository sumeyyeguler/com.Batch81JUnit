package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_AssertionsDeneme {
    static WebDriver driver;
       /*
    amazon ana sayfaya gidin
    3 farkli test method'u olusturarak asagidaki gorevleri yapin
    1- Url'in amazon icerdigini test edin
    2- title'in facebook icermedigini test edin
    3- sol ust kosede amazon logosunun gorundugunu test edin
     */

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void tearDown(){
       // driver.close();
    }

    @Test
    public void test01(){
       // Url'in amazon icerdigini test edin

        String arananKelime="amazon";
        String url=driver.getCurrentUrl();
        Assert.assertTrue(url.contains(arananKelime));


    }
    @Test
    public void test02(){
    //title'in facebook icermedigini test edin
        String istenmeyenKelime="facebook";
        String tittle=driver.getTitle();
        Assert.assertFalse(tittle.contains(istenmeyenKelime));//içermesin,olumsuz bir durum varsa false

    }
    @Test
    public void test03(){
        //sol ust kosede amazon logosunun gorundugunu test edin
        WebElement logo=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
