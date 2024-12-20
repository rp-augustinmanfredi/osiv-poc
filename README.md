# OSIV

## Escenario 1: OSIV Activado y Desactivado con Llamada a API Externa
### Descripción del escenario:
- Buscar un usuario por userId.
- Realizar una llamada a una API externa (simulada con 1 segundo de latencia).
- Construir un objeto UserDto utilizando los datos de UserEntity, sus órdenes relacionadas y el valor retornado por la API.

## Escenario 2: OSIV Activado y Desactivado sin llamada a API Externa
### Descripción del escenario:
- Buscar un usuario por userId.
- Construir un objeto UserDto utilizando únicamente los datos de UserEntity y sus órdenes relacionadas.

## Escenario 3: OSIV Activado y Desactivado accediendo múltiples veces al repositorio.
### Descripción del escenario:
- Para esta prueba se quiere ver como repercute realizar varios accesos a la base de datos. En el caso de OSIV desactivado debe abrir y cerrar la sesión múltiples veces. Se hizo la prueba variando el valor de DB_ACCESS_TIME.


## Escenario 4: OSIV Activado y Desactivado accediendo múltiples veces al repositorio en la misma transacción.
### Descripción del escenario:
- El escenario es similar al caso 3, pero la búsqueada de los usuarios ocurre en una misma transacción. Es decir, no se va a abrir una sesión por cada vez que se recupera un usuario. Se hizo la prueba variando el valor de DB_ACCESS_TIME.
