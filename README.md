# ForoHub

**Challenge del curso de Java Spring Boot de Alura**

ForoHub es una API REST para un foro en línea donde los usuarios pueden autenticarse y realizar operaciones CRUD (crear, leer, actualizar y eliminar) sobre tópicos de discusión. Todos los endpoints están protegidos mediante autenticación con JWT.

---

## Tecnologías

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- H2 / PostgreSQL
- Maven

---

## Autenticación

### Iniciar sesión

**URL:** `/login`  
**Método:** `POST`  
**Descripción:** Inicia sesión con credenciales válidas.

**Body:**
```json
{
  "usuario": "jessica.fernandez@voll.med",
  "contrasena": "123456"
}
```

**Respuesta exitosa:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

## Endpoints de Tópicos

### 1. Crear un Tópico

**URL:** `/topicos`  
**Método:** `POST`  
**Requiere Autenticación:** ✅

**Body:**
```json
{
  "titulo": "titulo 3",
  "mensaje": "mensaje 3",
  "autor": "autor 3",
  "curso": "curso 3"
}
```

**Respuesta:**
```json
{
  "id": 3,
  "titulo": "titulo 3",
  "mensaje": "mensaje 3",
  "autor": "autor 3",
  "curso": "curso 3"
}
```

---

### 2. Obtener Todos los Tópicos

**URL:** `/topicos`  
**Método:** `GET`  
**Requiere Autenticación:** ✅

**Respuesta:**
```json
[
  {
    "id": 1,
    "titulo": "titulo 1",
    "mensaje": "mensaje 1",
    "autor": "autor 1",
    "curso": "curso 1"
  },
  {
    "id": 2,
    "titulo": "titulo 2",
    "mensaje": "mensaje 2",
    "autor": "autor 2",
    "curso": "curso 2"
  }
]
```

---

### 3. Obtener un Tópico por ID

**URL:** `/topicos/{id}`  
**Método:** `GET`  
**Requiere Autenticación:** ✅

**Ejemplo:**
`GET /topicos/1`

**Respuesta:**
```json
{
  "id": 1,
  "titulo": "titulo 1",
  "mensaje": "mensaje 1",
  "autor": "autor 1",
  "curso": "curso 1"
}
```

---

### 4. Eliminar un Tópico

**URL:** `/topicos/{id}`  
**Método:** `DELETE`  
**Requiere Autenticación:** ✅

**Ejemplo:**
`DELETE /topicos/1`

**Respuesta:**
```json
{
  "mensaje": "Tópico eliminado con éxito"
}
```

---

### 5. Modificar un Tópico

**URL:** `/topicos/{id}`  
**Método:** `PUT`  
**Requiere Autenticación:** ✅

**Body:**
```json
{
  "titulo": "titulo 4",
  "mensaje": "mensaje 4",
  "autor": "autor 4",
  "curso": "curso 4"
}
```

**Respuesta:**
```json
{
  "id": 1,
  "titulo": "titulo 4",
  "mensaje": "mensaje 4",
  "autor": "autor 4",
  "curso": "curso 4"
}
```

---

## Cómo ejecutar

1. Clonar el repositorio:
```bash
git clone https://github.com/tu-usuario/forohub.git
```

2. Importar el proyecto en tu IDE como proyecto Maven.

3. Ejecutar la clase principal `ForohubApplication`.

4. Usar Postman o curl para probar los endpoints autenticados con el token JWT.

---

## Autor

Desarrollado como parte del curso de Java Spring Boot de Alura.
