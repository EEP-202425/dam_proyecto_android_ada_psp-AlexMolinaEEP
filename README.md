[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/O1oNnYGo)
Aplicación android de creación de usuarios y reserva de rutasy asignación de autobúses
Android
| Código   | Requisito                                      | Cumplido |
| -------- | ---------------------------------------------- | -------- |
| RF-AN-01 | Listado de elementos                           | ✅        |
| RF-AN-02 | Formulario de creación de elementos            | ✅        |
| RF-AN-03 | Navegación entre listado y creación            | ✅        |
| RF-AN-04 | Buenas prácticas de usabilidad/diseño          | ✅        |
| RF-AN-05 | Pantalla de login (opcional)                   | ❌        |
| RF-AN-06 | Pantalla de registro (opcional)                | ❌        |
| RF-AN-07 | Pantalla de consulta de un elemento            | -        |Consulta parcial: los datos aparecen, pero sin pantalla detallada específica.
| RF-AN-08 | Formulario de modificación                     | -	        |No se vio un formulario explícito de edición, solo creación.
| RF-AN-09 | Botón de eliminación de elemento               | ✅        |
| RF-AN-10 | Widget de selección (opcional, e.g. dropdowns) | ✅        |
| RF-AN-11 | Paginación, ordenación y búsqueda (opcional)   | ❌        |
API REST
| Código    | Requisito                                              | Cumplido |
| --------- | ------------------------------------------------------ | -------- |
| RF-API-01 | Endpoint POST para crear                               | ✅        |
| RF-API-02 | Endpoint GET para recuperar todos                      | ✅        |
| RF-API-03 | Endpoint GET por ID                                    | ✅        |
| RF-API-04 | Endpoint PUT para modificar                            | ✅        |
| RF-API-05 | Endpoint DELETE para eliminar                          | ✅        |
| RF-API-06 | Paginación (opcional pero recomendado)                 | ❌        |
| RF-API-07 | Ordenación (opcional)                                  | ❌        |
| RF-API-08 | Filtrado de resultados (opcional)                      | ❌        |
| RF-API-09 | GET para recuperar valores de campos (autobuses, etc.) | ✅        |
| RF-API-10 | Endpoint de autenticación (login, opcional)            | ❌        |
| RF-API-11 | Endpoint de registro de usuarios (opcional)            | ❌        |
ADA
| Código   | Requisito                                           | Cumplido |
| -------- | --------------------------------------------------- | -------- |
| RF-BD-01 | Entidad principal con ≥ 4 atributos                 | ✅        |
| RF-BD-02 | ≥ 4 entidades con relaciones adecuadas              | ✅        |
| RF-BD-03 | Relación 1 a 1 o 1 a N entre principal y secundaria | ✅        |
| RF-BD-04 | Soporte de consultas con filtros (opcional)         | -        |Se permite consulta, pero no se implementaron filtros.
| RF-BD-05 | Consulta por ID                                     | ✅        |
| RF-BD-06 | Actualización de elementos                          | ✅        |
| RF-BD-07 | Eliminación de elementos                            | ✅        |
| RF-BD-08 | Registro y autenticación segura (opcional)          | ❌        |
Arquitectura
| Código    | Requisito                                     | Cumplido |
| --------- | --------------------------------------------- | -------- |
| RT-ARQ-01 | API con Spring Boot                           | ✅        |
| RT-ARQ-02 | Android consume la API REST                   | ✅        |
| RT-ARQ-03 | Retrofit en Android                           | ✅        |
| RT-ARQ-04 | Controladores REST + gestión de errores       | ✅        |
| RT-ARQ-05 | Persistencia con JPA/Hibernate                | ✅        |
| RT-ARQ-06 | Uso de MySQL con compatibilidad               | ✅        |
| RT-ARQ-07 | Android con Jetpack Compose                   | ✅        |
| RT-ARQ-08 | Documentación Swagger                         | ✅        |
| RT-ARQ-09 | Modo sin conexión y sincronización (opcional) | ❌        |
| RT-ARQ-10 | Logs en la API REST (opcional)                | ❌        |
Seguridad
| Código    | Requisito                           | Cumplido |
| --------- | ----------------------------------- | -------- |
| RT-SEG-01 | Validación de datos en la API       | ✅        |
| RT-SEG-02 | Manejo de errores y respuestas HTTP | ✅        |
| RT-SEG-03 | Spring Security (opcional)          | ❌        |
| RT-SEG-04 | Protección contra inyección SQL     | ✅        |
| RT-SEG-05 | Android maneja errores de red       | ✅        |
https://eepmad-my.sharepoint.com/:v:/g/personal/alejandro-molina1_eep-igroup_com/Ecx7AiOwmX9PjKl8TdA3tXkB9p5YKx9GGcUedTqLKS9V0g?e=csvPbs&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D


