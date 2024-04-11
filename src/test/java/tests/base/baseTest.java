package tests.base;
import static common.config.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import common.Common_actions;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.basePage;
import pages.mhp_main_page.MainPageMHP;


import java.io.File;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;
@Feature("Main Page")
@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
/**
 * ІНІЦІАЛІЗАЦІЯ ВСІХ ПЕЙДЖІВ, ЯКІ ЗАНХОДЯТЬСЯ В ПАПЦІ pages
 */
public class baseTest {
    protected WebDriver driver = Common_actions.createDriver();
    protected basePage basePage = new basePage(driver);
    protected MainPageMHP MainPageMHP = new MainPageMHP(driver);

    private static final Logger LOGGER = LoggerFactory.getLogger(baseTest.class);
    static {
        LOGGER.info("START TIME:" + LocalTime.now());
        // Очиста самих алюрів
        LOGGER.info("START CLEAR REPORTS dir: screenshots/reports/test");
        File allureResults = new File("allure-results");
        if (allureResults.isDirectory()){
            for (File item : Objects.requireNonNull(allureResults.listFiles()))
                item.delete();
        }
        // Очиста Скрінів
        if (CLEAR_REPORTS_DIR){
            File allureScreenshots = new File("screenshots/reports/tests");
            for (File item : Objects.requireNonNull(allureScreenshots.listFiles()))
                item.delete();
        }

    }
    // Очиста всіх кукі
    @AfterEach
    void  ClearCookiesAndLocalStorage(){
        if (CLEAR_COOLIES){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
    // Закриття чи не закриття браузера
@AfterAll
void  close(){
    if(!HOLD_BROWSER_OPEN){
        driver.close();

    }
}




}

