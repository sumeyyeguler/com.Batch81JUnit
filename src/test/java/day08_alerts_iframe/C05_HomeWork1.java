package day08_alerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_HomeWork1 extends TestBase {

    @Test
    public void Test01() {
// Bir class olusturun: Alerts
//https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//1. butona tıklayın
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
// uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.switchTo().alert().accept();
//“You successfully clicked an alert” oldugunu test edin.
        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dismissAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //2. butona tıklayın
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        // uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        String expected = "succesfuly";
        String actual = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        // Bir metod olusturun: sendKeysAlert
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 3. butona tıklayın
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        // uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın
            driver.switchTo().alert().sendKeys("sumeyye");
            Thread.sleep(3000);
            driver.switchTo().alert().accept();
        //result mesajında isminizin görüntülendiğini doğrulayın.
        String expectedYazi="sumeyye";
        String actualYazi=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualYazi.contains(expectedYazi));
    }

}


