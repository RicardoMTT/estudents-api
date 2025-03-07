package com.example.estudiantes.services;

import com.example.estudiantes.controllers.StudentController;
import com.example.estudiantes.entities.Student;
import com.example.estudiantes.exceptions.SuccessResponse;
import com.example.estudiantes.services.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();
        student.setId(1);
        student.setNombre("Ricardo");
        student.setApellido("Tovar");
        student.setEmail("ricardotovar@example.com");
    }

    @Test
    void testAll() {
        List<Student> students = Arrays.asList(student);
        when(studentService.all()).thenReturn(students);

        List<Student> result = studentController.all();

        assertEquals(1, result.size());
        assertEquals("Ricardo", result.get(0).getNombre());
        verify(studentService, times(1)).all();
    }

    @Test
    void testSave() {
        when(studentService.save(any(Student.class))).thenReturn(student);

        Student result = studentController.save(student);

        assertNotNull(result);
        assertEquals("Ricardo", result.getNombre());
        verify(studentService, times(1)).save(any(Student.class));
    }

    @Test
    void testGetById() {
        when(studentService.getById(1)).thenReturn(student);

        Student result = studentController.getById(1);

        assertNotNull(result);
        assertEquals("Ricardo", result.getNombre());
        verify(studentService, times(1)).getById(1);
    }

    @Test
    void testDelete() {
        doNothing().when(studentService).delete(1);

        ResponseEntity<?> response = studentController.delete(1);

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody() instanceof SuccessResponse);
        assertEquals("Estudiante eliminado", ((SuccessResponse) response.getBody()).getMessage());
        verify(studentService, times(1)).delete(1);
    }

}
