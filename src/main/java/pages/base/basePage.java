package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static constans.Constans.TimeoutVeribles.EXPLICT_WAIT;


public class basePage {
    public WebDriver driver;
    public basePage(WebDriver driver) {
        this.driver = driver;


    }
    // Метод для підставлення силкиа
    public void goToURL(String url){
        driver.get(url);

    }

    // очікування, щоб елемент був видемий
    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }


}
