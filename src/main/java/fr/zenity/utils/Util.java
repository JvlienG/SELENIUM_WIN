package fr.zenity.utils;

import fr.zenity.manager.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Util {

   @Attachment(value = "Screenshot after {name}", type = "image/png")
    public static byte[] takeScreenshot(String name) {
        return ((TakesScreenshot) WebDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
