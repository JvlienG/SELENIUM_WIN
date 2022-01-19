package fr.zenity.pageObjects;

import fr.zenity.manager.ManagerXLS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static org.testng.Assert.assertTrue;

public class ArticlePage extends Page{

    public void pause(int time){
        try{
            Thread.sleep(time);
        }catch(Exception e){}
    }


    /* ------------------- BY ------------------- */
        By search = By.id("search");
        By firstProduct = By.cssSelector(".product-item:nth-child(1) .title");


        By panier = By.xpath("//a[@href='/panier.html']");
        By valider = By.xpath("//a[contains(.,'Valider mon panier')]");

    private String productTitle;

    /* ######### RECHERCHE D'ARTICLE ######### */

        public void searchArticle(String rech){

            WebElement wSearch = this.driver.findElement(search);
            wSearch.sendKeys(rech + '\n');
        }

        public boolean isSearchPage(String rech){
            String Search = rech;
            this.pause(4000);
            return this.driver.getCurrentUrl().contains(Search.replace(" ", "+"));
        }

        public boolean isSearchPage(){
            ManagerXLS data = new ManagerXLS();
            data.load("Search");
            List<String> dataSearch = data.getLine(0);
            String Search = dataSearch.get(0);

            this.pause(4000);
            return this.driver.getCurrentUrl().contains(Search.replace(" ", "+"));
        }

    public void searchArticle(){
        ManagerXLS data = new ManagerXLS();
        data.load("Search");
        List<String> dataSearch = data.getLine(0);
        this.searchArticle(dataSearch.get(0));
    }

    /* ######### FIN RECHERCHE D'ARTICLE ######### */

    /* ######### SELECTION D'ARTICLE ######### */

        public void selectFirst(){
            WebElement wProduit = this.driver.findElement(firstProduct);
            this.productTitle = wProduit.getText();
            wProduit.click();
        }

        public void selectArticle(){
            By product = By.cssSelector(".product-item:nth-child(1) .title");
            if(driver.findElement(product).isDisplayed()){
                WebElement wProduit = this.driver.findElement(product);
                this.productTitle = wProduit.getText();
                wProduit.click();
            } else{
                selectFirst();
            }
        }

        public boolean isSelected(){
            String product = this.productTitle.toLowerCase(Locale.ROOT);
            product = product.replace(" ", "-");
            product = product.replace(":", "");
            product = product.replaceAll("-{2,}", "-");
            return this.driver.getCurrentUrl().contains(product);
        }

    /* ######### FIN SELECTION D'ARTICLE ######### */
}
