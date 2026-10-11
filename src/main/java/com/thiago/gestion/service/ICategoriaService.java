package com.thiago.gestion.service;

import com.thiago.gestion.domain.Categoria;
import com.thiago.gestion.dto.CategoriaRequest;
import com.thiago.gestion.dto.CategoriaResponse;

import java.util.List;

public interface ICategoriaService {

    List<CategoriaResponse> buscarTodas();
    CategoriaResponse guardarCategoria(CategoriaRequest categoria);
    CategoriaResponse buscarCategoriaPorId(Long id);
    void borrarCategoriaPorId(Long id);
}
