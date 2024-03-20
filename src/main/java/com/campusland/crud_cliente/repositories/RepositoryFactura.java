package com.campusland.crud_cliente.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campusland.crud_cliente.repositories.entities.Factura;

public interface RepositoryFactura extends CrudRepository<Factura,Long>{
    
}
