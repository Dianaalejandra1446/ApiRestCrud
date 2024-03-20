package com.campusland.crud_cliente.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.campusland.crud_cliente.repositories.entities.Producto;
import java.util.List;


public interface RepositoryProducto extends CrudRepository<Producto,Long>{
    // Hace referencia al objeto producto
    @Query("select p from Producto p where p.nombre like %?1%")
    List<Producto> findByNombre(String term);

    List<Producto> findByNombreContainingIgnoreCase(String term);
}
