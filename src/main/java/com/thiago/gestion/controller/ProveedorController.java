package com.thiago.gestion.controller;


import com.thiago.gestion.dto.ProductoResponse;
import com.thiago.gestion.dto.ProveedorRequest;
import com.thiago.gestion.dto.ProveedorResponse;
import com.thiago.gestion.repository.ProveedorRepository;
import com.thiago.gestion.service.IProveedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final IProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorResponse>> listarTodos() {
        List<ProveedorResponse> proveedorResponses = proveedorService.buscarTodos();

        return new ResponseEntity<>(proveedorResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponse> buscarProveedorPorId(@PathVariable Long id) {
        ProveedorResponse proveedorResponse = proveedorService.buscarProveedorPorId(id);

        return new ResponseEntity<>(proveedorResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProveedorResponse> guardarProveedor(@Valid @RequestBody ProveedorRequest proveedorRequest) {
        ProveedorResponse proveedorResponse = proveedorService.guardarProveedor(proveedorRequest);

        return new ResponseEntity<>(proveedorResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorResponse> actualizarProducto(@PathVariable Long id,
                                                                @Valid @RequestBody ProveedorRequest proveedorRequest) {
        ProveedorResponse proveedorResponse = proveedorService.actualizarProducto(id, proveedorRequest);

        return new ResponseEntity<>(proveedorResponse, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarProveedor(@PathVariable Long id) {
        proveedorService.borrarProveedorPorId(id);

        return ResponseEntity.noContent().build();
    }
}
