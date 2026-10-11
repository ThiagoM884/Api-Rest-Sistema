package com.thiago.gestion.repository;

import com.thiago.gestion.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    Optional<Categoria> findByNombre(String nombre);
}
