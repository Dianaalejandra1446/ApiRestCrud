package com.campusland.crud_cliente.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusland.crud_cliente.Configuracion.ItemFacturaDTOConverte;
import com.campusland.crud_cliente.Dto.ItemFacturaDTO;
import com.campusland.crud_cliente.repositories.RepositoryItemFactura;
import com.campusland.crud_cliente.repositories.entities.ItemFactura;
import com.campusland.crud_cliente.services.ItemFacturaServices;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemFacturaServiceImpl implements ItemFacturaServices {

    @Autowired
    // Repository Item Factura
    private RepositoryItemFactura itemFacturaRepository;

    @Autowired
    // Convertir a DTO
    private ItemFacturaDTOConverte convert;

    @Override
    public List<ItemFacturaDTO> findAll() {
        //  Sobreescribir el metodo findAll
        List<ItemFactura> itemFacturaEntity =(List<ItemFactura>) itemFacturaRepository.findAll();
        // Lista de entidades
        List<ItemFacturaDTO> itemFacturaDTO = new ArrayList<>();

        for (ItemFactura itemF : itemFacturaEntity) {
            itemFacturaDTO.add(convert.converItemFacturaDTO(itemF));
        }
        return itemFacturaDTO;
    }

    
}
