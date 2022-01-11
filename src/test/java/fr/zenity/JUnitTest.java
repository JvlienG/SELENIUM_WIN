package fr.zenity;

import fr.zenity.Enum.Browser;
import fr.zenity.config.Properties;
import fr.zenity.manager.WebDriverManager;
import org.testng.annotations.*;
import java.util.Objects;

public class JUnitTest {
    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional String browser) {
        //if(!Objects.isNull(browser)) Properties.Config.setBrowser(browser);
        WebDriverManager
                .getInstance()
                .setDriver(Objects.isNull(browser) ? Properties.Config.getBrowser() : Browser.valueOf(browser.toUpperCase()));
    }

    @Test
    public void test1(){

    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.getInstance().quit();
    }
}