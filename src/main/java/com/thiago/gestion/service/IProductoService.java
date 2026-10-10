package com.thiago.gestion.service;

import com.thiago.gestion.domain.Producto;
import com.thiago.gestion.dto.ProductoRequest;
import com.thiago.gestion.dto.ProductoResponse;

import java.util.List;

public interface IProductoService {
    List<ProductoResponse> buscarTodos();
    ProductoResponse buscarProductoPorId(Long id);
    void borrarProductoPorId(Long id);
    ProductoResponse guardarProducto(ProductoRequest productoRequest);
}
