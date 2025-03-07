package com.example.estudiantes.services;

import com.example.estudiantes.entities.Student;
import com.example.estudiantes.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentService service;

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setId(1);
        student.setNombre("Ricardo");
        student.setApellido("Tovar");
        student.setEmail("ricardo.tovar@example.com");
    }

    @Test
    void testAll_ShouldReturnListOfStudents() {
        when(repository.findAll()).thenReturn(List.of(student));
        List<Student> students = service.all();
        assertFalse(students.isEmpty());
        assertEquals(1, students.size());
    }

    @Test
    void testSave_ShouldReturnSavedStudent() {
        when(repository.existsByEmail(student.getEmail())).thenReturn(false);
        when(repository.save(student)).thenReturn(student);
        Student savedStudent = service.save(student);
        assertNotNull(savedStudent);
        assertEquals("Ricardo", savedStudent.getNombre());
    }

    @Test
    void testSave_ShouldThrowExceptionWhenEmailExists() {
        when(repository.existsByEmail(student.getEmail())).thenReturn(true);
        assertThrows(ResponseStatusException.class, () -> service.save(student));
    }

    @Test
    void testGetById_ShouldReturnStudent() {
        when(repository.findById(1)).thenReturn(Optional.of(student));
        Student foundStudent = service.getById(1);
        assertNotNull(foundStudent);
        assertEquals("Ricardo", foundStudent.getNombre());
    }

    @Test
    void testGetById_ShouldThrowExceptionWhenNotFound() {
        when(repository.findById(1)).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, () -> service.getById(1));
    }

    @Test
    void testDelete_ShouldDeleteStudent() {
        when(repository.existsById(1)).thenReturn(true);
        doNothing().when(repository).deleteById(1);
        assertDoesNotThrow(() -> service.delete(1));
    }

    @Test
    void testDelete_ShouldThrowExceptionWhenNotFound() {
        when(repository.existsById(1)).thenReturn(false);
        assertThrows(ResponseStatusException.class, () -> service.delete(1));
    }
}
