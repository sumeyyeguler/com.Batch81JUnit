package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_AssertionsDeneme {

    //    1. Bir Class olusturalim YanlisEmailTesti
//    2. http://automationpractice.com/index.php sayfasina gidelim
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    //    3. Sign in butonuna basalim
    @Test
    public void Test01() {
        driver.findElement(By.xpath("//a[@class='login']")).click();

    }

    @Test
    public void Test02() {
//    4. Email kutusuna @isareti olmayan bir mail yazip enter’a
//    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        WebElement eMailKutusu = driver.findElement(By.xpath("//input[@id='email_create']"));
        eMailKutusu.sendKeys("sumeyyegmail.com"+ Keys.ENTER);
        WebElement invalidYazisi = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(invalidYazisi.isDisplayed());

    }
}