package com.tyba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.tyba.userinterfaces.IngresoUsuarioNuevo.BTN_USER;

public class VerificarUsuarioCreado implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BTN_USER.resolveFor(actor).getText();
    }

    public static VerificarUsuarioCreado isCorrect() {
        return new VerificarUsuarioCreado();
    }
}
