package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C07_HomeWork1 extends TestBase{
    @Test
    public void test01() {

    //1)Yeni bir class olusturalim: MouseActions1
    //2)https://the-internet.herokuapp.com/context_menu sitesine gidelim
    driver.get("https://the-internet.herokuapp.com/context_menu");
    //3) Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement cizgiElementi=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(cizgiElementi).perform();
    //4) Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actualYazi=driver.switchTo().alert().getText();
        String expectedYazi="You selected a context menu";
        Assert.assertEquals(expectedYazi,actualYazi);
    //5) Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
    //6) Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
    //7)Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        WebElement elemental= driver.findElement(By.xpath("//a[@target='_blank']"));
        Assert.assertTrue(elemental.getText().equals("Elemental Selenium"));
}}
