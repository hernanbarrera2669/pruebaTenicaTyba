package com.tyba.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class LogeoUsuario extends PageObject {

    public static final Target TXT_USERNAME_LOGIN =
            Target.the("Formulario de Ingreso para Nombre de Usuario ya existente").located(By.name("username"));

    public static final Target TXT_PASSWORD_LOGIN =
            Target.the("Formulario de Ingreso para password ya existente").located(By.name("password"));

    public static final Target BTN_SIGN_IN =
            Target.the("Formulario de Ingreso para botón de ingreso").located(By.id("sign_in_btnundefined"));


}


