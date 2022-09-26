package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C07_HomeWork3 extends TestBase {

    @Test
    public void test01() {
       //Yeni bir class olusturalim: MouseActions3
       //1 https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
       //2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
       //mouse’u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
        WebElement accountListElementi= driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        actions.moveToElement(accountListElementi).perform();
       //3 “Create a list” butonuna basalim
        WebElement createListElementi= driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        actions.click(createListElementi).perform();
       //4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        String yourListYaziElementi=driver.findElement(By.xpath("//div[@role='heading']")).getText();
        Assert.assertTrue(yourListYaziElementi.equals("Your Lists"));
    }
}
