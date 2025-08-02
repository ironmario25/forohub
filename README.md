# forohub
challenge del curso de java spring boot de alura

ForoHub es una API para un foro en línea donde los usuarios pueden iniciar sesión, agregar, obtener, modificar y eliminar temas de discusión. La API está protegida por autenticación y permite la gestión de los tópicos del foro.

## Endpoints

### 1. **Autenticación de Usuario**

- **URL**: `/login`
- **Método**: `POST`
- **Descripción**: Permite a los usuarios iniciar sesión en la plataforma. Se necesita un JSON con las credenciales de usuario.

#### Body (JSON):
```json
{
  "usuario": "jessica.fernandez@voll.med",
  "contrasena": "123456"
}
Respuesta: Si las credenciales son correctas, se obtiene un token de autenticación que debe usarse en las solicitudes siguientes.

2. Crear un Tópico

    URL: /topicos

    Método: POST

    Descripción: Permite agregar un nuevo tópico al foro. Se requiere estar autenticado.

Body (JSON):

{
  "titulo": "titulo 3",
  "mensaje": "mensaje 3",
  "autor": "autor 3",
  "curso": "curso 3"
}

    Respuesta: Retorna el tópico creado con los datos proporcionados.

3. Obtener Todos los Tópicos

    URL: /topicos

    Método: GET

    Descripción: Obtiene una lista de todos los tópicos en el foro. Requiere autenticación.

    Respuesta:

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

4. Obtener un Tópico por ID

    URL: /topicos/{id}

    Método: GET

    Descripción: Obtiene un tópico específico por su ID.

Ejemplo:

    URL: /topicos/1

    Respuesta:

    {
      "id": 1,
      "titulo": "titulo 1",
      "mensaje": "mensaje 1",
      "autor": "autor 1",
      "curso": "curso 1"
    }

5. Eliminar un Tópico

    URL: /topicos/{id}

    Método: DELETE

    Descripción: Elimina un tópico del foro usando su ID. Requiere autenticación.

Ejemplo:

    URL: /topicos/1

    Respuesta:

    {
      "mensaje": "Tópico eliminado con éxito"
    }

6. Modificar un Tópico

    URL: /topicos/{id}

    Método: PUT

    Descripción: Modifica los detalles de un tópico existente por su ID. Requiere autenticación.

Body (JSON):

{
  "titulo": "titulo 4",
  "mensaje": "mensaje 4",
  "autor": "autor 4",
  "curso": "curso 4"
}
