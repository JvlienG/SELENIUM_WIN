package fr.zenity.pageObjects;

import fr.zenity.config.Properties;
import fr.zenity.manager.ManagerXLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class LoginPage extends Page{

    private final static String URL = Properties.Config.getEnvironment().getEnvironment()+"/connexion.html";

    /* ------------------- BY ------------------- */

    private final static By usernameInputLocator = By.id("login");
    private final static By passwordInputLocator = By.id("password");
    private final static By submitButton = By.xpath("//button[contains(text(),'Connexion')]");


    public void navigateTo(){
        driver.get(URL);
    }

    public void login(){

        ManagerXLS data = new ManagerXLS();
        data.load("Login");
        List<String> user = data.getLine(0);

        String username = user.get(0);
        String password = user.get(1);

        WebElement usernameInput = this.driver.findElement(this.usernameInputLocator);
        WebElement passwordInput  = this.driver.findElement(this.passwordInputLocator);
        WebElement submitButton = this.driver.findElement(this.submitButton);

        usernameInput.clear();
        passwordInput.clear();

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void login(String usr, String pwd) throws IOException {

        String username = usr;
        String password = pwd;

        WebElement usernameInput = this.driver.findElement(this.usernameInputLocator);
        WebElement passwordInput  = this.driver.findElement(this.passwordInputLocator);
        WebElement submitButton = this.driver.findElement(this.submitButton);

        usernameInput.clear();
        passwordInput.clear();

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

   /* public void boucle(){
        for(int i = 0; i < list.size(); i++){

        }
    }*/



}