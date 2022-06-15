package com.tyba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.tyba.userinterfaces.VerificarCompra.LBL_MENSAJE_COMPRA_EXITOSA;

public class VerificarMensajeCompra implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LBL_MENSAJE_COMPRA_EXITOSA.resolveFor(actor).getText();
    }

    public static VerificarMensajeCompra isCorrect() {
        return new VerificarMensajeCompra();
    }
}
