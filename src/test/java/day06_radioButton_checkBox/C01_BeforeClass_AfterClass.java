package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {
    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static methodlar icin calisir
    methodları static yaptıysak mecburen class leveldaki driver objesini de static yapmalıyız
    beforeclass ve afterclassta bir driver ile tek seferde iş çözülecektir (her class için bir defa çalışacaktır)
    eğer test case de ayrı ayrı açmak gerekirse before/after kullanılır.(her method için ayrı ayrı çalışacaktır)
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // Before method call
        driver.get("https://www.amazon.com");
        // After method call
    }

    @Test
    public void test02() {
        driver.get("https://www.techproeducation.com");
    }

    @Test
    public void test03() {
        driver.get("https://www.facebook.com");
    }

}