package com.campusland.crud_cliente.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.campusland.crud_cliente.Configuracion.FacturaDTOConverte;
import com.campusland.crud_cliente.Dto.FacturaDTO;
import com.campusland.crud_cliente.repositories.RepositoryCliente;
import com.campusland.crud_cliente.repositories.RepositoryFactura;
import com.campusland.crud_cliente.repositories.entities.Cliente;
import com.campusland.crud_cliente.repositories.entities.Factura;
import com.campusland.crud_cliente.services.FacturaService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class FacturaServiceImpl implements FacturaService{
    @Autowired
    // Añadir repositoryFactura
    private RepositoryFactura repositoryFactura;

    @Autowired
    // Repository Cliente
    private RepositoryCliente repositoryCliente;

    @Autowired
    // Convertir a DTO
    private FacturaDTOConverte convert;

    @Override
    public FacturaDTO save(FacturaDTO facturaDTO) {
        // Si esta el id del cliente se convierte a DTO
        Optional<Cliente>clienteOptional = repositoryCliente.findById(facturaDTO.getCliente_id());

        if (clienteOptional.isPresent()) {
            Factura facturaEntity = convert.convertFacturaDTO(facturaDTO);
            facturaEntity.setCliente(clienteOptional.get());
            repositoryFactura.save(facturaEntity);
            return convert.conveFacturaDTO(facturaEntity);
        }

        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FacturaDTO> findAll() {
        List<Factura> facturaEntity = (List<Factura>) repositoryFactura.findAll();
        return facturaEntity.stream()
                            .map(factura -> convert.conveFacturaDTO(factura))
                            .toList();
    }

    
}
