# 🛒 API Bazar - Spring Boot

Trabajo Práctico Final del curso **"Desarrollo de APIs en Java con Spring Boot"** — TodoCode Academy.
API REST para la gestión de un bazar, que permite administrar productos, clientes y ventas. Diseñada para ser consumida por múltiples clientes (web y mobile).

## 🛠️ Tecnologías

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/springboot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

## 📐 Arquitectura
```
controller/   → Endpoints REST
service/      → Lógica de negocio
repository/   → Acceso a datos con JPA
model/        → Entidades (Producto, Venta, Cliente)
dto/          → Patrón DTO para respuestas específicas
mapper/       → Conversión entre entidades y DTOs
exception/    → Manejo de excepciones personalizadas y del framework
swagger/      → Configuracion del archivo de documentacion de la API
payload/      → Formato de la respuesta cuando se lanzan excepciones

```

## 📦 Modelos

- **Producto** — código, nombre, marca, costo, cantidad disponible
- **Cliente** — id, nombre, apellido, DNI
- **Venta** — código, fecha, total, lista de productos y cliente asociado

## 🔗 Endpoints

### Productos
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/productos` | Lista todos los productos |
| GET | `/productos/{codigo}` | Obtiene un producto |
| GET | `/productos/falta_stock` | Productos con stock menor a 5 |
| POST | `/productos/crear` | Crea un producto |
| PUT | `/productos/editar/{codigo}` | Edita un producto |
| DELETE | `/productos/eliminar/{codigo}` | Elimina un producto |

### Clientes
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/clientes` | Lista todos los clientes |
| GET | `/clientes/{id}` | Obtiene un cliente |
| POST | `/clientes/crear` | Crea un cliente |
| PUT | `/clientes/editar/{id}` | Edita un cliente |
| DELETE | `/clientes/eliminar/{id}` | Elimina un cliente |

### Ventas
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/ventas` | Lista todas las ventas |
| GET | `/ventas/{codigo}` | Obtiene una venta |
| GET | `/ventas/productos/{codigo}` | Lista productos de una venta |
| GET | `/ventas/{fecha_venta}` | Sumatoria y cantidad de ventas del día |
| GET | `/ventas/mayor_venta` | Venta con el monto más alto (DTO) |
| POST | `/ventas/crear` | Crea una venta |
| PUT | `/ventas/editar/{codigo}` | Edita una venta |
| DELETE | `/ventas/eliminar/{codigo}` | Elimina una venta |


## 🧪 Colección Postman

Incluida en el repositorio como `bazar-collection.json`. Importala en Postman para probar todos los endpoints.

## 📄 Documentación API
Podés importar el archivo [api-docs.json](./api-docs.json) en Postman o Swagger Editor para explorar los endpoints.


## ⚠️ Manejo de Errores con ExceptionHandler

Todos los errores de la API devuelven la siguiente estructura:
```json
{
  "detalleTiempo": "2026-03-07T14:54:51",
  "descripcion": "Mensaje descriptivo del error",
  "url": "/endpoint/afectado"
}
```

| Código | Excepción | Descripción |
|--------|-----------|-------------|
| 404 | ResourceNotFoundException | Recurso no encontrado en la base de datos |
| 400 | BusinessException | Violación de regla de negocio |
| 400 | HttpMessageNotReadableException | JSON del body mal formado |
| 400 | MethodArgumentNotValidException | Campos vacíos o inválidos según @Valid |
| 404 | NoHandlerFoundException | Endpoint inexistente |
| 409 | DataIntegrityViolationException | Dato duplicado o violación de restricción en la DB |
| 500 | Exception | Error inesperado del servidor |

## ▶️ Cómo ejecutar el proyecto

1. Cloná el repositorio
2. Abrilo en IntelliJ IDEA o tu IDE favorito
3. Ejecutá la clase `TestTcApplication`
4. La API corre en `http://localhost:8080`

