package com.campusland.crud_cliente.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campusland.crud_cliente.repositories.RepositoryProducto;
import com.campusland.crud_cliente.repositories.entities.Producto;
import com.campusland.crud_cliente.services.ProductoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private RepositoryProducto repositoryProducto;


    @Override
    @Transactional(readOnly=true)
    public List<Producto> findAll() {
        return (List<Producto>)repositoryProducto.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Producto findByCodigo(Long codigo) {
        return repositoryProducto.findById(codigo).orElse(null);
    }

}
