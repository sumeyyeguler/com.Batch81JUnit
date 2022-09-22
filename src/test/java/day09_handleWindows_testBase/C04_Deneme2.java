package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Deneme2 {


// Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void Test01() {
        // Tests package’inda yeni bir class olusturun: WindowHandle2
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String sayfa1HashCode=driver.getWindowHandle();
        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expected1="The Internet";
        String actually1=driver.getTitle();
        System.out.println(actually1);
        Assert.assertEquals(actually1,expected1);
        // Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expected2="New Window";
        String actually2=driver.getTitle();
        Assert.assertNotEquals(actually2,expected2);
        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        //sayfa 1 e geri dönün
        driver.switchTo().window(sayfa1HashCode);



    }
}
