package com.tyba.tasks;

import com.tyba.userinterfaces.IngresoUsuarioNuevo;
import com.tyba.utils.Esperas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.tyba.userinterfaces.IngresoUsuarioNuevo.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DatosRegistro implements Task {
    private String username;
    private String email;
    private String password;
    private String confirm_password;
    private String name;
    private String last_name;
    private String phone;
    private String country;
    private String city;
    private String address;
    private String state;

    protected DatosRegistro(
            String username,
            String email,
            String password,
            String confirm_password,
            String name,
            String last_name,
            String phone,
            String country,
            String city,
            String address,
            String state) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
        this.name = name;
        this.last_name = last_name;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.address = address;
        this.state = state;
    }

    public static DatosRegistro ingresarDatosUsuario(
            String username,
            String email,
            String password,
            String confirm_password,
            String name,
            String last_name,
            String phone,
            String country,
            String city,
            String address,
            String state) {
        return Tasks.instrumented(
                DatosRegistro.class, username, email, password, confirm_password, name, last_name, phone, country, city, address, state);
    }

    @Step("{0} Se ingresan los datos de usuario")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_USER),
                WaitUntil.the(BTN_CREATEACCOUNT, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(BTN_CREATEACCOUNT),
                Enter.theValue(username).into(TXT_USERNAME),
                Enter.theValue(email).into(TXT_EMAIL),
                Enter.theValue(password).into(TXT_PASSWORD),
                Enter.theValue(confirm_password).into(TXT_CONFIRM_PASSWORD),
                Enter.theValue(name).into(TXT_NAME),
                Enter.theValue(last_name).into(TXT_LASTNAME),
                Enter.theValue(phone).into(TXT_PHONE),
                Enter.theValue(city).into(TXT_CITY),
                Enter.theValue(city).into(TXT_ADDRESS),
                Enter.theValue(city).into(TXT_STATE));
        new Esperas().enSegundos(120);
        actor.attemptsTo(
                Click.on(IngresoUsuarioNuevo.selectCountry(country)),
                Click.on(CHK_AGREE),
                Click.on(BTN_REGISTER)
        );
        new Esperas().enSegundos(10);
    }
}
