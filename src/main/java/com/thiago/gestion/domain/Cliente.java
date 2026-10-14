package com.thiago.gestion.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


@Entity
@Table(name="clientes",
        uniqueConstraints = {
        @UniqueConstraint(name = "uk_cliente_email", columnNames = "email"),
        @UniqueConstraint(name = "uk_cliente_dni", columnNames = "dni"),
        @UniqueConstraint(name = "uk_cliente_cuit", columnNames = "cuit"),
        @UniqueConstraint(name = "uk_cliente_razonsocial", columnNames = "razon_social")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCliente tipoCliente;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "fecha_alta", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDate fechaAlta;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "dni", length = 11)
    private String dni;

    @Column(name = "nombre", length = 255)
    private String nombre;

    @Column(name = "apellido", length = 255)
    private String apellido;

    @Column(name = "cuit")
    private String cuit;

    @Column(name = "razon_social", length = 255)
    private String razonSocial;
}
