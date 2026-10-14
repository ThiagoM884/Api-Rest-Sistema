package com.thiago.gestion.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="proveedores",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_nombre_proveedor", columnNames = "nombre"),
                @UniqueConstraint(name = "uk_email_proveedor", columnNames = "email")
        })

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;

    @Column(name="email", length = 50)
    private String email;

    @Column(name="direccion", length = 255)
    private String direccion;


    @OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY)
    private List<Producto> productos;

}
