package com.tyba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class IngresoProductos extends PageObject {

    public static final Target LNK_POPULAR_ITEMS =
            Target.the("Seleccionar Link Popular Items").located(By.xpath("//a[contains(text(), 'POPULAR ITEMS')]"));

    public static Target selectViewDetails(String product) {
        return Target.the("Selecciona Link View details")
                .locatedBy("//p[contains(text(), '{0}')]//following-sibling::a")
                .of(product);
    }

    public static Target selectColor(String color) {
        return Target.the("Seleccionar el color del producto")
                .locatedBy("//span[@id='bunny' and @title='{0}']")
                .of(color);
    }

    public static final Target BTN_SELECT_QUANTITY =
            Target.the("Botón seleccionar cantidad de producto").located(By.xpath("//input[@name='quantity']"));

    public static final Target BTN_ADD_TO_CART =
            Target.the("Botón añadir al carro de compras").located(By.name("save_to_cart"));


    public static final Target BTN_INICIO =
            Target.the("Botón añadir al carro de compras").located(By.xpath("//span[contains(text(), 'dvantage')]"));

}
