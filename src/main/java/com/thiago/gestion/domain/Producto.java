package com.thiago.gestion.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="nombre", nullable = false, unique = true, length = 50)
    private String nombre;

    @Column(name="codigo_barras", length = 50)
    private String codigoBarras;

    @Column(name="precio_unitario", nullable = false,  precision = 38, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name="costo_unitario", nullable = false,  precision = 38, scale = 2)
    private BigDecimal costoUnitario;

    @Column(name="stock", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name="id_proveedor")
    private Proveedor proveedor;


    @ManyToOne
    @JoinColumn(name="id_marca")
    private Marca marca;

}
