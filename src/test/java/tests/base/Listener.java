package tests.base;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

//import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Listener implements TestWatcher {
    // МЕТОД ДЛЯ ТОГО, ЩОБ ЗРОБИТИ СКРІНШОТ
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);
    @Override
    public void testFailed(ExtensionContext context, Throwable cause){
        LOGGER.info("Test{} - Failde", context.getTestMethod().get().getName());
        String screenshotName = context.getTestMethod().get().getName() +
                String.valueOf(System.currentTimeMillis()).substring(9,13);
        LOGGER.info("Try to trace screenshot ");
        TakesScreenshot ts = (TakesScreenshot) ((baseTest) context.getRequiredTestInstance()).driver;

        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("build/reports/tests/" + screenshotName + ".png"));
        } catch (IOException e) {
            LOGGER.info("Exception on saving screenshot: ");
            throw new RuntimeException(e);

        }
        attachScreenshotsToAllure(ts);
    }
    // ВИКОРИСТОВУЄТСЬЯ, ЩОБ СКРІНИ ЗАЛІТАЛИ НА АЛЮР
    @Attachment
    public byte[] attachScreenshotsToAllure(TakesScreenshot takesScreenshot) {
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }

}
