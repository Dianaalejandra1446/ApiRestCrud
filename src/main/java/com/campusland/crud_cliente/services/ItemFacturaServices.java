package com.campusland.crud_cliente.services;

import java.util.List;
import java.util.Optional;

import com.campusland.crud_cliente.Dto.ItemFacturaDTO;

public interface ItemFacturaServices {
    ItemFacturaDTO save(ItemFacturaDTO itemFactura);

    List<ItemFacturaDTO> findAll();

    Optional<ItemFacturaDTO> findById(Long id);
}
