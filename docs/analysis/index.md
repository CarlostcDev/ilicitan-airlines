# Inicio

## Objetivo del análisis

El objetivo de esta fase se centra en transformar aquellos [requisitos](../requirements/index.md) definidos en la fase anterior en un modelo estructurado que permita determinar su comportamiento, actores implicados, procesos, entidades que intervienen y relaciones existentes entre ellas.

---

## Alcance

### Alcance del proyecto

Ilicitan Airlines será un sistema de gestión de una aerolinea que permitirá a los usuarios consultar vuelos, realizar reservas, gestionar sus billetes y realizar el proceso de check-in.

El sistema también permitirá a los administradores gestionar los usuarios, las reservas, los vuelos, los aeropuertos y las aeronaves de la compañía.

El sistema estará disponible mediante una aplicación web y una aplicación móvil, compartiendo la información gestionada por el sistema.

### Límites del sistema

El sistema gestionará la información y los procesos internos relacionados con la venta y gestión de vuelos.

Quedan fuera del alcance del sistema:

- El procesamiento económico real de los pagos.
- La gestión real del tráfico aéreo.
- El mantenimiento físico de las aeronaves.
- La gestión de aeropuertos reales.
- La emisión de documentación oficial de viaje.
- La operación real de los vuelos.

Los pagos utilizados durante el proyecto serán simulados evitando pagos reales, ya que es un proyecto ficticio.

### Contexto

El sistema se encuentra entre los usuarios finales y los servicios necesarios para gestionar la información de la aerolínea.

Los clientes interactuarán con la web y app, esa interacción se transformará en información que procesará el sistema para finalmente acabar almacenado de forma persistente y poder mostrarse dicha información a los administradores.

---

## Funcionalidades del sistema

Aquí se presenta un resumen agrupado de los requisitos funcionales que más relevancia tienen.

- Gestión de usuarios, acceso y registro mediante google y apple.
- Búsqueda de vuelos ida/vuelta o solo ida.
- Reservas de vuelos previamente buscados.
- Compras y pagos para dicha reserva.
- Gestión de las reservas de los clientes (usuarios y no usuarios).
- Check-in y la generación de la tarjeta de embarque.
- Administración desde el panel correspondiente.

---

## Casos de uso

Puedes encontrar los detalles de los actores implicados en la página correspondiente de [casos de uso](./casos-uso.md).

---

## Diagrama de actividad

El diagrama de actividad proporciona de forma ordenada una visión del funcionamiento del sistema por parte de los usuarios objetivo, para ello, puedes visitar la página dedicada a los [diagramas de actividad](./diagramas-actividad.md).

---

## Diagrama EER

El diagrama Entidad-Relación Extendido representa el modelo conceptual de los datos del sistema, mostrando las principales entidades, las relaciones existentes entre ellas y sus cardinalidades.

El diagrama se puede visitar desde la página [diagrama EER](./modelo-datos/#diagrama-eer).

---

## Diccionario de datos

El diccionario de datos recoge de forma detallada los elementos que componen el modelo de datos del sistema, especificando para cada atributo su tipo de dato, claves, restricciones y descripción.

Su contenido complementa al [diagrama EER](./modelo-datos/#diagrama-eer), proporcionando la información necesaria para interpretar y documentar las entidades y atributos que forman parte del sistema.

El diccionario de datos se puede consultar desde la página [diccionario de datos](./modelo-datos/#diccionario-de-datos).