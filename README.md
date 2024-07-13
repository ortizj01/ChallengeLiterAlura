# LiterAlura

LiterAlura es una aplicación de consola desarrollada en Spring Boot que permite buscar libros por título utilizando la API de Gutendex, gestionar autores y filtrar libros por idioma y autores vivos en un año específico.

## Instalación

### Requisitos previos:
- Java JDK 8 o superior
- IDE compatible con Spring Boot (por ejemplo, IntelliJ IDEA)
- Conexión a Internet para acceder a la API de Gutendex

### Pasos para ejecutar localmente:
1. Clonar el repositorio desde GitHub: `git clone https://github.com/ortizj01/ChallengeLiterAlura`
2. Abrir el proyecto en tu IDE.
3. Configurar las credenciales de la base de datos en `application.properties`.
4. Ejecutar la clase principal `LiterAluraApplication.java`.

## Uso

Para usar la aplicación LiterAlura:
- Sigue las instrucciones en la consola para buscar libros, listar libros registrados, autores, etc.
- Sigue las validaciones y sugerencias proporcionadas por la aplicación durante la interacción.

## Estructura del Proyecto

Estructura del Proyecto:
- src/
  - main/
    - java/
      - com/
        - literAlura/
          - model/       (Modelos de datos)
          - repository/  (Repositorios de base de datos)
          - service/     (Servicios de negocio)
          - controller/  (Controladores para la API REST)
          - literaluraApplication.java (Clase principal)
    - resources/
      - application.properties  (Configuración de la aplicación)

## Contribución

Las contribuciones son bienvenidas. Por favor, haz un fork del repositorio y crea un pull request con tus mejoras.

## Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo LICENSE para más detalles.

## Contacto

Para preguntas o soporte, contáctame en juanestebanortiz70@gmail.com
