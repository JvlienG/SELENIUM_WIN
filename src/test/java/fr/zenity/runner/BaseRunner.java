package fr.zenity.runner;

import fr.zenity.Enum.Browser;
import fr.zenity.config.Properties;
import fr.zenity.manager.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Objects;

public class BaseRunner extends AbstractTestNGCucumberTests {

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(@Optional String browser){
        WebDriverManager
                .getInstance()
                .setDriver(Objects.isNull(browser) ? Properties.Config.getBrowser() : Browser.valueOf(browser.toUpperCase()));
    }

    @AfterTest
    public void tearDown(){
        WebDriverManager.getInstance().quit();
    }


}