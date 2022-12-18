

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_HomeWork1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // Class Work Amazon Search Test
       // 1 https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");
       // 2 arama kutusunu locate edelim
        WebElement search =driver.findElement(By.xpath("//input[@type='text']"));
       // 3 “Samsung headphones” ile arama yapalim
        search.sendKeys("Samsung headphones"+ Keys.ENTER);
       // 4 Bulunan sonuc sayisini yazdiralim
        System.out.println("sonuc yazisi : "+driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText());
        // 5 Ilk urunu tiklayalim
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]")).click();
       // 6 Sayfadaki tum basliklari yazdiralim
        List<WebElement> basliklar=driver.findElements(By.tagName("h2"));
        System.out.println(basliklar.size());

        driver.close();


    }
}
