package com.thiago.gestion.dto;

import com.thiago.gestion.domain.TipoCliente;
import lombok.Data;

import java.time.LocalDate;

@Data
public class  ClienteResponse {

    private Long id;
    private String email;
    private String telefono;
    private TipoCliente tipoCliente;
    private String direccion;
    private LocalDate fechaAlta;
    private String dni;
    private String nombre;
    private String apellido;
    private String cuit;
    private String razonSocial;
}
