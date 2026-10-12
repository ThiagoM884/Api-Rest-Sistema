package com.thiago.gestion.service;

import com.thiago.gestion.domain.*;
import com.thiago.gestion.dto.ProductoRequest;
import com.thiago.gestion.dto.ProductoResponse;
import com.thiago.gestion.exception.ResourceNotFoundException;
import com.thiago.gestion.repository.*;
import com.thiago.gestion.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService{
    private final ProductoRepository productoRepository;
    private final SubcategoriaRepository subcategoriaRepository;
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
    public ProductoResponse actualizarProducto(Long id, ProductoRequest productoRequest) {
        Producto producto =  productoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No fue encontrado el producto con id: " + id));

        Subcategoria subcategoria = subcategoriaRepository
                .findById(productoRequest.getIdSubcategoria()).orElseThrow(
                        () -> new ResourceNotFoundException("No se encontró la subcategoría con id: " + productoRequest.getIdSubcategoria())
                );

        if(productoRequest.getIdProveedor() != null) {
            Proveedor proveedor = proveedorRepository
                    .findById(productoRequest.getIdProveedor()).orElseThrow(
                            () -> new ResourceNotFoundException("No se encontró el proveedor con id: "+ productoRequest.getIdProveedor())
                    );
            producto.setProveedor(proveedor);
        }


        if(productoRequest.getIdMarca() != null) {
            Marca marca = marcaRepository
                    .findById(productoRequest.getIdMarca()).orElseThrow(
                            () -> new ResourceNotFoundException("No se encontró la marca con id: "+ productoRequest.getIdMarca())
                    );
            producto.setMarca(marca);
        }



        productoMapper.actualizarProductoDesdeDto(productoRequest, producto);
        Producto productoActualizado = productoRepository.save(producto);
        ProductoResponse productoResponse = productoMapper.productoToProductoResponse(productoActualizado);
        return productoResponse;
    }

    @Override
    @Transactional
    public ProductoResponse guardarProducto(ProductoRequest productoRequest) {


        Subcategoria subcategoria = subcategoriaRepository
                .findById(productoRequest.getIdSubcategoria()).orElseThrow(
                        () -> new ResourceNotFoundException("No se encontró la subcategoría con id: " + productoRequest.getIdSubcategoria())
                );

        Producto producto = productoMapper.productoRequestToProducto(productoRequest);
        producto.setSubcategoria(subcategoria);

        if(productoRequest.getIdProveedor() != null) {
            Proveedor proveedor = proveedorRepository
                    .findById(productoRequest.getIdProveedor()).orElseThrow(
                            () -> new ResourceNotFoundException("No se encontró el proveedor con id: "+ productoRequest.getIdProveedor())
                    );
            producto.setProveedor(proveedor);
        }



        if(productoRequest.getIdMarca() != null) {
            Marca marca = marcaRepository
                    .findById(productoRequest.getIdMarca()).orElseThrow(
                            () -> new ResourceNotFoundException("No se encontró la marca con id: "+ productoRequest.getIdMarca())
                    );
            producto.setMarca(marca);
        }

        Producto productoGuardado =  productoRepository.save(producto);
        ProductoResponse productoResponse = productoMapper.productoToProductoResponse(productoGuardado);

        return productoResponse;
    }
}
