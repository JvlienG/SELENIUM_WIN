package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.AccountPage;
import fr.zenity.pageObjects.LoginPage;
import fr.zenity.pageObjects.LogoutPage;
import io.cucumber.java8.En;

import static org.testng.Assert.assertTrue;

public class LogoutStep implements En {

    public LogoutStep(AccountPage accountPage, LoginPage loginPage, LogoutPage logOutPage){
       Given("^user is on account page$", () -> {
           accountPage.goTo();
           if(!(accountPage.isLogged())) {
                loginPage.login();
                accountPage.navigateTo();
           }
        });

        When("^user click on \"log out\"$", () -> {
            logOutPage.logout();
        });

        When("^user logout$", () -> {
            logOutPage.logout();
        });

        Then("^he should be disconnect$", () -> {
            assertTrue(accountPage.isLogout());
        });
    }
}
