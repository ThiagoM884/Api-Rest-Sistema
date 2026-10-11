package com.thiago.gestion.service;

import com.thiago.gestion.domain.Categoria;
import com.thiago.gestion.dto.CategoriaRequest;
import com.thiago.gestion.dto.CategoriaResponse;
import com.thiago.gestion.exception.ResourceNotFoundException;
import com.thiago.gestion.mapper.CategoriaMapper;
import com.thiago.gestion.repository.CategoriaRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements ICategoriaService{

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;
    @Override
    public List<CategoriaResponse> buscarTodas() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaResponse> categoriaResponses = categoriaMapper.categoriaListToCategoriaResponseList(categorias);

        return categoriaResponses;
    }

    @Override
    public CategoriaResponse guardarCategoria(CategoriaRequest categoriaRequest) {

        Categoria categoriaEncontrada = categoriaRepository
                .findByNombre(categoriaRequest.getNombre()).orElse(null);
        if(categoriaEncontrada == null) {
            Categoria categoriaMapeada = categoriaMapper.categoriaRequestToCategoria(categoriaRequest);
            Categoria categoriaGuardada = categoriaRepository.save(categoriaMapeada);
            CategoriaResponse categoriaResponse = categoriaMapper.categoriaToCategoriaResponse(categoriaGuardada);
            return categoriaResponse;
        } else {
            throw new EntityExistsException("Ya se encuentra la categoria con nombre: " + categoriaRequest.getNombre());
        }





    }

    @Override
    public CategoriaResponse buscarCategoriaPorId(Long id) {
        Categoria categoriaBuscada = categoriaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontró la categoria con id: "+ id)
        );

        CategoriaResponse categoriaResponse = categoriaMapper.categoriaToCategoriaResponse(categoriaBuscada);

        return categoriaResponse;
    }

    @Override
    public void borrarCategoriaPorId(Long id) {
        Categoria categoriaBuscada = categoriaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontró la categoria con id: "+ id)
        );
        categoriaRepository.delete(categoriaBuscada);
    }
}
