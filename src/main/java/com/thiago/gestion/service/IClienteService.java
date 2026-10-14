package com.thiago.gestion.service;

import com.thiago.gestion.dto.ClienteRequest;
import com.thiago.gestion.dto.ClienteResponse;

import java.util.List;

public interface IClienteService {

    List<ClienteResponse> listarClientes();
    ClienteResponse guardarCliente(ClienteRequest clienteRequest);
}
