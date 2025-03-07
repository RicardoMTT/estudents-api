package com.example.estudiantes.services;

import com.example.estudiantes.entities.Student;
import com.example.estudiantes.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> all() {
        return repository.findAll();
    }

    public Student save(Student estudiante) {
        if (repository.existsByEmail(estudiante.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El email ya está registrado");
        }
        return repository.save(estudiante);
    }

    public Student getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Estudiante no encontrado"));
    }

    public Student update(Integer id, Student student) {
        Student existingStudent = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudiante no encontrado"));

        existingStudent.setNombre(student.getNombre());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setApellido(student.getApellido());
        existingStudent.setCreditor(student.getCreditor());
        existingStudent.setSemestre(student.getSemestre());
        existingStudent.setPromedio(student.getPromedio());

        return repository.save(existingStudent);
    }

    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudiante no encontrado");
        }
        repository.deleteById(id);
    }

}
