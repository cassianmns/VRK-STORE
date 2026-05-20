# 🛒 VRK STORE — Sistema de Gestión de Tienda y Carritos

¡Bienvenido al repositorio de **VRK STORE**! Este proyecto consiste en el desarrollo de una API REST robusta construida con **Spring Boot**, diseñada para gestionar el inventario de una tienda de ropa, administración de usuarios, y la simulación completa de lógica de carritos de compras. 

Además, incorpora consumo de servicios web externos mediante programación reactiva (`WebClient`) y un sistema centralizado de control de errores.

---

## 👥 Autores (Grupo de Trabajo)
El desarrollo y diseño arquitectónico de este proyecto fue realizado por estudiantes de la carrera de Ingeniería en Informática de **Duoc UC (Sede San Joaquín)**:
* **Ángel Martín**
* **Nicolás Robles**
* **Catalina Vargas**

---

## 📝 Descripción del Programa
La aplicación funciona como el núcleo transaccional (Backend) para una plataforma de personalización. Utiliza una arquitectura limpia dividida en controladores, servicios, repositorios y objetos de transferencia de datos (DTOs), conectándose de forma síncrona a una base de datos relacional.

### 🚀 Características Principales:
1.  **Gestión de Inventario (Prendas):** CRUD completo (Crear, Leer, Actualizar, Borrar) para el catálogo de ropa con especificaciones de tipo, estilo, material, stock, talla, precio y color.
2.  **Gestión de Usuarios:** Registro y consulta de clientes utilizando validaciones de identidad (RUN, Dígito Verificador, correo electrónico, etc.).
3.  **Lógica del Carrito de Compras:** Simulación del procesamiento de pedidos acoplando las entidades de Usuario y Prendas. Utiliza `CarritoDTO` para formatear y estructurar limpiamente las respuestas JSON hacia el cliente.
4.  **Consumo de API Externa:** Implementación de un cliente web reactivo (`WebClient`) alojado en `ExternalMusicController` que consume de forma asíncrona un servicio REST en internet para simular la carga distribuidora de música [cite: 2026-03-25].
5.  **Control Global de Excepciones:** Interceptor dinámico (`GlobalExceptionHandler`) que captura errores comunes (como validaciones fallidas `@Valid` o recursos no encontrados `404`) evitando el colapso del servidor y devolviendo un JSON limpio y estandarizado.

---

## ⚙️ Arquitectura de Endpoints (12 Puntos de Conexión)
La API expone un total de **12 endpoints** clasificados en 4 módulos lógicos:

### 👕 1. Gestión de Prendas (`/api/v1/prendas`)
* `GET /api/v1/prendas` - Lista todas las prendas disponibles en MySQL.
* `POST /api/v1/prendas` - Agrega una prenda nueva al inventario.
* `GET /api/v1/prendas/{id}` - Busca una prenda específica según su ID.
* `PUT /api/v1/prendas/{id}` - Modifica los atributos de una prenda existente.
* `DELETE /api/v1/prendas/{id}` - Remueve un artículo del inventario de forma permanente.
