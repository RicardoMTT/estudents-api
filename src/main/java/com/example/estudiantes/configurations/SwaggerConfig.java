package com.example.estudiantes.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
@Configuration
public class SwaggerConfig{


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Estudiantes")
                        .version("1.0")
                        .description("Microservicio CRUD para la gestión de estudiantes")
                        .contact(new Contact()
                                .name("Tu Nombre")
                                .email("tu.email@ejemplo.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }

}
