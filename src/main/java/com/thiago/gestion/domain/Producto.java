package com.thiago.gestion.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="productos",
        uniqueConstraints = @UniqueConstraint(name="uk_nombre_producto", columnNames = "nombre"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="nombre", nullable = false, length = 50)
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
    @JoinColumn(name = "id_subcategoria",
            foreignKey = @ForeignKey(name = "fk_producto_subcategoria"))
    private Subcategoria subcategoria;

    @ManyToOne
    @JoinColumn(name="id_proveedor",
            foreignKey = @ForeignKey(name = "fk_producto_proveedor"))
    private Proveedor proveedor;


    @ManyToOne
    @JoinColumn(name="id_marca",
            foreignKey = @ForeignKey(name="fk_producto_marca"))
    private Marca marca;

}
