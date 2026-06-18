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
4.  **Consumo de API Externa:** Implementación de un cliente web reactivo (`WebClient`) alojado en `ExternalVRKController` que consume de forma asíncrona un servicio REST en internet para simular la carga.
5.  **Control Global de Excepciones:** Interceptor dinámico (`GlobalExceptionHandler`) que captura errores comunes (como validaciones fallidas `@Valid` o recursos no encontrados `404`) evitando el colapso del servidor y devolviendo un JSON limpio y estandarizado.
6.  **Seguridad Robusta (Spring Security + JWT):** Implementación de autenticación y autorización basada en tokens JSON Web Tokens (JWT) para proteger los endpoints y gestionar accesos por roles (ej. ADMIN y CLIENTE).
7.  **Documentación Interactiva (Swagger/OpenAPI):** Panel visual autogenerado mediante Swagger UI que permite explorar y probar todos los endpoints de la API en tiempo real directamente desde el navegador.
8.  **Pruebas Unitarias Automatizadas:** Cobertura de la lógica de negocio y validaciones mediante tests unitarios integrados para asegurar la estabilidad del sistema.
9.  **Contenedorización con Docker:** Configuración lista para compilar y desplegar la aplicación junto a la base de datos de manera ágil usando Docker y Docker Compose.

---

## ⚙️ Arquitectura de Endpoints (12 Puntos de Conexión)
La API expone un total de **12 endpoints** clasificados en 4 módulos lógicos:

### 👕 1. Gestión de Prendas (`/api/v1/prendas`)
* `GET /api/v1/prendas` - Lista todas las prendas disponibles en MySQL.
* `POST /api/v1/prendas` - Agrega una prenda nueva al inventario.
* `GET /api/v1/prendas/{id}` - Busca una prenda específica según su ID.
* `PUT /api/v1/prendas/{id}` - Modifica los atributos de una prenda existente.
* `DELETE /api/v1/prendas/{id}` - Remueve un artículo del inventario de forma permanente.

## 📖 Documentación Interactiva con Swagger (OpenAPI)

Para facilitar las pruebas y la exploración de la API sin necesidad de herramientas externas como Postman, el proyecto cuenta con **Swagger UI**.

### 🌐 ¿Cómo acceder a la interfaz?
Una vez que el servidor backend esté corriendo con éxito (`http://localhost:8080`), abre tu navegador web de preferencia e ingresa a la siguiente URL:
* **Interfaz Gráfica (Swagger UI):** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
* **Documentación en formato JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

### 🛠️ ¿Qué puedes hacer en Swagger UI?
1. **Visualizar los Módulos:** Verás los controladores organizados limpiamente (Prendas, Usuarios, Carrito y Música).
2. **Autenticación en Vivo:** Puedes ingresar el token generado en el login haciendo clic en el botón **"Authorize"** (icono de candado) para habilitar las peticiones protegidas.
3. **Probar Endpoints en Vivo:** Al desplegar cualquier endpoint, puedes hacer clic en el botón **"Try it out"**, rellenar los parámetros o el JSON del cuerpo (Body) y presionar **"Execute"** para ver la respuesta real del servidor en tiempo real.

---

## ⚙️ Get Started

Sigue estos pasos para clonar el proyecto, configurar la base de datos y ejecutar la API en tu entorno local.

### 📋 Prerrequisitos
Asegúrate de tener instalado lo siguiente:
* **Java Development Kit** Versión 17 o superior.
* **XAMPP:** Para activar y administrar el servidor local de **MySQL** donde se guardarán los datos. 
* **VS Code** con las extensiones de Java.
* **Docker y Docker Desktop** *(Opcional, solo si deseas desplegar en contenedores).*

### 🛠️ 1. Clonar el repositorio
Abre tu terminal en VS Code (ctrl + ñ) y ejecuta los siguientes comandos:

```bash
# Clona el repositorio
git clone https://github.com/cassianmns/VRK-STORE.git
cd VRK-STORE
```

### 🗄️ 2. Configuración y Despliegue de la Base de Datos (MySQL) con XAMPP

Este proyecto utiliza MySQL para guardar toda la información del inventario y los usuarios de la tienda de forma automática. Sigue estos pasos para dejar la base de datos lista:

1. **Activar el servidor local**
* Abre el **XAMPP** y haz clic en el botón Start que está al lado del MySQL.
* La base de datos debe estar en el puerto local estándar `3306`.

2. **Conexión MySQL**
Si utilizas **MySQL Workbench** para tu base de datos, debes rellenar los siguientes puntos:

* **Connection Name:** El nombre que prefieras para identificarlo.
* **Connection Method:** Standard (TCP/IP).
* **Hostname:** 127.0.0.1
* **Port:** 3306 (puerto por defecto de MySQL).
* **Username:** root (usuario administrador predeterminado de XAMPP).
* **Password:** Déjalo completamente vacío.

3. **Crear la base de datos**
* Abre tu terminal o consola de comandos conectada a MySQL.
* Crea una nueva base de datos llamada `vrk` ejecutando la siguiente consulta:
```bash
CREATE DATABASE vrk;
```
* Presiona el ícono del **rayo amarillo** en la barra superior para ejecutar el comando.

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
### 🐳 4. Despliegue Alternativo con Docker (Opcional)
Si prefieres no usar XAMPP ni configurar la base de datos a mano, puedes levantar todo el entorno empaquetado ejecutando el siguiente comando en la raíz del proyecto (donde se encuentra el archivo docker-compose.yml)

Construir la aplicación e iniciar los contenedores de la API y MySQL
```bash
docker-compose up --build
```
Docker se encargará de descargar la imagen de MySQL, crear la base de datos vrk automáticamente y compilar el backend en un contenedor conectado en el puerto 8080.

### 🧪 5. Ejecución de Pruebas Unitarias
El proyecto viene equipado con un conjunto de pruebas automatizadas para verificar el correcto funcionamiento del carrito de compras y las reglas de negocio de las prendas. Para ejecutarlas, puedes abrir la terminal y escribir:
```bash
./mvnw test
Esto correrá todos los tests unitarios y te mostrará el reporte de aprobación directamente en la consola.

Y LISTO!! con eso la API está activa y ejecutándose en `http://localhost:8080` y las extensiones mencionadas al inicio del README en el apartado `Arquitectura de Endpoints`, puedes usar herramientas como Postman para interactuar con los endpoints del inventario y carritos.

Para interactuar con el sistema puedes:
* Utilizar la interfaz interactiva de **Swagger** directamente en tu navegador.
* Importar el archivo `POSTMAN.json` adjunto en este repositorio dentro de la aplicación **Postman** y hacer clic en **Send** para operar los endpoints.


## 👥 Autores (Grupo de Trabajo)
El desarrollo y diseño arquitectónico de este proyecto fue realizado por estudiantes de la carrera de Ingeniería en Informática de **Duoc UC (Sede San Joaquín)**:
* **Ángel Martín**
* **Nicolás Robles**
* **Catalina Vargas**














