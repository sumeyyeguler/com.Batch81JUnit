package testCaseA101;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class A101_Test {
    static WebDriver driver;
    static Actions actions;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions =new Actions(driver);

    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://a101.com.tr");
        driver.findElement(By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//*[@title='GİYİM & AKSESUAR'])[1]"))));
        actions.moveToElement(driver.findElement(By.xpath("(//*[@title='GİYİM & AKSESUAR'])[1]"))).perform();
        driver.findElement(By.xpath("//a[@href='/giyim-aksesuar/dizalti-corap/']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//h3[@class='name'])[1]")).getText().contains("Siyah"));
        driver.findElement(By.xpath("(//h3[@class='name'])[1]")).click();
        driver.findElement(By.xpath("//*[@class='add-to-basket button green block with-icon js-add-basket']")).click();
        driver.findElement(By.xpath("//*[@class='go-to-shop']")).click();
        driver.findElement(By.xpath("(//*[@title='Sepeti Onayla'])[2]")).click();
        driver.findElement(By.xpath("//*[@title='ÜYE OLMADAN DEVAM ET']")).click();
        Faker faker=new Faker();
        driver.findElement(By.xpath("//*[@name='user_email']")).click();
        actions.sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("(//*[@class='new-address js-new-address'])[1]")).click();
        actions.click(driver.findElement(By.xpath("(//input[@type='text'])[5]")))
                .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().lastName()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).perform();
        Select options=new Select(driver.findElement(By.xpath("//*[@class='js-cities']")));
        driver.findElement(By.xpath("//*[@class='js-cities']")).click();
        options.selectByIndex(new Random().nextInt(options.getOptions().size()-1)+1);
        Select options2=new Select(driver.findElement(By.xpath("//*[@class='js-township']")));
        driver.findElement(By.xpath("//*[@class='js-township']")).click();
        options2.selectByIndex(new Random().nextInt(options2.getOptions().size()-1)+1);
        Select options3=new Select(driver.findElement(By.xpath("//*[@class='js-district']")));
        driver.findElement(By.className("js-district")).click();
        Thread.sleep(1000);
        options3.selectByIndex(new Random().nextInt(options3.getOptions().size()-1)+1);
        actions.click(driver.findElement(By.xpath("//*[@class='js-address-textarea']"))).sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".js-checkout-cargo-item")).click();
        driver.findElement(By.xpath("//*[@class='button block green js-proceed-button']")).click();
        actions.doubleClick(driver.findElement(By.xpath("//*[@class='button block green js-proceed-button']"))).perform();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='hidden-xs'])[2]")).getText().contains("ÖDEME"));
        actions.click(driver.findElement(By.xpath("(//*[@type='text'])[2]"))).sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB).sendKeys(faker.number().digits(16)).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.DOWN).sendKeys(Keys.TAB).sendKeys(faker.number().digits(3)).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();




    }

}