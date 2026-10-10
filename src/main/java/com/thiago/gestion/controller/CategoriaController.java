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
    private final CategoriaMapper categoriaMapper;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listarTodas() {
        List<CategoriaResponse> categoriaResponses = categoriaMapper.categoriaListToCategoriaResponseList(
                        categoriaService.buscarTodas());

        return new ResponseEntity<>(categoriaResponses, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CategoriaResponse> guardarCategoria(@Valid @RequestBody CategoriaRequest catRequest) {
        Categoria categoriaMapeada = categoriaMapper.categoriaRequestToCategoria(catRequest);
        Categoria categoriaGuardada = categoriaService.guardarCategoria(categoriaMapeada);
        CategoriaResponse categoriaResponse = categoriaMapper.categoriaToCategoriaResponse(categoriaGuardada);

        return new ResponseEntity<>(categoriaResponse, HttpStatus.CREATED);

    }
}
