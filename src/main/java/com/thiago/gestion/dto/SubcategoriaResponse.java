package com.thiago.gestion.dto;

import lombok.Data;

@Data
public class SubcategoriaResponse {

    private Long id;
    private String nombre;
    private String descripcion;
    private Long idCategoria;
}
