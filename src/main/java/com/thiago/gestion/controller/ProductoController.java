package com.thiago.gestion.controller;

import com.thiago.gestion.domain.Categoria;
import com.thiago.gestion.domain.Producto;
import com.thiago.gestion.dto.ProductoRequest;
import com.thiago.gestion.dto.ProductoResponse;
import com.thiago.gestion.mapper.ProductoMapper;
import com.thiago.gestion.service.ICategoriaService;
import com.thiago.gestion.service.IProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> buscarTodos() {

        List<ProductoResponse> productosResponses = productoService.buscarTodos();
        return new ResponseEntity<>(productosResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> buscarPorId( @PathVariable Long id) {
        ProductoResponse productoBuscado = productoService.buscarProductoPorId(id);

        return new ResponseEntity<>(productoBuscado,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoResponse> guardarProducto(@Valid @RequestBody ProductoRequest productoRequest) {

        ProductoResponse productoResponse = productoService.guardarProducto(productoRequest);
        return new ResponseEntity<>(productoResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarProducto(@PathVariable Long id) {
        productoService.borrarProductoPorId(id);

        return ResponseEntity.noContent().build();
    }
}
