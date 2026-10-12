package com.thiago.gestion.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SubcategoriaRequest {

    @NotBlank(message = "El nombre de la subcategoria no puede estar vacío. ")
    @Size(min = 5, max = 20, message = "El nombre de la subcategoría debe contener entre 5 y 20 carácteres.")
    private String nombre;

    private String descripcion;

    @NotNull(message = "La la categoria no puede estar vacía. ")
    private Long idCategoria;
}
