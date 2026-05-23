# 🛒 VRK STORE — Sistema de Gestión de Tienda y Carritos

¡Bienvenido al repositorio de **VRK STORE**! Este proyecto consiste en el desarrollo de una API REST robusta construida con **Spring Boot**, diseñada para gestionar el inventario de una tienda de ropa, administración de usuarios, y la simulación completa de lógica de carritos de compras. 

Además, incorpora consumo de servicios web externos mediante programación reactiva (`WebClient`) y un sistema centralizado de control de errores.

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

---

## ⚙️ Get Started

Sigue estos pasos para clonar el proyecto, configurar la base de datos y ejecutar la API en tu entorno local.

### 📋 Prerrequisitos
Asegúrate de tener instalado lo siguiente:
* **Java Development Kit** Versión 17 o superior.
* **XAMPP:** Para activar y administrar el servidor local de **MySQL** donde se guardarán los datos. 
* **VS Code** con las extensiones de Java.

### 🛠️ 1. Clonar el repositorio
Abre tu terminal (ctrl + ñ) y ejecuta los siguientes comandos:

```bash
# Clona el repositorio
git clone https://github.com/cassianmn/RobloxMusic.git
cd VRKSTORE
```

### 🗄️ 2. Configuración y Despliegue de la Base de Datos (MySQL) con XAMPP

Este proyecto utiliza MySQL para guardar toda la información del inventario y los usuarios de forma automática. Sigue estos pasos para dejar la base de datos lista:

1. **Abrir MySQL:** Abre el XAMPP y haz clic en el botón Start que esta al lado de MySQL 

2. **Crear la base de datos:** 
    * Abre tu terminal o consola de comandos conectada a MySQL.
    * Crea una nueva base de datos llamada `vrk` ejecutando la siguiente consulta:
```bash
CREATE DATABASE vrk;
```

### 🚀 3. Ejecución de la API en Visual Studio Code

Una vez que tengas MySQL encendido en XAMPP y la base de datos vrk creada, sigue estos pasos para arrancar el backend:

1. **Abrir el proyecto:** Abre visual studio y selecciona la opción `Abrir carpeta`. Selecciona la carpeta raíz del proyecto (VRKSTORE).

2. **Cargar dependencias:** Espera unos segundos a que carguen los proyectos de java.

3. **Ejecutar el servidor:** 
    * En el explorador de archivos del lado izquierdo, busca la siguiente ruta: src --> main --> java --> com --> duoc --> vrk --> `VRKApplication.java`

    * Abre ese archivo y veras que arriba de la linea `public static void main(String[] args)` hay una linea de codigo que dice **RUN | DEBUG**

    * Haz clic en **RUN** (ejecutar).

4. **Verificación:** Sabrás que esta corriendo con éxito el servidor cuando la terminal deje de cargar y veas un mensaje similar a: 
```bash
[main] INFO  com.duoc.vrk.VrkApplication - Started VrkApplication in X.XXX seconds (JVM running for X.XX)
```

Y LISTO!! con eso la API está activa y ejecutándose en `http://localhost:8080`,puedes usar herramientas como Postman para interactuar con los endpoints del inventario y carritos.

---

## 👥 Autores (Grupo de Trabajo)
El desarrollo y diseño arquitectónico de este proyecto fue realizado por estudiantes de la carrera de Ingeniería en Informática de **Duoc UC (Sede San Joaquín)**:
* **Ángel Martín**
* **Nicolás Robles**
* **Catalina Vargas**














