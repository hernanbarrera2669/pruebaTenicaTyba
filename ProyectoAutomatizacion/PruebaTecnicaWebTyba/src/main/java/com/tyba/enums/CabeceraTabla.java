package com.tyba.enums;

public enum CabeceraTabla {

    USER_NAME ("username"),
    EMAIL ("email"),
    PASSWORD("password"),
    CONFIRM_PASSWORD("confirm_password"),
    NAME("name"),
    LAST_NAME("last_name"),
    PHONE("phone"),
    STATE("state"),
    ADDRESS("address"),
    COUNTRY("country"),
    CITY("city"),
    PRODUCT("product"),
    COLOR("color"),
    QUANTITY("quantity");

    private String valor;

    CabeceraTabla(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
