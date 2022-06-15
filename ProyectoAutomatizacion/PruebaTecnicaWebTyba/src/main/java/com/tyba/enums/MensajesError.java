package com.tyba.enums;

public enum MensajesError {
    NO_SE_REALIZO_LA_COMPRA("No se pudo realizar la compra"),
    NO_SE_REGISTRO_EL_USUARIO("No se pudo registrar el usuario correctamente");

    private final String mensajeError;

    MensajesError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }
}
