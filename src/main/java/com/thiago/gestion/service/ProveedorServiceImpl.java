package com.thiago.gestion.service;

import com.thiago.gestion.domain.Proveedor;
import com.thiago.gestion.dto.ProveedorRequest;
import com.thiago.gestion.dto.ProveedorResponse;
import com.thiago.gestion.exception.ResourceNotFoundException;
import com.thiago.gestion.mapper.ProveedorMapper;
import com.thiago.gestion.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements IProveedorService {

    private final ProveedorRepository proveedorRepository;
    private final ProveedorMapper proveedorMapper;

    @Override
    public List<ProveedorResponse> buscarTodos() {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        List<ProveedorResponse> proveedorResponses = proveedorMapper.proveedorListToProveedorResponseList(proveedores);

        return proveedorResponses;
    }

    @Override
    public ProveedorResponse buscarProveedorPorId(Long id) {
        Proveedor proveedor = proveedorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontro el proveedor con id: " + id)
        );

        ProveedorResponse proveedorResponse = proveedorMapper.proveedorToProveedorResponse(proveedor);
        return proveedorResponse;
    }

    @Override
    @Transactional
    public void borrarProveedorPorId(Long id) {
        Proveedor proveedor = proveedorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontro el proveedor con id: " + id)
        );
        proveedorRepository.delete(proveedor);
    }

    @Override
    @Transactional
    public ProveedorResponse guardarProveedor(ProveedorRequest proveedorRequest) {
        Proveedor proveedorMapeado = proveedorMapper.proveedorRequestToProveedor(proveedorRequest);
        Proveedor proveedorGuardado = proveedorRepository.save(proveedorMapeado);
        ProveedorResponse proveedorResponse = proveedorMapper.proveedorToProveedorResponse(proveedorGuardado);

        return proveedorResponse;
    }

    @Override
    @Transactional
    public ProveedorResponse actualizarProducto(Long id, ProveedorRequest proveedorRequest) {
        Proveedor proveedor = proveedorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontro el proveedor con id: " + id)
        );
        proveedorMapper.actualizarProveedorDesdeDto(proveedorRequest, proveedor);
        ProveedorResponse proveedorResponse = proveedorMapper.proveedorToProveedorResponse(proveedor);

        return proveedorResponse;
    }
}
