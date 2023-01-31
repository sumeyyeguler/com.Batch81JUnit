package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase1 {
    //    1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");

    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }
    //3. Verify that home page is visible successfully
    @Test
    public void Test03(){

        String actualUrl=driver.getCurrentUrl();
        String expectedlUrl="https://automationexercise.com/";
        Assert.assertEquals(expectedlUrl,actualUrl);
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());
        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sumeyye");
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("sume@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).isDisplayed());
        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//label[@for='id_gender2']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        //date of birthday (DAY)
        WebElement ddmDay=driver.findElement(By.xpath("//select[@id='days']"));
        Select options1=new Select(ddmDay);
        ddmDay.findElement(By.xpath("//option[@value='24']")).click();
        //date of birthday (MOUNTH)
        WebElement ddmMount=driver.findElement(By.xpath("//select[@id='months']"));
        Select options2=new Select(ddmMount);
        ddmMount.findElement(By.xpath("(//option[@value='11'])[2]")).click();
        //date of birthday (YEAR)
        WebElement ddmYear=driver.findElement(By.xpath("//select[@id='years']"));
        Select options3=new Select(ddmYear);
        ddmYear.findElement(By.xpath("//option[@value='1994']")).click();
        //10. Select checkbox 'Sign up for our newsletter!'
      //WebElement checkBox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
      //checkBox1.click();
      // //11. Select checkbox 'Receive special offers from our partners!'
      // WebElement checkBox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
      // checkBox2.click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("sumeyye");
        driver.findElement(By.id("last_name")).sendKeys("guler");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("techproed");
        driver.findElement(By.id("address1")).sendKeys("orta mahalle");
        driver.findElement(By.id("address2")).sendKeys("yan caddesi");
        //country
        WebElement ddmCountry=driver.findElement(By.xpath("//select[@id='country']"));
        Select options4=new Select(ddmCountry);
        ddmCountry.findElement(By.xpath("//*[.='New Zealand']")).click();
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("kavunici sokak");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("istanbul");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("34250");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("09123456789");
        //13. Click 'Create Account button'
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.className("title text-center")).isDisplayed());
        //15. Click 'Continue' button
        driver.findElement(By.className("btn btn-primary")).click();

        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button



    }
}
