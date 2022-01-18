package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.AccountPage;
import io.cucumber.java8.En;

import static org.testng.Assert.assertTrue;

public class CreateStep implements En {

    public CreateStep(AccountPage account){
        /*Given("", () -> {

        });*/

        When("^user fill is email by \"([^\"]*)\"$", (String email) -> {
            account.adresseMail(email);
        });

        And("^validate email$", () -> {
            account.firstConfirm();
        });

        And("^fill password by \"([^\"]*)\"$", (String pwd) -> {
            account.password(pwd);
        });

        And("^fill nickname by \"([^\"]*)\"$", (String nkname) -> {
            account.pseudo(nkname);
        });

        And("^choose gender as \"([^\"]*)\"$", (String gender) -> {
            account.choixCivil(gender);
        });

        And("^fill name by \"([^\"]*)\"$", (String lName) -> {
            account.nom(lName);
        });

        And("^fill firstname by \"([^\"]*)\"$", (String fName) -> {
            account.prenom(fName);
        });

        And("^fill cellphone by \"([^\"]*)\"$", (String cell) -> {
            account.telephone(cell);
        });

        And("^fill birthdate by \"([^\"]*)\"$", (String birth) -> {
            account.anniv(birth);
        });

        And("^fill adress by \"([^\"]*)\"$", (String adress) -> {
            account.adresse(adress);
        });

        And("^fill zipCode by \"([^\"]*)\"$", (String zCode) -> {
            account.codePostal(zCode);
        });

        And("^fill city by \"([^\"]*)\"$", (String city) -> {
            account.ville(city);
        });

        And("^validate inscription$", () -> {
            account.create();
            account.pause(10000);
        });

        Then("^he should be on page for account activation$", () -> {
            assertTrue(account.createdAccount());
        });
    }
}
