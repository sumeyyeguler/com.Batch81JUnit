package day08_alerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_HomeWork2 extends TestBase {

//Bir class olusturun: IframeTest

    @Test
    public void ıFrameTest() {
    //Bir metod olusturun: iframeTest
    // https://the-internet.herokuapp.com/iframe adresine gidin.
            driver.get("https://the-internet.herokuapp.com/iframe");
    //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isEnabled());
    //Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrameElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textKutusu=driver.findElement(By.id("tinymce"));
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dunya!");
        driver.switchTo().defaultContent();
    //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        WebElement elementSeleniumYazisi=driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(elementSeleniumYazisi.isDisplayed());
        System.out.println(elementSeleniumYazisi.getAccessibleName());

    }

}
