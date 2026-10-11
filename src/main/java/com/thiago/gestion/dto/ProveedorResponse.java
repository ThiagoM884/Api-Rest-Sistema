package com.thiago.gestion.dto;

import lombok.Data;

@Data
public class ProveedorResponse {

    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

}
