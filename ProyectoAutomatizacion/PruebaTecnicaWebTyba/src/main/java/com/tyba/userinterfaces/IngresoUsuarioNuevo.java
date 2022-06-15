package com.tyba.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class IngresoUsuarioNuevo extends PageObject {

    public static final Target BTN_USER =
            Target.the("Boton de usuario para registrarse o acceder").located(By.id("menuUserLink"));

    public static final Target BTN_CREATEACCOUNT =
           Target.the("Boton para crear una cuenta nueva").located(By.xpath("//div[@class = 'login ng-scope']// a[contains (text(), 'CREATE NEW ACCOUNT')]"));

    public static final Target TXT_USERNAME =
            Target.the("Formulario de Ingreso para Nombre de Usuario").located(By.name("usernameRegisterPage"));

    public static final Target TXT_EMAIL =
            Target.the("Formulario de Ingreso para EMAIL").located(By.name("emailRegisterPage"));

    public static final Target TXT_PASSWORD =
            Target.the("Formulario de Ingreso para PASSWORD").located(By.name("passwordRegisterPage"));

    public static final Target TXT_CONFIRM_PASSWORD =
            Target.the("Formulario de Ingreso para CONFIRMAR PASSWORD").located(By.name("confirm_passwordRegisterPage"));

    public static final Target TXT_NAME =
            Target.the("Formulario de Ingreso para NOMBRE").located(By.name("first_nameRegisterPage"));

    public static final Target TXT_LASTNAME =
            Target.the("Formulario de Ingreso para APELLIDO>").located(By.name("last_nameRegisterPage"));

    public static Target selectCountry(String country){
        return Target.the("Formulario de ingreso para el PAIS")
                .locatedBy("//select[@name='countryListboxRegisterPage']//option[contains(text(), '{0}')]")
                .of(country);
    }
    public static final Target TXT_CITY =
            Target.the("Formulario de Ingreso para CIUDAD").located(By.name("cityRegisterPage"));

    public static final Target TXT_PHONE =
            Target.the("Formulario de Ingreso para TELEFONO").located(By.name("phone_numberRegisterPage"));

    public static final Target TXT_ADDRESS =
            Target.the("Formulario de Ingreso para DIRECCION").located(By.name("addressRegisterPage"));

    public static final Target TXT_STATE =
            Target.the("Formulario de Ingreso para DEPARTAMENTO").located(By.name("state_/_province_/_regionRegisterPage"));

    public static final Target CHK_AGREE =
            Target.the("Formulario de Ingreso para ACEPTAR el acuerdo").located(By.xpath("//input[@name='i_agree']"));

    public static final Target BTN_REGISTER =
            Target.the("Boton para REGISTRAR el usuario").located(By.id("register_btnundefined"));

}
