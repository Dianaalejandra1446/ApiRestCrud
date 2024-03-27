package com.campusland.crud_cliente.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusland.crud_cliente.repositories.entities.Producto;
import com.campusland.crud_cliente.services.ProductoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/producto")
@AllArgsConstructor
public class ProductoController {
    private ProductoService productoService;

    @GetMapping("/ver-productos")
    public List<Producto> findAll(){
        return productoService.findAll();
    }

    @GetMapping("/{codigo}")
    public Producto findByCodigo(@PathVariable Long codigo){
        return productoService.findByCodigo(codigo);
    }

}
