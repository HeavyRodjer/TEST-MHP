package pages.mhp_main_page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.basePage;

public class MainPageMHP extends basePage {
    public MainPageMHP(WebDriver driver) {
        super(driver);
    }
public final By main_panel = By.xpath("(//a[text()='Можливості'])[1]");
    public MainPageMHP click(){
        WebElement test = driver.findElement(main_panel);
        String test3 = test.getAttribute("innerHTML");
        Assert.assertEquals(test3,"Можливості");
        test.click();
        return null;
    }
    public final By check_text = By.xpath("//a[text()= 'Лабораторію сенсорного аналізу']");
    public MainPageMHP click_list(){
        WebElement test = driver.findElement(check_text);
        String test3 = test.getAttribute("innerHTML");
        Assert.assertEquals(test3,"Лабораторію сенсорного аналізу");
        test.click();

        return null;
    }
    public final By lab = By.xpath("(//a[text()= 'Професійне програмне забезпечення'])[2]");
    public final By lab_menu = By.xpath("//div[@class= 'page-title page-title--parent-nav']");
    public MainPageMHP click_product(){
        WebElement test = driver.findElement(lab);
        String test3 = test.getAttribute("innerHTML");
        Assert.assertEquals(test3,"Професійне програмне забезпечення");
        test.click();
        WebElement test_lab_menu = driver.findElement(lab_menu);
        String test_lab = test_lab_menu.getAttribute("innerText");
        Assert.assertEquals(test_lab,"ПРОФЕСІЙНЕ ПРОГРАМНЕ ЗАБЕЗПЕЧЕННЯ");

        return null;
    }
//    public final By text = By.xpath("//div[@class='jsx-813557553 interchange-slides__title']");
//    public MainPageMHP check_text(){
//        WebElement test = driver.findElement(text);
//        String test3 = test.getAttribute("innerText");
//        Assert.assertEquals(test3,"Асортимент ТМ «Бащинський» налічує понад 250 продуктів");
//        return null;
//    }

}
