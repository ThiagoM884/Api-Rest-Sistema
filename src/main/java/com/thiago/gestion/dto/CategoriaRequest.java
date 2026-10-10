package com.thiago.gestion.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoriaRequest {
    @NotBlank(message = "El nombre de la categoría no puede estar vacío.")
    @Size(min = 5, max = 50, message = "El nombre de la categoría debe contener entre 10 y 50 carácteres.")
    private String nombre;

    @Size(min = 5, max = 50, message = "La descripción de la categoría debe contener entre 10 y 50 carácteres.")
    private String descripcion;
}
