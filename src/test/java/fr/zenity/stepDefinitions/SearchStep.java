package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.ArticlePage;
import fr.zenity.pageObjects.HomePage;
import io.cucumber.java8.En;

public class SearchStep implements En {

    public SearchStep(HomePage home, ArticlePage articlePage){
        Given("^user is on home page$", () -> {
            home.navigateTo();
        });

        When("^user do a research for \"([^\"]*)\"$", (String art) -> {
            articlePage.searchArticle(art);
        });

        Then("^he should be on the result page matching with \"([^\"]*)\"$", (String art) -> {
            articlePage.isSearchPage(art);
        });
    }

}
