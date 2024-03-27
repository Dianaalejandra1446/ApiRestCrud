package com.campusland.crud_cliente.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campusland.crud_cliente.repositories.entities.ItemFactura;

public interface RepositoryItemFactura extends CrudRepository<ItemFactura
,Long> {
    
}
