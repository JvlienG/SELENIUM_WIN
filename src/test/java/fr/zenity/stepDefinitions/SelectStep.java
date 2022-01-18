package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.HomePage;
import fr.zenity.pageObjects.ArticlePage;

import io.cucumber.java8.En;

public class SelectStep implements En {

    public SelectStep(ArticlePage articlePage, HomePage homePage){
        Given("^user is on result page for \"([^\"]*)\"$", (String art) -> {
            homePage.navigateTo();
            articlePage.searchArticle(art);
            articlePage.isSearchPage(art);
        });

        When("^user select the (-?\\d+) article on the page$", (String numb) -> {
            articlePage.selectArticle(Integer.parseInt(numb));
        });

        Then("^he should be on the article page$", () -> {
            articlePage.isSelected();
        });
        When("^user select the <number> article on the page$", () -> {
        });
    }
}