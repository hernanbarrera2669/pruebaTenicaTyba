package com.tyba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.tyba.userinterfaces.IngresoUsuarioNuevo.*;
import static com.tyba.userinterfaces.LogeoUsuario.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginUsuario implements Task {
    private String username;
    private String password;

    protected LoginUsuario(String username, String password){
        this.username=username;
        this.password=password;
    }

    public static LoginUsuario hacerLoginUsuario(
            String username,
            String password){
        return Tasks.instrumented(
                LoginUsuario.class, username, password);
    }

    @Step("{0} Se ingresan los datos de un usuario existente")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_USER),
                Enter.theValue(username).into(TXT_USERNAME_LOGIN),
                Enter.theValue(password).into(TXT_PASSWORD_LOGIN),
                WaitUntil.the(BTN_SIGN_IN, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(BTN_SIGN_IN)
        );
    }
}
