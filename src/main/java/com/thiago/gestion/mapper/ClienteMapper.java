package com.thiago.gestion.mapper;

import com.thiago.gestion.domain.Cliente;
import com.thiago.gestion.dto.ClienteRequest;
import com.thiago.gestion.dto.ClienteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    Cliente clienteRequestToCliente(ClienteRequest clienteRequest);

    List<ClienteResponse> clienteListToClienteResponseList(List<Cliente> clientes);
    ClienteResponse clienteToClienteResponse(Cliente cliente);

}
