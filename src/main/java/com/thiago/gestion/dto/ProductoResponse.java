package com.thiago.gestion.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoResponse {
    private Long id;
    private String nombre;
    private String codigoBarras;
    private BigDecimal precioUnitario;
    private BigDecimal costoUnitario;
    private Integer stock;



    private Long idSubcategoria;
    private Long idProveedor;
    private Long idMarca;

}
