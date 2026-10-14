package com.thiago.gestion.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.thiago.gestion.domain.TipoCliente;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;




@Data
public class ClienteRequest {

    @Email(message = "El email no tiene un formato válido. ")
    private String email;

    @NotBlank(message = "El teléfono del cliente no puede estar vacío. ")
    @Size(min = 5, max=50, message = "El telefono debe contener un formato: [codigo-area]-[numero local]")
    private String telefono;

    @NotBlank(message = "El tipo de cliente no puede estar vacío.")
    private String tipoCliente;


    @Size(min=5, max=50, message = "La dirección debe contener entre 5 y 50 carácteres")
    private String direccion;

    @PastOrPresent(message = "La fecha de alta debe ser en el pasado o en el presente. ")
    private LocalDate fechaAlta;


    @Size(min = 7, max = 11, message = "El dni no tiene un formato válido. ")
    private String dni;


    @Size(min = 5, max = 50, message = "El nombre debe contener entre 5 a 50 carácteres. ")
    private String nombre;


    @Size(min = 5, max = 50, message = "El apellido debe contener entre 5 a 50 carácteres. ")
    @Column(name = "apellido", length = 255)
    private String apellido;

    @Size(min = 8, max = 11, message = "El cuit no tiene un formato válido. ")
    private String cuit;

    @Size(min = 5, max = 50, message = "La razon social debe contener entre 5 a 50 carácteres. ")
    private String razonSocial;

}
