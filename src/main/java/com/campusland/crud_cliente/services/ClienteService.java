package com.campusland.crud_cliente.services;


import java.util.List;

import com.campusland.crud_cliente.repositories.entities.Cliente;
import com.campusland.crud_cliente.repositories.entities.Factura;
import com.campusland.crud_cliente.repositories.entities.Producto;


public interface ClienteService {
    List<Cliente> finaAll();

    Cliente finById(Long id);

    Cliente save(Cliente cliente);

    void delete(Long id);

    /* void update(Long id,Cliente clienteActualizado); */
    Cliente update(Long id,Cliente cliente);

    Cliente findByEmail(String email);

    Factura findFacturaById (Long id);

    List<Factura> finFacturaAll();

    Factura save(Factura factura);

    void deleteFacturaBydId(Long id);

    List<Producto> findProductoByNombre(String term);
}
