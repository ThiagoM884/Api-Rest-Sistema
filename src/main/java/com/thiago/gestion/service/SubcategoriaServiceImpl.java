package com.thiago.gestion.service;

import com.thiago.gestion.domain.Categoria;
import com.thiago.gestion.domain.Subcategoria;
import com.thiago.gestion.dto.SubcategoriaRequest;
import com.thiago.gestion.dto.SubcategoriaResponse;
import com.thiago.gestion.exception.ResourceNotFoundException;
import com.thiago.gestion.mapper.SubcategoriaMapper;
import com.thiago.gestion.repository.CategoriaRepository;
import com.thiago.gestion.repository.SubcategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubcategoriaServiceImpl implements ISubcategoriaService {

    private final SubcategoriaRepository subcategoriaRepository;
    private final CategoriaRepository categoriaRepository;
    private final SubcategoriaMapper subcategoriaMapper;

    @Override
    public List<SubcategoriaResponse> buscarTodas() {
        List<Subcategoria> subcategorias = subcategoriaRepository.findAll();
        List<SubcategoriaResponse> subcategoriaResponses = subcategoriaMapper.subcategoriaListToSubcategoriaResponse(subcategorias);

        return subcategoriaResponses;
    }

    @Override
    public SubcategoriaResponse guardarSubcategoria(SubcategoriaRequest subcategoriaRequest) {
        Categoria categoria = categoriaRepository.findById(subcategoriaRequest.getIdCategoria()).orElseThrow(
                () -> new ResourceNotFoundException("No se encontró la categoría con id: " + subcategoriaRequest.getIdCategoria())
        );
        Subcategoria subcategoria = subcategoriaMapper.subcategoriaRequestToSubcategoria(subcategoriaRequest);
        subcategoria.setCategoria(categoria);

        Subcategoria subcategoriaGuardada = subcategoriaRepository.save(subcategoria);
        return subcategoriaMapper.subcategoriaToSubcategoriaResponse(subcategoriaGuardada);
    }

    @Override
    public SubcategoriaResponse buscarSubcategoriaPorId(Long id) {
        Subcategoria subcategoria = subcategoriaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontró la subcategoria con id: "+ id)
        );
        SubcategoriaResponse subcategoriaResponse = subcategoriaMapper.subcategoriaToSubcategoriaResponse(subcategoria);

        return subcategoriaResponse;
    }

    @Override
    public void borrarSubcategoriaPorId(Long id) {
        Subcategoria subcategoria = subcategoriaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontró la subcategoria con id: "+ id)
        );
        subcategoriaRepository.delete(subcategoria);
    }
}
