package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.HomePage;
import fr.zenity.pageObjects.ArticlePage;

import io.cucumber.java8.En;

import static org.testng.Assert.assertTrue;

public class SelectStep implements En {

    public SelectStep(ArticlePage articlePage, HomePage homePage){
        Given("^user is on result page for \"([^\"]*)\"$", (String art) -> {
            if(!(articlePage.isSearchPage(art))) {
                homePage.navigateTo();
                articlePage.searchArticle(art);
                articlePage.isSearchPage(art);
            }else{System.out.println("ELSE");}
        });

        When("^user select the first article on the page$", () -> {
            articlePage.selectArticle();
        });

        When("^user select the first article$", () -> {
           articlePage.selectArticle();
           assertTrue(articlePage.isSelected());
        });

        Then("^he should be on the article page$", () -> {
           assertTrue(articlePage.isSelected());
        });
    }
}