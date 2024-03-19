package com.campusland.crud_cliente.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusland.crud_cliente.repositories.entities.University;
import com.campusland.crud_cliente.services.UniversityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/university")
@AllArgsConstructor
public class UniversityController {
        private UniversityService universityService;

    @PostMapping("/save")
    public University save(@RequestBody University university){
        return universityService.save(university);
    }
}
