package com.thiago.gestion.mapper;


import com.thiago.gestion.domain.Producto;
import com.thiago.gestion.dto.ProductoRequest;
import com.thiago.gestion.dto.ProductoResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(target = "idCategoria", source = "categoria.id")
    @Mapping(target = "idProveedor", source = "proveedor.id")
    @Mapping(target = "idMarca", source = "marca.id")
    List<ProductoResponse> productoListToProductoResponseList(List<Producto> productos);

    @Mapping(target="categoria", ignore = true)
    @Mapping(target="marca", ignore = true)
    @Mapping(target = "proveedor", ignore = true)
    Producto productoRequestToProducto(ProductoRequest productoRequest);

    @Mapping(target = "idCategoria", source = "categoria.id")
    @Mapping(target = "idProveedor", source = "proveedor.id")
    @Mapping(target = "idMarca", source = "marca.id")
    ProductoResponse productoToProductoResponse(Producto producto);


    // Mapper de reemplazo parcial, porque ignoramos las propiedades Nulas.
    // @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void actualizarProductoDesdeDto(ProductoRequest productoRequest, @MappingTarget Producto producto);
}
