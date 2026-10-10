package com.thiago.gestion.service;

import com.thiago.gestion.domain.Categoria;

import java.util.List;

public interface ICategoriaService {

    List<Categoria> buscarTodas();
    Categoria guardarCategoria(Categoria categoria);
    Categoria buscarCategoriaPorId(Long id);
    void borrarCategoriaPorId(Long id);
}
