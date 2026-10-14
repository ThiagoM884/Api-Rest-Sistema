package com.thiago.gestion.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "subcategorias", uniqueConstraints = @UniqueConstraint(name = "uk_nombre_subcategoria", columnNames = "nombre"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_categoria",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_subcategoria_categoria"))
    private Categoria categoria;

    @OneToMany(mappedBy = "subcategoria", fetch = FetchType.LAZY)
    private List<Producto> productos;


}
