package com.example.estudiantes;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API de Estudiantes",
				version = "1.0",
				description = "Microservicio CRUD para estudiantes"
		)
)
public class EstudiantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudiantesApplication.class, args);
	}

}
