package com.campusland.crud_cliente.services.impl;

import com.campusland.crud_cliente.repositories.entities.Student;
import com.campusland.crud_cliente.repositories.entities.University;
import com.campusland.crud_cliente.services.StudentService;

import lombok.AllArgsConstructor;

import java.util.List; // Importa la clase List

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Override
    public Student save(Student student2) {
        University university = student2.getUniversity();
        if (university != null) {
            List<Student> students = university.getStudents(); 
            students.add(student2); 
            university.setStudents(students);
        }
        return student2;
    }
}
