package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.LoginPage;
import fr.zenity.pageObjects.HomePage;

import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class LoginStep implements En {

    private WebDriver driver;
    //private LoginPage loginPage= new LoginPage();

    public LoginStep(HomePage homePage,LoginPage loginPage) {
        Given("^user is on the login page$", () -> {
            loginPage.navigateTo();
        });

        When("^user is logging-in with \"([^\"]*)\" and \"([^\"]*)\"$", (String user, String pwd) -> {
            loginPage.login(user, pwd);
        });

        When("user is logging-in with the data from Excel", () -> {
            loginPage.login();
        });

        Then("^he should be on the home page with a welcome message$", () -> {
            assertTrue(homePage.isWelcomeDisplayed());
        });


    }
}