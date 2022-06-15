package com.tyba.enums;

public enum VariablesSesion {
    USUARIO_LOGUEADO("Selected product");

    private String nombreVariable;

    VariablesSesion(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }

    public String getNombreVariable() {
        return nombreVariable;
    }
}
