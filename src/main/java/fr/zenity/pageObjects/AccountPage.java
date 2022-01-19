package fr.zenity.pageObjects;

import fr.zenity.config.Properties;
import fr.zenity.manager.ManagerXLS;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class AccountPage extends Page{

    private final static String URL = Properties.Config.getEnvironment().getEnvironment()+"/client/compte.html";

    public void pause(int tmps){
        try{
            Thread.sleep(tmps);
        }catch(Exception e){}
    }

    /* ------------------- BY ------------------- */

        private final static By compte = By.id("client_email");
        private final static By mdp = By.id("client_password");
        private final static By chmdp = By.id("client_checkpassword");
        private final static By pseudo = By.id("client_nickname");
        private final static By civilite = By.id("client_civility");
        private final static By nom = By.id("client_name");
        private final static By prenom = By.id("client_firstname");
        private final static By num = By.id("client_gsm");
        private final static By date = By.id("client_birthdate");
        private final static By adresse = By.id("client_address");
        private final static By cp = By.id("client_zip");
        private final static By city = By.id("client_city");

    /* #### CREATION DE COMPTE ### */

        private final static By monCompte = By.xpath("//a[@href='/connexion.html']");
        private final static By button = By.xpath("//button[contains(text(),'Je crée mon compte')]");
        private final static By cgv = By.id("cgv");
        private final static By createButton = By.xpath("//button[contains(text(),'Je crée mon compte')]");
        private final static By created = By.xpath("//h2[contains(.,'Compte créé')]");

    public void goTo(){
        driver.get(URL);
    }

    public void navigateTo(){
        System.out.println("Je suis avant la pause");
        this.pause(5000);
        System.out.println("Je suis après la pause");
        this.driver.get("https://www.gamecash.fr/connexion.html");
        /*WebElement wCompte = this.driver.findElement(uCompte);
        wCompte.click();*/

    }

    public boolean isLogged() {
        if (this.driver.getCurrentUrl().equals("https://www.gamecash.fr/connexion.html")){
            return false;
        }
        return true;
    }

    public boolean isLogout(){
        /*WebElement wCompte = this.driver.findElement(uCompte);
        wCompte.click();*/
        this.driver.get("https://www.gamecash.fr/connexion.html");
        if(this.driver.getCurrentUrl().equals("https://www.gamecash.fr/connexion.html")){
            return true;
        }
        return false;
    }


    /* #### CREATION DE COMPTE ### */

    public void createAccount(String mail, String pwd, String nkName, String genre, String name, String fName,
                              String cell, String birth, String home, String zCode, String hCity){

        goTo();

        adresseMail(mail);
        firstConfirm();
        password(pwd);
        pseudo(nkName);
        choixCivil(genre);
        nom(name);
        prenom(fName);
        telephone(cell);
        anniv(birth);
        adresse(home);
        codePostal(zCode);
        ville(hCity);
        create();
    }

    public void sent(By element, String value){
        this.driver.findElement(element).sendKeys(value);
    }

    public void clean(By element){
        this.driver.findElement(element).clear();
    }

    public void adresseMail(String mail){
        sent(compte, mail);
    }

    public void firstConfirm(){
        WebElement wButt = this.driver.findElement(button);
        wButt.click();
    }

    public void password(String myPassword){
        sent(mdp, myPassword);
        sent(chmdp, myPassword);
    }

    public void pseudo(String vPseudo){
        sent(pseudo, vPseudo);
    }

    public void choixCivil(String s ){
        WebElement wCivilite = this.driver.findElement(civilite);
        Select select = new Select(wCivilite);
        s = s.toLowerCase();

        if (s.equals("male"))
        {
            select.selectByVisibleText("Monsieur");
        }
        else if (s.equals("female"))
        {
            select.selectByVisibleText("Madame");
        }
    }

    public void nom (String vNom){
        sent(nom, vNom);
    }

    public void prenom (String vPrenom){
        sent(prenom, vPrenom);
    }

    public void telephone(String vTel){
        sent(num, vTel);
    }

    public void anniv (String dateAnniv){
        clean(date);
        sent(date, dateAnniv);
    }

    public void adresse (String vAdresse){
        sent(adresse, vAdresse);
    }

    public void codePostal (String codeP){
        sent(cp, codeP);
    }

    public void ville (String ville){
        sent(city, ville);
    }

    public void create(){
        WebElement wCGV = this.driver.findElement(cgv);
        wCGV.click();

        WebElement wCreate = this.driver.findElement(createButton);
        wCreate.click();
    }

    public boolean createdAccount(){
        if(this.driver.findElement(created).isDisplayed()){return true;}
        return false;
    }

    public void boucle(Integer nb){
        ManagerXLS data = new ManagerXLS();
        data.load("Creation");
        int length = Objects.isNull(nb)?data.getSize():nb;
        List<String> user;
        
        for(int i =0; i< length; i++){
            user = data.getLine(i);
            createAccount(user.get(0), user.get(1),
                        user.get(2), user.get(3),
                        user.get(4), user.get(5),
                        user.get(6), user.get(7),
                        user.get(8), user.get(9),
                        user.get(10));
        }
    }

}