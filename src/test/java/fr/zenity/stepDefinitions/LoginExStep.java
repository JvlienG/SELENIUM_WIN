package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.LoginPage;
import io.cucumber.java8.En;

public class LoginExStep implements En {

    public LoginExStep(LoginPage login){
        When("user is logging-in with the data from Excel", () -> {
            login.login();
        });
    }

}
