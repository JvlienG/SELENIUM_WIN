package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.ArticlePage;
import fr.zenity.pageObjects.HomePage;
import io.cucumber.java8.En;

import static org.testng.Assert.assertTrue;

public class SearchStep implements En {

    public SearchStep(HomePage home, ArticlePage articlePage){
       Given("^user is on home page$", () -> {
           home.navigateTo();
        });

        When("^user do a research for \"([^\"]*)\"$", (String art) -> {
            articlePage.searchArticle(art);
        });

        When("^user do a research for article from Excel data$", () -> {
            articlePage.searchArticle();
        });

        When("^user search an article with Excel data$", () -> {
            articlePage.searchArticle();
            assertTrue(articlePage.isSearchPage());
        });

        Then("he should be on the result page matching with research", () -> {
            assertTrue(articlePage.isSearchPage());
        });

        Then("^he should be on the result page matching with \"([^\"]*)\"$", (String art) -> {
            //assertTrue(articlePage.isSearchPage(art));
        });
    }

}
