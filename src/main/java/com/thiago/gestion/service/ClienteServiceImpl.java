package com.thiago.gestion.service;

import com.thiago.gestion.domain.Cliente;
import com.thiago.gestion.dto.ClienteRequest;
import com.thiago.gestion.dto.ClienteResponse;
import com.thiago.gestion.mapper.ClienteMapper;
import com.thiago.gestion.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public List<ClienteResponse> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        return clienteMapper.clienteListToClienteResponseList(clientes);
    }

    @Override
    @Transactional
    public ClienteResponse guardarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = clienteMapper.clienteRequestToCliente(clienteRequest);

        Cliente clienteGuardado = clienteRepository.save(cliente);
        return clienteMapper.clienteToClienteResponse(clienteGuardado);

    }
}
