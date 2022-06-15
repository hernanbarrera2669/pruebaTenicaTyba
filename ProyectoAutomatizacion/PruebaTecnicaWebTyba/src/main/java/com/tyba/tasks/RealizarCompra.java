package com.tyba.tasks;

import com.tyba.enums.Datos;
import com.tyba.utils.Esperas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.tyba.userinterfaces.FinalizarCompra.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class RealizarCompra implements Task {

    protected RealizarCompra() {
    }

    public static RealizarCompra realizarCompra() {
        return Tasks.instrumented(RealizarCompra.class);
    }

    @Step("{0} Se realiza la compra")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_GOT_TO_CARD),
                Click.on(BTN_CKECKOUT));
        new Esperas().enSegundos(70);
        actor.attemptsTo(
                Click.on(BTN_NEXT),
                Click.on(BTN_SELECT_SAFEPAY),
                Enter.theValue(Datos.SAFE_PAY_USERNAME.getDatos()).into(TXT_SAFE_PAY_USERNAME),
                Enter.theValue(Datos.SAFE_PAY_PASSWORD.getDatos()).into(TXT_SAFE_PAY_PASSWORD),
                WaitUntil.the(BTN_PAY_NOW, isEnabled()).forNoMoreThan(5).seconds(),
                Click.on(BTN_PAY_NOW));
        new Esperas().enSegundos(8);
    }
}
