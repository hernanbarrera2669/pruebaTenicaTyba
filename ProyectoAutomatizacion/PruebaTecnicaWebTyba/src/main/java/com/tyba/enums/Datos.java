package com.tyba.enums;

public enum Datos {
    SAFE_PAY_USERNAME("caro123"),
    SAFE_PAY_PASSWORD("Carolina123"),
    SUCCESS_PURCHASE("Thank you for buying with Advantage");

    private final String datos;

    Datos(String datos) {
        this.datos = datos;
    }

    public String getDatos() {
        return datos;
    }
}
