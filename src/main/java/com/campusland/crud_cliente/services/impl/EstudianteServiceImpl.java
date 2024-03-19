package com.campusland.crud_cliente.services.impl;


import org.springframework.stereotype.Service;

import com.campusland.crud_cliente.repositories.RepositoryEstudiante;
import com.campusland.crud_cliente.repositories.entities.Estudiante;
import com.campusland.crud_cliente.repositories.entities.Tuition;
import com.campusland.crud_cliente.services.EstudianteService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EstudianteServiceImpl implements EstudianteService{
    private RepositoryEstudiante repositoryEstudiante;
    
    @Override
    @Transactional
    public Estudiante save(Estudiante student) {
        Tuition tuition = student.getTuition();
        if (tuition!= null) {
            tuition.setEstudiante(student);
        }
        return repositoryEstudiante.save(student);
    }
    
}
