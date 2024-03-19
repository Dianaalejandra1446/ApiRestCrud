package com.campusland.crud_cliente.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusland.crud_cliente.repositories.entities.Estudiante;
import com.campusland.crud_cliente.services.EstudianteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class EstudianteController {
    private EstudianteService studentService;

    @PostMapping("/")
    public Estudiante save(@RequestBody Estudiante student){
        return studentService.save(student);
    }
}
