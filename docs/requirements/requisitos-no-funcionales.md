# Requisitos no funcionales

## Rendimiento

| ID         | Requisito                                                                                                                                                             |
| ---------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **RNF-01** | El sistema deberá responder a las consultas de vuelos en un máximo de **2 segundos** en condiciones normales de funcionamiento.                                       |
| **RNF-02** | El sistema deberá soportar al menos **500 usuarios conectados simultáneamente** sin degradar las funcionalidades principales.                                         |
| **RNF-03** | Las operaciones de búsqueda y filtrado de vuelos deberán mantener un tiempo de respuesta inferior a **2 segundos** con el volumen de datos previsto para el proyecto. |

## Seguridad

| ID         | Requisito                                                                                                                                                      |
| ---------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **RNF-04** | Toda comunicación entre las aplicaciones cliente y el backend deberá realizarse mediante **HTTPS**.                                                            |
| **RNF-05** | Las contraseñas de los usuarios no deberán almacenarse en texto plano en la base de datos.                                                                     |
| **RNF-06** | El sistema deberá impedir que un usuario acceda a las reservas o datos personales pertenecientes a otro usuario sin disponer de los permisos correspondientes. |
| **RNF-07** | Las operaciones administrativas deberán requerir autenticación y autorización mediante el rol correspondiente.                                                 |
| **RNF-08** | Las credenciales y datos sensibles utilizados por el backend no deberán almacenarse directamente en el código fuente.                                          |
| **RNF-09** | El sistema deberá impedir que dos usuarios confirmen simultáneamente el mismo asiento para un vuelo.                                                           |
| **RNF-10** | La creación de una reserva y la asignación de sus asientos deberán realizarse de forma transaccional, evitando reservas parcialmente almacenadas.              |
| **RNF-11** | Una reserva confirmada deberá conservar sus datos aunque el usuario cierre sesión o se reinicie el backend.                                                    |
| **RNF-12** | El sistema deberá mantener la coherencia entre la disponibilidad de asientos almacenada y los asientos mostrados durante el proceso de reserva.                |

## Disponibilidad y recuperación

| ID         | Requisito                                                                                                                           |
| ---------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| **RNF-13** | El sistema deberá mantener una disponibilidad mínima del **99,5 % mensual**, excluyendo los periodos de mantenimiento programado.   |
| **RNF-14** | La base de datos deberá disponer de copias de seguridad con una periodicidad máxima de **24 horas**.                                |
| **RNF-15** | El sistema deberá permitir recuperar la información de las reservas a partir de una copia de seguridad en caso de pérdida de datos. |

## Compatibilidad y accesibilidad

| ID         | Requisito                                                                                                                                           |
| ---------- | --------------------------------------------------------------------------------------------------------------------------------------------------- |
| **RNF-16** | La aplicación web deberá funcionar correctamente en las versiones actuales de **Chrome, Firefox, Edge y Safari**.                                   |
| **RNF-17** | La aplicación móvil deberá funcionar en las versiones de **Android** establecidas como compatibles para el proyecto.                                |
| **RNF-18** | La API deberá proporcionar respuestas compatibles con las aplicaciones web y móvil.                                                                 |
| **RNF-19** | La aplicación web deberá cumplir los criterios aplicables de **WCAG 2.2 nivel AA**.                                                                 |
| **RNF-20** | Las funciones principales de búsqueda, reserva y gestión de vuelos deberán poder utilizarse mediante teclado sin depender exclusivamente del ratón. |
| **RNF-21** | Los formularios deberán proporcionar información comprensible sobre los errores producidos al introducir datos no válidos.                          |
| **RNF-22** | La aplicación web deberá adaptarse a dispositivos de escritorio, tabletas y teléfonos móviles mediante un diseño responsive.                        |

## Arquitectura y mantenimiento

| ID         | Requisito                                                                                                                                         |
| ---------- | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| **RNF-23** | El backend deberá mantener separadas las responsabilidades de presentación, lógica de negocio y acceso a datos.                                   |
| **RNF-24** | La comunicación entre las aplicaciones cliente y el backend deberá realizarse mediante una **API REST**.                                          |
| **RNF-25** | La API deberá utilizar **JSON** como formato de intercambio de datos entre clientes y servidor.                                                   |
| **RNF-26** | Las operaciones de la API deberán utilizar los métodos HTTP correspondientes a la naturaleza de cada operación.                                   |
| **RNF-27** | El sistema deberá permitir modificar o ampliar las funcionalidades de la aplicación sin requerir cambios innecesarios en el resto de componentes. |

## Trazabilidad y protección de datos

| ID         | Requisito                                                                                                                                                  |
| ---------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **RNF-28** | Las operaciones administrativas sobre usuarios, reservas y vuelos deberán quedar registradas junto con el usuario que las realizó y la fecha de ejecución. |
| **RNF-29** | El sistema deberá registrar los errores producidos en el backend para facilitar su diagnóstico y mantenimiento.                                            |
| **RNF-30** | El sistema deberá limitar el acceso a los datos personales de los pasajeros según los permisos del usuario autenticado.                                    |
| **RNF-31** | Los datos personales de los usuarios deberán almacenarse únicamente cuando sean necesarios para proporcionar las funcionalidades del sistema.              |
| **RNF-32** | El sistema deberá mantener la integridad y consistencia de la información relacionada con reservas, pasajeros, vuelos y asientos.                          |
| **RNF-33** | El sistema deberá garantizar que la capacidad disponible de un vuelo sea coherente con la capacidad de la aeronave asignada y las reservas confirmadas.    |
