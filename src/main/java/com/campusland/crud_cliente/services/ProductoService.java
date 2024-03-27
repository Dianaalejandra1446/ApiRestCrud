package com.campusland.crud_cliente.services;

import java.util.List;

import com.campusland.crud_cliente.repositories.entities.Producto;

public interface ProductoService {
    List<Producto> findAll();

    Producto findByCodigo(Long codigo);
}
