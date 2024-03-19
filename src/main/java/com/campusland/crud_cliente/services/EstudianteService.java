package com.campusland.crud_cliente.services;

import java.util.List;

import com.campusland.crud_cliente.repositories.entities.Estudiante;

public interface EstudianteService {
/* 
    List<Estudiante> finaAll();

    Estudiante findById(Long id); */

    Estudiante save (Estudiante student);

/*     void delete(Long id);

    Estudiante update(Long id,Estudiante student); */
    
}