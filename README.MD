# API REST for TSG

## Descripción
Esta es una API RESTful desarrollada para la prueba tecnica de TSGroup.

## Uso
1. La base de datos corre en un contenedor de docker. Iniciar con el comando docker-compose up -d
2. Compilar aplicacion en Spring Boot con ./mvnw spring-boot:run
2. La API estará disponible en `http://localhost:8080`.

### Endpoints para autenticación

- **POST /auth/login**: Autentica a un usuario y devuelve un token de acceso.
- **POST /auth/register**: Registra un nuevo usuario.

### Endpoints para Usuarios (necesario token JWT)

- **GET /users**: Obtiene una lista de todos los usuarios.
- **GET /users/{id}**: Obtiene los detalles de un usuario específico por ID.
- **POST /users**: Crea un nuevo usuario.
- **PUT /users/{id}**: Actualiza los detalles de un usuario específico por ID.
- **DELETE /users/{id}**: Elimina un usuario específico por ID.

### Endpoints para Posts (necesario token JWT)

- **GET /posts**: Obtiene una lista de todos los posts.
- **GET /posts/{id}**: Obtiene los detalles de un post específico por ID.
- **GET /posts/user/{id}**: Obtiene una lista de posts que estan asignados al usuario especificado
- **POST /posts**: Crea un nuevo post.
- **PUT /posts/{id}**: Actualiza los detalles de un post específico por ID.
- **DELETE /posts/{id}**: Elimina un post específico por ID.

### Coleccion Postman

En el raiz del proyecto, esta la coleccion Postman exportada. Importarla en Postman para realizar las pruebas correspondientes.