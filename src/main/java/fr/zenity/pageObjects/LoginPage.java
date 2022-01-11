package fr.zenity.pageObjects;

import fr.zenity.config.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage extends Page{

    private final static String URL = Properties.Config.getEnvironment().getEnvironment()+"/connexion.html";

    /* ------------------- BY ------------------- */

    By usernameInputLocator = By.id("login");
    By passwordInputLocator = By.id("password");
    By submitButton = By.xpath("//button[contains(text(),'Connexion')]");


    public void navigateTo(){
        driver.get(URL);
    }

    public void login() throws IOException {

        String username = "test8@yopmail.com";
        String password = "Cacahuette9102";

        WebElement usernameInput = this.driver.findElement(this.usernameInputLocator);
        WebElement passwordInput  = this.driver.findElement(this.passwordInputLocator);
        WebElement submitButton = this.driver.findElement(this.submitButton);

        usernameInput.clear();
        passwordInput.clear();

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }



}