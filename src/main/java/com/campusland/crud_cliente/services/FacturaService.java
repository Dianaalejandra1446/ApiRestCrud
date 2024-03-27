package com.campusland.crud_cliente.services;

import java.util.List;

import com.campusland.crud_cliente.Dto.FacturaDTO;

public interface FacturaService {
    FacturaDTO save(FacturaDTO facturaDTO);

    List<FacturaDTO> findAll();

}
