package com.thiago.gestion.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProveedorRequest {

    @NotBlank(message = "El nombre del proveedor no puede estar vacío. ")
    @Size(min = 5, max = 50, message = "El nombre del proveedor debe contener entre 5 y 50 carácteres.")
    private String nombre;

    @NotBlank(message = "El teléfono del proveedor no puede estar vacío. ")
    @Size(min = 5, max=50, message = "El telefono debe contener un formato: [codigo-area]-[numero local]")
    private String telefono;

    @Email(message = "El email no posee un formato válido.")
    @Size(min = 10, max = 50, message = "El email debe tener entre 10 y 50 carácteres.")
    private String email;


    @Size(max = 255, message = "La dirección excede la cantidad permitida de carácteres.")
    private String direccion;

}
