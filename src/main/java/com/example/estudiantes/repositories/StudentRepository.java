package com.example.estudiantes.repositories;

import com.example.estudiantes.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    boolean existsByEmail(String email);
}
