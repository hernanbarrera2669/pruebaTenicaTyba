package com.tyba.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DatosPersonales {
    private String username;
    private String email;
    private String password;
    private String confirm_password;
    private String name;
    private String last_name;
    private String telefono;
    private String country;
    private String city;
    private String direccion;
    private String departamento;
}
