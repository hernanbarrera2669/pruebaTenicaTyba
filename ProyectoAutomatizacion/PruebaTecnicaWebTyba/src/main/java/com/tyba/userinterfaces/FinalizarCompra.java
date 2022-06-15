package com.tyba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class FinalizarCompra extends PageObject {

    public static final Target BTN_GOT_TO_CARD =
            Target.the("Botón agregar al carrito").located(By.id("menuCart"));

    public static final Target BTN_CKECKOUT =
            Target.the("Botón checkout").located(By.id("checkOutButton"));

    public static final Target BTN_NEXT =
            Target.the("Botón siguiente").located(By.id("next_btn"));

    public static final Target BTN_SELECT_SAFEPAY =
            Target.the("Botón seleccionar medio de pago SafePay").located(By.name("safepay"));

    public static final Target TXT_SAFE_PAY_USERNAME =
            Target.the("Ingresar usuario SafePay").located(By.name("safepay_username"));

    public static final Target TXT_SAFE_PAY_PASSWORD =
            Target.the("Ingresar password SafePay").located(By.name("safepay_password"));

    public static final Target BTN_PAY_NOW =
            Target.the("Botón pagar ahora").located(By.id("pay_now_btn_SAFEPAY"));
}
