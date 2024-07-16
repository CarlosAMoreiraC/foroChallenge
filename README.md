# Foro Challenge

El siguiente proyecto expone al usuario un CRUD mediante servicios rest para la administracion de topicos de un foro.

Dentro de las operaciones tenemos las siguientes opciones:

- Registrar un topico
- Listar los topicos registrados
- Obtener los detalles de un topico por medio de su id
- Actualizar un topico
- Eliminar un topico por medio de su id

# Operaciones

Para ejecutar las operaciones mencionadas anteriormente se crearon los siguientes endpoints:

### POST -> /login

Endpoint encargado de generar el token con el cual se podran consumir los servicios del CRUD de topicos

Request body

{
    "username": "",
    "clave":""
}


### POST -> /topicos

Endpoint encargado del registro de los topicos, devuelve como response un JSON con la data del topico registrado.

Request body

{
    "titulo":"Nuevo topico 2",
    "mensaje": "Registro de un nuevo topico 2",
    "autorId":"1",
    "cursoId":"1"
}

### GET -> /topicos

Lista todos los topicos registrados en el momento, maneja la opcion de paginacion.

### GET -> /topicos/{id}

Obtiene la informacion de un topico en especifico mediante su id.

### PUT -> /topicos/{id}

Actualiza la informacion de un topico mediante su id.

### DELETE -> /topicos/{id}

Elimina un topico de la base de datos mediante su id.



 ## Desarrollo

 El proyecto se desarrollo utilizando Java 17, SpringBoot, Spring JPA, MySQL como base de datos. Adicional, se implemento SpringSecurity, para que el usuario pueda consumir los servicios expuestos, debe geneerar un token por medio del endpoint login, en el cual se envia, el usuario y la contraseña.

 El usuario y contraseña deben ser registrado en la tabla usuario, la clave debe ser encriptada el algoritmo Bcrypt para que pueda funcionar.
