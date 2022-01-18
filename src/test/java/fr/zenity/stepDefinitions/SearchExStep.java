package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.ArticlePage;
import io.cucumber.java8.En;

public class SearchExStep implements En {

    public SearchExStep(ArticlePage article){
        When("^user do a research for article from Excel data$", () -> {
            article.searchArticle();
        });
        Then("he should be on the result page matching with research", () -> {
            article.isSearchPage();
        });
    }

}
