package fr.zenity.runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/features",
        //monochrome = true,
        glue = {"fr.zenity.stepDefinitions", "fr/zenity/pageObjects"},
        plugin = {"pretty",
                "html:target/reports/html/htmlreport",
                "json:target/reports/jsonreports/index.json",
                "junit:target/reports/xmlreport.xml",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        },
        tags = "@Login"
)
public class TestRunner extends BaseRunner{

}