package com.tyba.stepdefinitions;

import com.tyba.enums.CabeceraTabla;
import com.tyba.enums.Datos;
import com.tyba.enums.MensajesError;
import com.tyba.enums.VariablesSesion;
import com.tyba.exceptions.ExcepcionesGenerales;
import com.tyba.models.DatosPersonales;
import com.tyba.models.DatosProducto;
import com.tyba.questions.VerificarMensajeCompra;
import com.tyba.questions.VerificarUsuarioCreado;
import com.tyba.tasks.DatosRegistro;
import com.tyba.tasks.LoginUsuario;
import com.tyba.tasks.RealizarCompra;
import com.tyba.tasks.SeleccionarProducto;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.Serenity;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class AdvantageStepDefinitions {
    @DataTableType
    public DatosPersonales datosRegistro(Map<String, String> datosRegistro) {
        return new DatosPersonales(
                datosRegistro.get(CabeceraTabla.USER_NAME.getValor()),
                datosRegistro.get(CabeceraTabla.EMAIL.getValor()),
                datosRegistro.get(CabeceraTabla.PASSWORD.getValor()),
                datosRegistro.get(CabeceraTabla.CONFIRM_PASSWORD.getValor()),
                datosRegistro.get(CabeceraTabla.NAME.getValor()),
                datosRegistro.get(CabeceraTabla.LAST_NAME.getValor()),
                datosRegistro.get(CabeceraTabla.PHONE.getValor()),
                datosRegistro.get(CabeceraTabla.COUNTRY.getValor()),
                datosRegistro.get(CabeceraTabla.CITY.getValor()),
                datosRegistro.get(CabeceraTabla.ADDRESS.getValor()),
                datosRegistro.get(CabeceraTabla.STATE.getValor())
        );
    }

    @DataTableType
    public DatosProducto datosProducto(Map<String, String> datosProducto) {
        return new DatosProducto(
                datosProducto.get(CabeceraTabla.PRODUCT.getValor()),
                datosProducto.get(CabeceraTabla.COLOR.getValor()),
                datosProducto.get(CabeceraTabla.QUANTITY.getValor()));
    }

    @Cuando("Ingrese a la opción usuario para crear nueva cuenta con los datos$")
    public void datosRegistro(List<DatosPersonales> datosRegistroUsuario) {
        String username = datosRegistroUsuario.get(0).getUsername();
        String email = datosRegistroUsuario.get(0).getEmail();
        String password = datosRegistroUsuario.get(0).getPassword();
        String confirm_password = datosRegistroUsuario.get(0).getConfirm_password();
        String name = datosRegistroUsuario.get(0).getName();
        String last_name = datosRegistroUsuario.get(0).getLast_name();
        String phone = datosRegistroUsuario.get(0).getTelefono();
        String country = datosRegistroUsuario.get(0).getCountry();
        String city = datosRegistroUsuario.get(0).getCity();
        String address = datosRegistroUsuario.get(0).getDireccion();
        String state = datosRegistroUsuario.get(0).getDepartamento();
        Serenity.setSessionVariable(VariablesSesion.USUARIO_LOGUEADO.getNombreVariable()).to(datosRegistroUsuario.get(0).getUsername());
        theActorInTheSpotlight().attemptsTo(DatosRegistro.ingresarDatosUsuario(username, email, password, confirm_password, name,
                last_name, phone, country, city, address, state));
    }

    @Entonces("El usuario visualizará su nombre en la pantalla principal$")
    public void verificarDatosRegistro() {
        theActorInTheSpotlight().should(seeThat(VerificarUsuarioCreado.isCorrect(), equalTo(Serenity.sessionVariableCalled(VariablesSesion.USUARIO_LOGUEADO.getNombreVariable())))
                .orComplainWith(
                        ExcepcionesGenerales.class, MensajesError.NO_SE_REGISTRO_EL_USUARIO.getMensajeError()));
    }

    @Cuando("Ingreso con un usuario existente$")
    public void datosIngreso(List<DatosPersonales> datosIngresoUsuario) {
        String username = datosIngresoUsuario.get(0).getUsername();
        String password = datosIngresoUsuario.get(0).getPassword();
        theActorInTheSpotlight().attemptsTo(LoginUsuario.hacerLoginUsuario(username, password));
    }

    @Cuando("Selecciono de la opción del menu POPULAR ITEMS el producto deseado, cambio el color, la cantidad y lo añado al carrito de compras$")
    public void seleccionarProducto(List<DatosProducto> datosProducto) {
        theActorInTheSpotlight().attemptsTo(SeleccionarProducto.seleccionarProducto(datosProducto));
    }

    @Cuando("Se realiza la compra de los productos$")
    public void realizarCompraProducto() {
        theActorInTheSpotlight().attemptsTo(RealizarCompra.realizarCompra());
    }

    @Entonces("Se verifica que la compra que haya realizado satisfactoriamente$")
    public void verificarCompra() {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeCompra.isCorrect(), equalTo(Datos.SUCCESS_PURCHASE.getDatos()))
                .orComplainWith(
                        ExcepcionesGenerales.class, MensajesError.NO_SE_REALIZO_LA_COMPRA.getMensajeError()));
    }
}
