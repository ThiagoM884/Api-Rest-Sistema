package com.thiago.gestion.mapper;

import com.thiago.gestion.domain.Subcategoria;
import com.thiago.gestion.dto.SubcategoriaRequest;
import com.thiago.gestion.dto.SubcategoriaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubcategoriaMapper {

    @Mapping(target = "idCategoria", source = "categoria.id")
    SubcategoriaResponse subcategoriaToSubcategoriaResponse(Subcategoria subcategoria);

    @Mapping(target = "categoria", ignore = true)
    Subcategoria subcategoriaRequestToSubcategoria (SubcategoriaRequest subcategoriaRequest);


    @Mapping(target = "idCategoria", source = "categoria.id")
    List<SubcategoriaResponse> subcategoriaListToSubcategoriaResponse(List<Subcategoria> subcategoriaList);

    void actualizarSubcategoriaDesdeDto(SubcategoriaRequest subcategoriaRequest, @MappingTarget Subcategoria subcategoria);
}
