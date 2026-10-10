package com.thiago.gestion.service;

import com.thiago.gestion.domain.Categoria;
import com.thiago.gestion.exception.ResourceNotFoundException;
import com.thiago.gestion.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements ICategoriaService{
    private final CategoriaRepository categoriaRepository;
    @Override
    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria buscarCategoriaPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontró la categoria con id: "+ id)
        );

        return categoria;
    }

    @Override
    public void borrarCategoriaPorId(Long id) {
        Categoria categoria = buscarCategoriaPorId(id);
        categoriaRepository.delete(categoria);
    }
}
