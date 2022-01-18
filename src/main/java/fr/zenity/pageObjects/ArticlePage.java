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

        public void isSearchPage(String rech){
            String Search = rech;
            System.out.println(Search.replace(" ", "+"));
            this.pause(4000);
            assertTrue(this.driver.getCurrentUrl().contains(Search.replace(" ", "+")));
        }

        public void isSearchPage(){
            ManagerXLS data = new ManagerXLS();
            data.load("Search");
            List<String> dataSearch = data.getLine(0);
            String Search = dataSearch.get(0);

            System.out.println(Search.replace(" ", "+"));
            this.pause(4000);
            assertTrue(this.driver.getCurrentUrl().contains(Search.replace(" ", "+")));
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

        public void selectArticle(int x){
            By product = By.cssSelector(".product-item:nth-child(" + x + ") .title");
            if(driver.findElement(product).isDisplayed()){
                WebElement wProduit = this.driver.findElement(product);
                this.productTitle = wProduit.getText();
                wProduit.click();
            } else{
                selectFirst();
            }
        }

        public void isSelected(){
            String product = this.productTitle.toLowerCase(Locale.ROOT);
            product = product.replace(" ", "-");
            product = product.replace(":", "");
            System.out.println(product.replaceAll("-{2,}", "-"));
            product = product.replaceAll("-{2,}", "-");
            assertTrue(this.driver.getCurrentUrl().contains(product));
        }

    /* ######### FIN SELECTION D'ARTICLE ######### */
}
