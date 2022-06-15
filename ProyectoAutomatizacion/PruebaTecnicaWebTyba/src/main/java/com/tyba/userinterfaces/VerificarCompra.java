package com.tyba.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;

import net.serenitybdd.screenplay.targets.Target;

public class VerificarCompra extends PageObject {

    public static final Target LBL_MENSAJE_COMPRA_EXITOSA =
            Target.the("Formulario para verificar MENSAJE de compra exisota").located(By.xpath("//span[contains(text(), 'Thank you for buying with Advantage')]"));
}
