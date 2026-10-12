package com.thiago.gestion.service;

import com.thiago.gestion.dto.CategoriaRequest;
import com.thiago.gestion.dto.CategoriaResponse;
import com.thiago.gestion.dto.SubcategoriaRequest;
import com.thiago.gestion.dto.SubcategoriaResponse;

import java.util.List;

public interface ISubcategoriaService {

    List<SubcategoriaResponse> buscarTodas();
    SubcategoriaResponse guardarSubcategoria(SubcategoriaRequest subcategoriaRequest);
    SubcategoriaResponse buscarSubcategoriaPorId(Long id);
    void borrarSubcategoriaPorId(Long id);
}
