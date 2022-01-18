package fr.zenity.pageObjects;

import fr.zenity.manager.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait shortWait;
    protected WebDriverWait longWait;
    protected WebDriverWait middleWait;

    protected JavascriptExecutor js;
    protected Actions actions;

    protected Page(){
        driver = WebDriverManager.getInstance().getDriver();
        PageFactory.initElements(driver,this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        middleWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        longWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        js = (JavascriptExecutor)driver;
        actions = new Actions(driver);
    }

    public void clickOn(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void maximize(){
        driver.manage().window().maximize();
    }

    /**
     * Wait until the condition in the function is satisfied
     *
     * @param isTrue the condition
     * @param <V>    the condition return type
     * @return true is thee condition is satisfied, false if the condition hasn't been satisfied in the given time
     */
    protected <V> boolean waitForPageLoading(Function<? super WebDriver, V> isTrue) {
        try {
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected <V> boolean waitUntil(Function<? super WebDriver, V> isTrue) {
        try {
            wait.until(isTrue);
            return true;
        } catch (StaleElementReferenceException | TimeoutException e) {
            return false;
        }
    }

    protected <V> boolean loadingWaitUntil(Function<? super WebDriver, V> isTrue) {
        try {
            return true;
        } catch (StaleElementReferenceException | TimeoutException e) {
            return false;
        }
    }

    protected <V> boolean shortWaitUntil(Function<? super WebDriver, V> isTrue) {
        try {
            shortWait.until(isTrue);
            return true;
        } catch (StaleElementReferenceException | TimeoutException e) {
            return false;
        }
    }

    protected <V> boolean loginWaitUntil(Function<? super WebDriver, V> isTrue) {
        try {
            return true;
        } catch (StaleElementReferenceException | TimeoutException e) {
            return false;
        }
    }

    protected <V> boolean middleWaitUntil(Function<? super WebDriver, V> isTrue) {
        try {
            middleWait.until(isTrue);
            return true;
        } catch (StaleElementReferenceException | TimeoutException e) {
            return false;
        }
    }

}