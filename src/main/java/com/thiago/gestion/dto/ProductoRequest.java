package com.thiago.gestion.dto;

import com.thiago.gestion.domain.Categoria;
import com.thiago.gestion.domain.Marca;
import com.thiago.gestion.domain.Proveedor;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoRequest {

    @Size(min=10, max=50, message = "El nombre del producto debe estar entre 10 a 50 carácteres.")
    @NotBlank(message = "El nombre del producto no puede estar vacío.")
    private String nombre;

    @Size(min=5, max = 50, message = "El codigo de barras debe estar entre 10 a 50 carácteres.")
    private String codigoBarras;

    @NotNull(message = "El precio unitario del producto no puede estar vacío.")
    @DecimalMin(value = "0.00", message = "El precio unitario debe ser mayor que 0.")
    private BigDecimal precioUnitario;

    @NotNull(message = "El costo unitario del producto no puede estar vacío.")
    @DecimalMin(value = "0.00", message = "El costo unitario debe ser mayor a 0.")
    private BigDecimal costoUnitario;

    @Min(value = 1, message = "El stock debe ser mayor a 0.")
    @NotNull(message = "El stock del producto no puede estar vacío. ")
    private Integer stock;

    @NotNull(message = "La categoria no puede estar vacía.")
    private Long id_categoria;

    private Long id_proveedor;
    private Long id_marca;
}
