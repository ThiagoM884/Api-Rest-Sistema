package com.thiago.gestion.mapper;

import com.thiago.gestion.domain.Proveedor;
import com.thiago.gestion.dto.ProveedorRequest;
import com.thiago.gestion.dto.ProveedorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {

    List<ProveedorResponse> proveedorListToProveedorResponseList(List<Proveedor> proveedores);
    ProveedorResponse proveedorToProveedorResponse(Proveedor proveedor);
    Proveedor proveedorRequestToProveedor(ProveedorRequest proveedorRequest);

    void actualizarProveedorDesdeDto(ProveedorRequest proveedorRequest, @MappingTarget Proveedor proveedor);

}
