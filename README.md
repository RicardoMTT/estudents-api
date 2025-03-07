
# API Gestión de estudiantes

Este proyecto es una API REST desarrollada en Spring Boot para gestionar estudiantes, permitiendo operaciones CRUD (Crear, Leer, Actualizar y Eliminar).

## Caracteristicas principales

* Creación de estudiantes con validación de correo único.
* Búsqueda de estudiante por ID.
* Actualización de estudiante por ID.
* Eliminación de estudiante por ID.
* Documentación con Swagger OpenAPI.

### Documentación

Luego de levantar el proyecto navegar a la siguiente [URL](http://localhost:8080/webjars/swagger-ui/index.html ).
En el campo ingresar el valor de http://localhost:8080/v3/api-docs.

### Ejecucón

Para levantar el proyecto ejecuta el siguiente comando

```
  mvn spring-boot:run
```


### Pruebas unitarias

Para ejecutar las pruebas unitarias ejecuta el siguiente comando
```
  mvn test
```
