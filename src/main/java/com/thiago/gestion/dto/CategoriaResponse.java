package com.thiago.gestion.dto;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CategoriaResponse {

    private Long id;
    private String nombre;
    private String descripcion;
}
