package com.thiago.gestion.controller;

import com.thiago.gestion.domain.Subcategoria;
import com.thiago.gestion.dto.SubcategoriaRequest;
import com.thiago.gestion.dto.SubcategoriaResponse;
import com.thiago.gestion.service.ISubcategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subcategorias")
@RequiredArgsConstructor
public class SubcategoriaController {

    private final ISubcategoriaService subcategoriaService;

    @GetMapping
    public ResponseEntity<List<SubcategoriaResponse>> listarTodas() {
        List<SubcategoriaResponse> subcategoriaResponses = subcategoriaService.buscarTodas();
        return new ResponseEntity<>(subcategoriaResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubcategoriaResponse> crearSubcategoria(@Valid @RequestBody SubcategoriaRequest subcategoriaRequest) {
        SubcategoriaResponse subcategoriaResponse = subcategoriaService.guardarSubcategoria(subcategoriaRequest);

        return new ResponseEntity<>(subcategoriaResponse,HttpStatus.CREATED);
    }
}
