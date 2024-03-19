package com.campusland.crud_cliente.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campusland.crud_cliente.repositories.entities.Estudiante;

public interface RepositoryEstudiante extends CrudRepository<Estudiante,Long>{
    
}