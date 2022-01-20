package fr.zenity.stepDefinitions;

import fr.zenity.utils.Util;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks{

    public Hooks(){

    }

    @After(order = 1000)
    public void screenShots(Scenario scenario){
        Util.takeScreenshot(scenario.getName());
    }

}
