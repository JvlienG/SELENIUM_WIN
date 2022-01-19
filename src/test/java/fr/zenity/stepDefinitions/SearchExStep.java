package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.ArticlePage;
import io.cucumber.java8.En;

import static org.testng.Assert.assertTrue;

public class SearchExStep implements En {

    public SearchExStep(ArticlePage article){
        When("^user do a research for article from Excel data$", () -> {
            article.searchArticle();
        });
        Then("he should be on the result page matching with research", () -> {
            assertTrue(article.isSearchPage());
        });
    }

}
