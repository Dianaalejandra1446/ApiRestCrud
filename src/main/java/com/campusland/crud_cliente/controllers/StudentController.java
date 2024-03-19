package com.campusland.crud_cliente.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusland.crud_cliente.repositories.entities.Student;
import com.campusland.crud_cliente.services.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/student2")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService2;

    @PostMapping("/save")
    public Student save(@RequestBody Student student){
        return studentService2.save(student);
    }
}
