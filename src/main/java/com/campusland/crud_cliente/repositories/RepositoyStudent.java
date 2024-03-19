package com.campusland.crud_cliente.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campusland.crud_cliente.repositories.entities.Student;

public interface RepositoyStudent extends CrudRepository<Student,Long> {
    
}
