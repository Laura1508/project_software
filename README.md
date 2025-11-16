# Project_software - API Reporte Financiero

Este proyecto de software se enfoca en una API REST que procesa archivos CSV de las transacciones bancarias de las diferentes cuentas bancarias de un usuario donde las clasifica y genera reportes PDF.  

# Arquitectura
El proyecto implementa una arquitectura monolítica la cual esta organizada en capas, siguiendo el patrón MVC adaptado a APIs REST.

Capa de presentación (controlador): La cual en este caso es parcialmente considerada la que recibe la solicitud de parte de un cliente
Capa de Negocio (Servicio): En esta capa se encapsula la lógica del negocio que diferencia entre transacciones e ingresos

---

# Características principales

- Carga de archivos CSV vía endpoint REST ("POST /api/report/upload")
- Clasificación automática de ingresos y egresos
- Generación de reportes en PDF como salida
- Sin frontend ni persistencia: procesamiento en memoria y salida inmediata

---

# Tecnologías utilizadas

Este proyecto se construyó con el siguiente stack de tecnologías:

*	Java 21:	Lenguaje de programación principal para la implementación de la API.

*	Spring Boot: Framework que nos permite crear aplicaciones Java a partir de un marco de trabajo ya definido basados en microservicios y APIs REST, simplificando la configuración y el despliegue.

*	Maven → Herramienta que facilita la gestión de dependencias y construcción de nuestro proyecto.

*	Spring Web (REST Controller): Esta nos permite exponer endpoints HTTP y manejar las solicitudes de clientes externos.

*	Render → Plataforma de despliegue en la nube que permite exponer la API con una URL pública, esto permitirá el consumo desde cualquier cliente (Postman, curl, navegador u otras aplicaciones).
