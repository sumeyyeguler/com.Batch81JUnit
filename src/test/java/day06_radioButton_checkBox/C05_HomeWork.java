package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_HomeWork {

    WebDriver driver;
//  1. Bir class oluşturun : RadioButtonTest
//  2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
       // driver.close();
    }
//  - https://www.facebook.com adresine gidin
//              - Cookies’i kabul edin
    @Test
    public void test01(){
       // driver.get("https://www.facebook.com");


//  - “Create an Account” button’una basin
        driver.findElement(By.className("_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy")).click();
        //  - “radio buttons” elementlerini locate edin
//  - Secili degilse cinsiyet butonundan size uygun olani secin
}
}