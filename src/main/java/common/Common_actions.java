package common;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

import static common.config.PLATFORM_AND_BROWSER;
import static constans.Constans.TimeoutVeribles.IMPLISIN_WAIT;

public class Common_actions {
    public static WebDriver createDriver(){
        WebDriver driver = null;
        switch (PLATFORM_AND_BROWSER){
            case "EdgeDriver":
                System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "ChromeDriver":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                Assertions.fail("INCORRECT BROWSER NAME" + PLATFORM_AND_BROWSER );

        }
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(IMPLISIN_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
