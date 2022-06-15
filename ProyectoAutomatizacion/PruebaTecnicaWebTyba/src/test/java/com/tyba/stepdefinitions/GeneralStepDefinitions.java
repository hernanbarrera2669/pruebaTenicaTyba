package com.tyba.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;


import com.tyba.tasks.Abrir;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class GeneralStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver hisBrowser;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(BrowseTheWeb.with(hisBrowser)));
    }

    @Dado("^Que el (.*) ingresa al portal web de AdvantageDemo")
    public void ingresarPortalWeb(String actor) {
        theActorCalled(actor).wasAbleTo(Abrir.paginaWeb());
    }
}
