package com.thiago.gestion.controller;

import com.thiago.gestion.dto.ClienteRequest;
import com.thiago.gestion.dto.ClienteResponse;
import com.thiago.gestion.service.IClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final IClienteService clienteService;


    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listarTodos() {
        List<ClienteResponse> clienteResponseList = clienteService.listarClientes();
        return new ResponseEntity<>(clienteResponseList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> crearCliente(@Valid @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse clienteResponse = clienteService.guardarCliente(clienteRequest);

        return new ResponseEntity<>(clienteResponse, HttpStatus.CREATED);
    }
}
