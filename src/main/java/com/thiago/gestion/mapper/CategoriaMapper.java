package com.thiago.gestion.mapper;

import com.thiago.gestion.domain.Categoria;
import com.thiago.gestion.dto.CategoriaRequest;
import com.thiago.gestion.dto.CategoriaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    List<CategoriaResponse> categoriaListToCategoriaResponseList(List<Categoria> categoriaList);

    @Mapping(target="productos", ignore = true)
    @Mapping(target = "id", ignore = true)
    Categoria categoriaRequestToCategoria(CategoriaRequest categoriaRequest);


    CategoriaResponse categoriaToCategoriaResponse(Categoria categoria);
}
