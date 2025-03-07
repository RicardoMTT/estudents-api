package com.example.estudiantes.controllers;

import com.example.estudiantes.entities.Student;
import com.example.estudiantes.exceptions.SuccessResponse;
import com.example.estudiantes.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;


@RestController
@RequestMapping("/api/estudiantes")
@Tag(name = "Estudiantes", description = "API para gestionar estudiantes")
public class StudentController {

    @GetMapping("/swagger")
    public String redirectToSwaggerUi() {
        return "redirect:/swagger-ui/index.html";
    }

    @Autowired
    private StudentService service;

    @GetMapping
    @Operation(summary = "Listar todos los estudiantes")
    public List<Student> all() {
        return service.all();
    }

    @PostMapping
    @Operation(summary = "Guardar un nuevo estudiante")
    public Student save(@RequestBody Student estudiante) {
        return service.save(estudiante);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un estudiante por ID")
    public Student getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un estudiante por ID")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().body(new SuccessResponse("Estudiante eliminado"));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un estudiante por ID")
    public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody Student estudiante) {
        Student updatedStudent = service.update(id, estudiante);
        return ResponseEntity.ok(updatedStudent);
    }

}
