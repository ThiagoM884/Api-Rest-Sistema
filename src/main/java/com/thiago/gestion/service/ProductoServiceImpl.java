package com.thiago.gestion.service;

import com.thiago.gestion.domain.Categoria;
import com.thiago.gestion.domain.Marca;
import com.thiago.gestion.domain.Producto;
import com.thiago.gestion.domain.Proveedor;
import com.thiago.gestion.dto.ProductoRequest;
import com.thiago.gestion.dto.ProductoResponse;
import com.thiago.gestion.exception.ResourceNotFoundException;
import com.thiago.gestion.repository.MarcaRepository;
import com.thiago.gestion.mapper.ProductoMapper;
import com.thiago.gestion.repository.ProveedorRepository;
import com.thiago.gestion.repository.CategoriaRepository;
import com.thiago.gestion.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService{
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProveedorRepository proveedorRepository;
    private final MarcaRepository marcaRepository;

    private final ProductoMapper productoMapper;

    @Override
    public List<ProductoResponse> buscarTodos() {

        List<Producto> productos =  productoRepository.findAll();
        List<ProductoResponse> productosResponse = productoMapper.productoListToProductoResponseList(productos);

        return productosResponse;
    }

    @Override
    public ProductoResponse buscarProductoPorId(Long id) {
        Producto producto =  productoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No fue encontrado el producto con id: " + id));

        ProductoResponse productoResponse = productoMapper.productoToProductoResponse(producto);
        return productoResponse;
    }

    @Override
    public void borrarProductoPorId(Long id) {
        Producto productoBuscado = productoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No fue encontrado el producto con id: " + id)
        );
        productoRepository.delete(productoBuscado);

    }

    @Override
    @Transactional
    public ProductoResponse guardarProducto(ProductoRequest productoRequest) {
        Categoria categoria = categoriaRepository
                .findById(productoRequest.getId_categoria()).orElseThrow(
                        () -> new ResourceNotFoundException("No se encontró la categoria con id: " + productoRequest.getId_categoria())
                );

        Producto producto = productoMapper.productoRequestToProducto(productoRequest);
        producto.setCategoria(categoria);

        if(productoRequest.getId_proveedor() != null) {
            Proveedor proveedor = proveedorRepository
                    .findById(productoRequest.getId_proveedor()).orElseThrow(
                            () -> new ResourceNotFoundException("No se encontró el proveedor con id: "+ productoRequest.getId_proveedor())
                    );
            producto.setProveedor(proveedor);
        }

        if(productoRequest.getId_marca() != null) {
            Marca marca = marcaRepository
                    .findById(productoRequest.getId_marca()).orElseThrow(
                            () -> new ResourceNotFoundException("No se encontró la marca con id: "+ productoRequest.getId_marca())
                    );
            producto.setMarca(marca);
        }

        Producto productoGuardado =  productoRepository.save(producto);
        ProductoResponse productoResponse = productoMapper.productoToProductoResponse(productoGuardado);

        return productoResponse;
    }
}
