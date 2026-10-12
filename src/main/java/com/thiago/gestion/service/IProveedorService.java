package com.thiago.gestion.service;

import com.thiago.gestion.dto.ProveedorRequest;
import com.thiago.gestion.dto.ProveedorResponse;

import java.util.List;

public interface IProveedorService {

    List<ProveedorResponse> buscarTodos();
    ProveedorResponse buscarProveedorPorId(Long id);
    void borrarProveedorPorId(Long id);
    ProveedorResponse guardarProveedor(ProveedorRequest proveedorRequest);
    ProveedorResponse actualizarProducto(Long id, ProveedorRequest proveedorRequest);
}
