package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_HomeWork2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

      // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
      // 2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
      // 3. Login alanine “username” yazdirin
        WebElement username=driver.findElement(By.xpath("//input[@id='user_login']"));
        username.sendKeys("username");
      // 4. Password alanine “password” yazdirin
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("password");
      // 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
      // 6. Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//*[.='Online Banking'] [1]")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
      // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("500");
      // 8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
      // 9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
      // 10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@id='alert_content']"));

        if (sonucYazisiElementi.isDisplayed()){
            System.out.println("test PASSED");
        } else {
            System.out.println("test FAILED");
        }
        driver.close();
    }
}
