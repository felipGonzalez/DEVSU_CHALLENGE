# PRUEBA TECNICA DEVSU

## Descripción

Este proyecto consiste en la implementacion de varios microservicios para realizar diversas funciones. A continuación se detalla cada microservicio incluido en la aplicación:

**Arquitectura:** Microservicios, DDD, Hexagonal 

**Server:** Java 17, Spring Boot

### Microservicio 1: Customer Service

- **Descripción**: Gestiona la información de los clientes.
- **Puerto**: 8080
- **Rutas**: `/clientes/{id}`
- **Base de Datos**: MySQL
- **Tecnologías**: Spring Boot, MySQL

### Microservicio 2: Account Service

- **Descripción**: Gestiona las cuentas asociadas a los clientes.
- **Puerto**: 8081
- **Rutas**: `/cuentas/{id}`, `/movimientos/`, `/reportes/`
- **Base de Datos**: MySQL
- **Tecnologías**: Spring Boot, MySQL

### Ejecución con Docker Compose
Para ejecutar los microservicios utilizando Docker Compose, sigue estos pasos:

Asegúrate de tener Docker y Docker Compose instalados en tu máquina.

Clonar el proyecto

```bash
  git clone https://github.com/felipGonzalez/DEVSU_CHALLENGE.git
```

En el directorio raíz del proyecto, donde se encuentra el archivo docker-compose.yml, ejecuta el siguiente comando para construir las imágenes de Docker de tus servicios:

```bash
  docker-compose build
```

Una vez que las imágenes estén construidas, levanta los contenedores con el siguiente comando:

```bash
 docker-compose up
```

Este comando iniciará todos los servicios definidos en docker-compose.yml. Docker Compose intentará reiniciar los servicios hasta que todos estén arriba y funcionando correctamente.

Asegúrate de que la base de datos esté completamente inicializada y lista para recibir conexiones antes de ejecutar las pruebas o acceder a los servicios. Puedes verificar el estado de la base de datos ejecutando:

```bash
 docker-compose ps
```

Esto te mostrará el estado de todos los contenedores de Docker que están corriendo.

Una vez que los servicios estén en ejecución, puedes acceder a ellos a través de las rutas definidas, por ejemplo:

Account Service: http://localhost:8080/clientes/?clientId={clientId}, http://localhost:8081/movimientos/, http://localhost:8081/reportes?date={date}&clientId={clientId}


### Ejecución en entorno local
Configuración de Servicios Locales
Para ejecutar los servicios localmente y conectarlos entre sí, asegúrate de configurar las URL de los servicios correspondientes en los archivos de propiedades de cada microservicio:

- **Account Service:**

  *application.properties*

  ```bash
    client.service.url=http://localhost:8080/
  ```

- **Customer Service:**

  *application.properties*

  ```bash
    account.service.url=http://localhost:8081/
  ```




**Tambien asegúrate de configurar adecuadamente las conexiones a la base de datos en los archivos de propiedade**.


## Autor

- [@Felipe Gonzalez](https://www.linkedin.com/in/andres-felipe-gonz%C3%A1lez-bonilla-03004b137/)
