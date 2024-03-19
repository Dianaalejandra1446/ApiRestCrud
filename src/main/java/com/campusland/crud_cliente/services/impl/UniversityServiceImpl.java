package com.campusland.crud_cliente.services.impl;

import org.springframework.stereotype.Service;

import com.campusland.crud_cliente.repositories.RepositoryUniversity;
import com.campusland.crud_cliente.repositories.entities.University;
import com.campusland.crud_cliente.services.UniversityService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class UniversityServiceImpl implements UniversityService{
    private RepositoryUniversity repositoryUniversity;
    @Override
    public University save(University university) {
        return repositoryUniversity.save(university);
    }
    
}
