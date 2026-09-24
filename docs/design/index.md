# Inicio

## Arquitectura del sistema

La arquitectura del sistema define los principales componentes que forman Ilicitan Airlines y la comunicación existente entre ellos.

El sistema estará compuesto por una aplicación web, una aplicación móvil, un backend encargado de proporcionar los servicios de la plataforma y una base de datos para el almacenamiento persistente de la información.

Las aplicaciones cliente no accederán directamente a la base de datos. Toda comunicación con el sistema se realizará mediante la API proporcionada por el backend, permitiendo centralizar la lógica de negocio y mantener una estructura común para los distintos clientes.

En la siguiente imagen se muestra la arquitectura propuesta para el desarrollo del proyecto.

![Arquitectura tecnológica](../assets/images/sources/project-structure.webp)

| Componente       | Responsabilidad                                                                                                                        |
| ---------------- | -------------------------------------------------------------------------------------------------------------------------------------- |
| Aplicación web   | Proporcionar la interfaz web para consultar vuelos, realizar reservas, gestionar reservas y realizar el check-in.                      |
| Aplicación móvil | Proporcionar las funcionalidades disponibles desde dispositivos móviles, incluyendo la consulta y utilización de tarjetas de embarque. |
| Backend          | Exponer la API REST, aplicar la lógica de negocio, validar operaciones y gestionar el acceso a los datos.                              |
| Base de datos    | Almacenar de forma persistente usuarios, vuelos, reservas, pasajeros, aeronaves, aeropuertos y demás información del sistema.          |

Esta distribución permite que las aplicaciones web y móvil compartan los mismos servicios y datos, evitando duplicar la lógica de negocio en cada cliente.

---

## Arquitectura software

La arquitectura software define la organización interna del backend y la separación de responsabilidades entre sus diferentes componentes.

Para el backend se utilizará una arquitectura por capas, separando la recepción de peticiones, la lógica de negocio y el acceso a los datos. Esta separación permite reducir el acoplamiento entre componentes y facilita el mantenimiento y la ampliación del sistema.

```mermaid
flowchart TB

    CLIENT["Aplicación web / Aplicación móvil"]

    CONTROLLER["Capa de presentación<br/>Controllers / REST"]

    SERVICE["Capa de negocio<br/>Services"]

    REPOSITORY["Capa de persistencia<br/>Repositories"]

    DB[("MariaDB")]

    CLIENT --> CONTROLLER
    CONTROLLER --> SERVICE
    SERVICE --> REPOSITORY
    REPOSITORY --> DB
```

### Capa de presentación

La capa de presentación será responsable de recibir las peticiones HTTP procedentes de las aplicaciones cliente y devolver las respuestas correspondientes.

Esta capa gestionará los endpoints de la API REST, los parámetros de entrada, la validación inicial de las solicitudes y la transformación de los datos intercambiados mediante JSON.

### Capa de negocio

La capa de negocio contendrá las reglas y operaciones propias del sistema.

Será responsable, entre otras operaciones, de comprobar la disponibilidad de vuelos, crear y gestionar reservas, comprobar las condiciones de cancelación y modificación, controlar la disponibilidad de asientos y gestionar el proceso de check-in.

Esta capa no dependerá directamente de la interfaz utilizada por el usuario.

### Capa de persistencia

La capa de persistencia será responsable de realizar las operaciones necesarias sobre la base de datos.

Los repositorios permitirán consultar, crear, modificar y eliminar la información persistida sin que los controladores tengan que conocer directamente la estructura interna de la base de datos.

### Base de datos

MariaDB será el sistema de gestión de bases de datos utilizado para almacenar de forma persistente la información gestionada por la aplicación.

La comunicación con la base de datos se realizará exclusivamente desde la capa de persistencia.

---

## Tecnologías

A continuación se detallan las tecnologías utilizadas durante el desarrollo del proyecto y con las que se está construyendo la aplicación.

### Lenguajes

<div class="tech-content">
  <div class="tech-card java"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" alt="Java"><div class="tech-info"><span>Java</span><span>JDK 25 LTS</span></div></div>
  <div class="tech-card typescript"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/typescript/typescript-original.svg" alt="TypeScript"><div class="tech-info"><span>TypeScript</span><span>7.0.2</span></div></div>
  <div class="tech-card kotlin"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg" alt="Kotlin"><div class="tech-info"><span>Kotlin</span><span>2.4.20</span></div></div>
  <div class="tech-card html"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/html5/html5-original.svg" alt="HTML"><div class="tech-info"><span>HTML</span><span>HTML5</span></div></div>
  <div class="tech-card sass"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/sass/sass-original.svg" alt="Sass"><div class="tech-info"><span>Sass</span><span>SCSS</span></div></div>
  <div class="tech-card mariadb"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mariadb/mariadb-original.svg" alt="MariaDB"><div class="tech-info"><span>MariaDB</span><span>12.3 LTS</span></div></div>
</div>

### Frameworks

<div class="tech-content">
  <div class="tech-card angular"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/angular/angular-original.svg" alt="Angular"><div class="tech-info"><span>Angular</span><span>21 LTS</span></div></div>
  <div class="tech-card spring"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" alt="Spring Boot"><div class="tech-info"><span>Spring Boot</span><span>4.1.1</span></div></div>
  <div class="tech-card junit"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original.svg" alt="JUnit"><div class="tech-info"><span>JUnit</span><span>6.1.3</span></div></div>
  <div class="tech-card compose"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jetpackcompose/jetpackcompose-original.svg" alt="Jetpack Compose"><div class="tech-info"><span>Jetpack Compose</span><span>1.12.1</span></div></div>
  <div class="tech-card compose"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jetpackcompose/jetpackcompose-original.svg" alt="Compose Multiplatform"><div class="tech-info"><span>Compose Multiplatform</span><span>1.12.0</span></div></div>
</div>

### IDE's

<div class="tech-content">
  <div class="tech-card intellij"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" alt="IntelliJ IDEA"><div class="tech-info"><span>IntelliJ IDEA</span><span>2026.2.3</span></div></div>
  <div class="tech-card webstorm"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/webstorm/webstorm-original.svg" alt="WebStorm"><div class="tech-info"><span>WebStorm</span><span>2026.2.2</span></div></div>
  <div class="tech-card androidstudio"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/androidstudio/androidstudio-original.svg" alt="Android Studio"><div class="tech-info"><span>Android Studio</span><span>Quail 4 | 2026.1.4 Patch 1</span></div></div>
  <div class="tech-card vscode"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/vscode/vscode-original.svg" alt="Visual Studio Code"><div class="tech-info"><span>Visual Studio Code</span><span>1.138</span></div></div>
</div>

### Herramientas

<div class="tech-content">
  <div class="tech-card maven"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/maven/maven-original.svg" alt="Maven"><div class="tech-info"><span>Maven</span><span>3.9.16</span></div></div>
  <div class="tech-card git"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/git/git-original.svg" alt="Git"><div class="tech-info"><span>Git</span><span>2.55.0</span></div></div>
  <div class="tech-card github"><img src="https://cdn.simpleicons.org/github/757575" alt="GitHub"><div class="tech-info"><span>GitHub</span><span>2.81.0</span></div></div>
  <div class="tech-card mariadb"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mariadb/mariadb-original.svg" alt="MariaDB Cloud"><div class="tech-info"><span>MariaDB Cloud</span><span>Cloud Database</span></div></div>
  <div class="tech-card figma"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/figma/figma-original.svg" alt="Figma"><div class="tech-info"><span>Figma</span><span>Design</span></div></div>
</div>