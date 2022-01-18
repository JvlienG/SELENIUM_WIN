package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.AccountPage;
import io.cucumber.java8.En;

public class MultipleStep implements En {
    public MultipleStep(AccountPage account){
        /*Given("user is on the home page", () -> {

        });*/

        When("^user create (-?\\d+) accounts$", (String nb) -> {
            account.boucle(Integer.parseInt(nb));
        });

        When("^user create all accounts$", () -> {
            account.boucle(null);
        });

        Then("", () -> {

        });
    }
}
