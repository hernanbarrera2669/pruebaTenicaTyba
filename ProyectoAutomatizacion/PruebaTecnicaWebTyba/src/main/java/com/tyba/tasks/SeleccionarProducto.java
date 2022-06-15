package com.tyba.tasks;

import com.tyba.models.DatosProducto;
import com.tyba.userinterfaces.IngresoProductos;
import com.tyba.utils.Esperas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.tyba.userinterfaces.IngresoProductos.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarProducto implements Task {

    private List<DatosProducto> listaProductos;

    protected SeleccionarProducto(List<DatosProducto> listaProductos){
        this.listaProductos=listaProductos;
    }

    public static SeleccionarProducto seleccionarProducto(List<DatosProducto> listaProductos){
        return Tasks.instrumented(
                SeleccionarProducto.class, listaProductos);
    }

    @Step("{0} Se selecciona el producto a comprar")
    @Override
    public <T extends Actor> void performAs(T actor) {
        for(DatosProducto productos : listaProductos) {
            actor.attemptsTo(
                    WaitUntil.the(LNK_POPULAR_ITEMS, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(LNK_POPULAR_ITEMS),
                    Click.on(IngresoProductos.selectViewDetails(productos.getProducto())),
                    Click.on(IngresoProductos.selectColor(productos.getColor())),
                    Enter.theValue(productos.getCantidad()).into(BTN_SELECT_QUANTITY),
                    Click.on(BTN_ADD_TO_CART));
            new Esperas().enSegundos(15);
            actor.attemptsTo(
                    WaitUntil.the(BTN_INICIO, isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_INICIO)
            );
        }
    }
}
