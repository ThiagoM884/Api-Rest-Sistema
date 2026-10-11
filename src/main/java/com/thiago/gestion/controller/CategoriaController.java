package com.thiago.gestion.controller;

import com.thiago.gestion.domain.Categoria;
import com.thiago.gestion.dto.CategoriaRequest;
import com.thiago.gestion.dto.CategoriaResponse;
import com.thiago.gestion.mapper.CategoriaMapper;
import com.thiago.gestion.service.ICategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final ICategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listarTodas() {
        List<CategoriaResponse> categoriaResponses = categoriaService.buscarTodas();
        return new ResponseEntity<>(categoriaResponses, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> buscarCategoriaPorId(@PathVariable Long id) {
        CategoriaResponse categoriaResponse = categoriaService.buscarCategoriaPorId(id);
        return new ResponseEntity<>(categoriaResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> guardarCategoria(@Valid @RequestBody CategoriaRequest catRequest) {
        CategoriaResponse categoriaResponse = categoriaService.guardarCategoria(catRequest);

        return new ResponseEntity<>(categoriaResponse, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarCategoriaPorId(@PathVariable Long id) {
        categoriaService.borrarCategoriaPorId(id);

        return ResponseEntity.noContent().build();
    }
}
