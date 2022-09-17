package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfter {
    WebDriver driver;//sıralamayla ilgili problem olduğu için burada tanımladık before da atama yaptık.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        //before method call
        driver.get("https://www.amazon.com");
        //after method call
    }
    @Test
    public void test02(){
        driver.get("https://www.facebook.com");
    }
    @Test
    public void test03(){
        driver.get("https://www.youtube.com");
    }
}
