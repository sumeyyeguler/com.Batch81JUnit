package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C07_HomeWork2 extends TestBase {
    @Test
    public void test01() {
       //Yeni bir class olusturalim: MouseActions2
       //1 https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
       //2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement dragMeElementi= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereElementi= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMeElementi,dropHereElementi).perform();

       //3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    }
}
