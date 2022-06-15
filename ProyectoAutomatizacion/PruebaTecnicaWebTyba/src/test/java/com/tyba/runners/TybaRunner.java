package com.tyba.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/web_tyba.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "com.tyba.stepdefinitions")


public class TybaRunner {
}

