package com.campusland.crud_cliente.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.campusland.crud_cliente.Configuracion.FacturaDTOConverte;
import com.campusland.crud_cliente.Dto.FacturaDTO;
import com.campusland.crud_cliente.repositories.RepositoryFactura;
import com.campusland.crud_cliente.repositories.RepositoryProducto;
import com.campusland.crud_cliente.repositories.entities.Producto;
import com.campusland.crud_cliente.services.FacturaService;

import jakarta.transaction.Transactional;

public class FacturaServiceImpl implements FacturaService{
    @Autowired
    private RepositoryFactura repositoryFactura;

    @Autowired
    private RepositoryProducto repositoryProducto;

    @Autowired
    private FacturaDTOConverte convert;

    @Override
    public FacturaDTO save(FacturaDTO facturaDTO) {
        Optional<Producto> producOptional= repositoryProducto.findById(facturaDTO);
    }
    @Override
    @Transactional
    public List<FacturaDTO> findAll() {
        return null;
    }
    @Override
    public Optional<FacturaDTO> findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    
}
