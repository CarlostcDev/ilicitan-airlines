# Inicio

Según la metodología Waterfall, los requisitos funcionales y no funcionales constatan el primer paso para asegurarse de recoger todas las funcionalidades previstas inicialmente para evitar la menor cantidad de cambios posibles, debido a ello, se puede ver detalladamente todas las funcionalidades propuestas desde [Requisitos funcionales](./requisitos-funcionales.md) y [Requisitos no funcionales](./requisitos-no-funcionales.md).

En la siguiente lista se marcarán las funcionalidades que se hayan implementado, para ello, puede visitar como se van a implementar sobre el sistema propuesto en [Implementación](../implementation/index.md).

## Alcance

Los requisitos definidos en esta sección abarcan las funcionalidades y restricciones principales de la plataforma Ilicitan Airlines, incluyendo la aplicación web, la aplicación móvil, el backend y la gestión de los datos.

Los requisitos contemplan tanto las operaciones realizadas por los usuarios como las funciones disponibles para los administradores.

## Identificación

Los requisitos se identifican mediante un código único:

- **RF-XX** - Requisito funcional.
- **RNF-XX** - Requisito no funcional.

El identificador permite referenciar un requisito desde otras partes de la documentación, como el análisis, la implementación y las pruebas.

---

## Requisitos funcionales

| Estado | ID | Requisito |
|---|---|---|
| :material-checkbox-blank-outline: | **RF-01** | El sistema permitirá a los usuarios crear una cuenta mediante correo electrónico y contraseña. |
| :material-checkbox-blank-outline: | **RF-02** | El sistema permitirá registrarse e iniciar sesión mediante una cuenta de Google. |
| :material-checkbox-blank-outline: | **RF-03** | El usuario podrá iniciar y cerrar sesión desde la aplicación web y móvil. |
| :material-checkbox-blank-outline: | **RF-04** | El usuario podrá consultar y modificar los datos personales almacenados en su perfil. |
| :material-checkbox-blank-outline: | **RF-05** | El usuario podrá establecer, modificar y eliminar su fotografía de perfil. |
| :material-checkbox-blank-outline: | **RF-06** | El sistema utilizará los datos almacenados en el perfil para rellenar automáticamente los datos del pasajero durante una reserva. |
| :material-checkbox-blank-outline: | **RF-07** | El sistema permitirá realizar reservas sin disponer de una cuenta de usuario. |
| :material-checkbox-blank-outline: | **RF-08** | El usuario podrá seleccionar si desea realizar un viaje de ida o de ida y vuelta. |
| :material-checkbox-blank-outline: | **RF-09** | El usuario podrá seleccionar un aeropuerto de origen y uno de destino entre los disponibles. |
| :material-checkbox-blank-outline: | **RF-10** | El sistema mostrará únicamente los destinos para los que existan vuelos desde el aeropuerto de origen seleccionado. |
| :material-checkbox-blank-outline: | **RF-11** | El usuario podrá seleccionar la fecha de salida y, en viajes de ida y vuelta, la fecha de regreso. |
| :material-checkbox-blank-outline: | **RF-12** | El usuario podrá indicar el número de pasajeros, diferenciando entre adultos, niños y bebés. |
| :material-checkbox-blank-outline: | **RF-13** | El sistema permitirá un máximo de 8 pasajeros por reserva. |
| :material-checkbox-blank-outline: | **RF-14** | El usuario podrá seleccionar la clase de viaje disponible, como Economy o Business. |
| :material-checkbox-blank-outline: | **RF-15** | El sistema mostrará los vuelos disponibles que coincidan con los criterios de búsqueda. |
| :material-checkbox-blank-outline: | **RF-16** | El sistema mostrará inicialmente los resultados ordenados por hora de salida local, de más temprano a más tarde. |
| :material-checkbox-blank-outline: | **RF-17** | El usuario podrá ordenar los resultados por criterios como precio, duración u hora de salida. |
| :material-checkbox-blank-outline: | **RF-18** | El usuario podrá aplicar filtros a los resultados de búsqueda según las características disponibles de los vuelos. |
| :material-checkbox-blank-outline: | **RF-19** | El sistema podrá mostrar un mapa con las ciudades desde las que la aerolínea dispone de vuelos, permitiendo seleccionar una de ellas como origen. |
| :material-checkbox-blank-outline: | **RF-20** | El usuario podrá seleccionar la opción "Cualquier lugar" como destino. |
| :material-checkbox-blank-outline: | **RF-21** | Al seleccionar "Cualquier lugar", el sistema podrá mostrar en un mapa los destinos disponibles desde el origen seleccionado. |
| :material-checkbox-blank-outline: | **RF-22** | El sistema podrá mostrar junto a cada destino del mapa el precio más bajo disponible para la fecha seleccionada. |
| :material-checkbox-blank-outline: | **RF-23** | El usuario podrá seleccionar un vuelo de ida entre los resultados obtenidos. |
| :material-checkbox-blank-outline: | **RF-24** | En una reserva de ida y vuelta, el usuario podrá seleccionar posteriormente el vuelo de regreso. |
| :material-checkbox-blank-outline: | **RF-25** | El sistema permitirá introducir los datos correspondientes a cada pasajero de la reserva. |
| :material-checkbox-blank-outline: | **RF-26** | El usuario autenticado podrá utilizar los datos de su perfil para rellenar automáticamente los datos del pasajero. |
| :material-checkbox-blank-outline: | **RF-27** | El usuario podrá seleccionar el asiento de cada pasajero entre los asientos disponibles. |
| :material-checkbox-blank-outline: | **RF-28** | El sistema determinará si la selección del asiento tiene un coste adicional según la clase y las condiciones del vuelo. |
| :material-checkbox-blank-outline: | **RF-29** | El sistema asignará automáticamente el equipaje incluido en la tarifa según las condiciones establecidas. |
| :material-checkbox-blank-outline: | **RF-30** | El usuario podrá añadir equipaje facturado adicional durante el proceso de reserva. |
| :material-checkbox-blank-outline: | **RF-31** | El sistema mostrará las condiciones y dimensiones máximas correspondientes a cada tipo de equipaje. |
| :material-checkbox-blank-outline: | **RF-32** | Antes de confirmar la compra, el sistema mostrará un resumen del viaje, pasajeros, asientos, equipaje, extras y precio total. |
| :material-checkbox-blank-outline: | **RF-33** | El usuario podrá introducir los datos necesarios para la facturación de la compra. |
| :material-checkbox-blank-outline: | **RF-34** | El usuario podrá seleccionar un método de pago durante el proceso de compra. |
| :material-checkbox-blank-outline: | **RF-35** | El sistema permitirá completar la compra mediante un sistema de pago simulado sin realizar una transacción económica real. |
| :material-checkbox-blank-outline: | **RF-36** | Una vez completado el proceso de compra, el sistema generará y confirmará la reserva. |
| :material-checkbox-blank-outline: | **RF-37** | Las reservas realizadas por usuarios autenticados quedarán asociadas a sus cuentas. |
| :material-checkbox-blank-outline: | **RF-38** | El usuario autenticado podrá consultar sus reservas desde el apartado "Mis reservas". |
| :material-checkbox-blank-outline: | **RF-39** | El usuario podrá consultar el detalle de una reserva, incluyendo vuelos, pasajeros, asientos, equipaje, clase y condiciones. |
| :material-checkbox-blank-outline: | **RF-40** | El usuario podrá solicitar la cancelación de una reserva cuando las condiciones del billete lo permitan. |
| :material-checkbox-blank-outline: | **RF-41** | El usuario podrá modificar el asiento asignado cuando exista disponibilidad y las condiciones del billete lo permitan. |
| :material-checkbox-blank-outline: | **RF-42** | El usuario podrá modificar los datos del pasajero que puedan cambiarse sin realizar una nueva reserva. |
| :material-checkbox-blank-outline: | **RF-43** | Los usuarios sin cuenta podrán consultar y gestionar sus reservas mediante los formularios habilitados para ello. |
| :material-checkbox-blank-outline: | **RF-44** | El usuario podrá realizar el check-in desde el detalle de su reserva cuando se encuentre dentro del periodo permitido. |
| :material-checkbox-blank-outline: | **RF-45** | Los usuarios sin cuenta podrán realizar el check-in mediante el formulario de gestión de reservas. |
| :material-checkbox-blank-outline: | **RF-46** | El sistema determinará la disponibilidad del check-in en función de la clase del billete, el tipo de vuelo y el tiempo restante hasta la salida. |
| :material-checkbox-blank-outline: | **RF-47** | El sistema generará una tarjeta de embarque digital después de completar el check-in. |
| :material-checkbox-blank-outline: | **RF-48** | El usuario podrá descargar la tarjeta de embarque generada. |
| :material-checkbox-blank-outline: | **RF-49** | El administrador de usuarios podrá crear, consultar, modificar y eliminar usuarios. |
| :material-checkbox-blank-outline: | **RF-50** | El administrador de usuarios podrá modificar los datos de los perfiles de los usuarios. |
| :material-checkbox-blank-outline: | **RF-51** | El administrador de usuarios podrá consultar, crear, modificar y eliminar reservas. |
| :material-checkbox-blank-outline: | **RF-52** | El administrador de usuarios podrá gestionar las reservas asociadas a cualquier usuario. |
| :material-checkbox-blank-outline: | **RF-53** | El administrador de usuarios dispondrá de un panel independiente para gestionar usuarios y reservas. |
| :material-checkbox-blank-outline: | **RF-54** | El administrador de vuelos podrá crear, consultar, modificar, desactivar y eliminar ciudades y aeropuertos. |
| :material-checkbox-blank-outline: | **RF-55** | El administrador de vuelos podrá crear, consultar, modificar, desactivar y eliminar aeronaves de la flota. |
| :material-checkbox-blank-outline: | **RF-56** | El administrador de vuelos podrá crear, consultar, modificar, desactivar y eliminar vuelos. |
| :material-checkbox-blank-outline: | **RF-57** | El administrador de vuelos podrá asignar una aeronave a un vuelo cuando sea compatible con el recorrido. |
| :material-checkbox-blank-outline: | **RF-58** | El administrador de vuelos podrá activar o desactivar vuelos para controlar su disponibilidad para la venta. |
| :material-checkbox-blank-outline: | **RF-59** | El administrador podrá importar y exportar información relacionada con vuelos, usuarios, aeronaves, aeropuertos y demás entidades gestionadas por el sistema. |

## Requisitos no funcionales

| Estado | ID | Requisito |
|---|---|---|
| :material-checkbox-blank-outline: | **RNF-01** | El sistema deberá responder a las consultas de vuelos en un máximo de **2 segundos** en condiciones normales de funcionamiento. |
| :material-checkbox-blank-outline: | **RNF-02** | El sistema deberá soportar al menos **500 usuarios conectados simultáneamente** sin degradar las funcionalidades principales. |
| :material-checkbox-blank-outline: | **RNF-03** | Las operaciones de búsqueda y filtrado de vuelos deberán mantener un tiempo de respuesta inferior a **2 segundos** con el volumen de datos previsto para el proyecto. |
| :material-checkbox-blank-outline: | **RNF-04** | Toda comunicación entre la aplicación web, la aplicación móvil y el backend deberá realizarse mediante **HTTPS**. |
| :material-checkbox-blank-outline: | **RNF-05** | Las contraseñas de los usuarios no deberán almacenarse en texto plano en la base de datos. |
| :material-checkbox-blank-outline: | **RNF-06** | El sistema deberá impedir que un usuario acceda a las reservas o datos personales pertenecientes a otro usuario. |
| :material-checkbox-blank-outline: | **RNF-07** | Las operaciones administrativas deberán requerir autenticación y autorización mediante el rol correspondiente. |
| :material-checkbox-blank-outline: | **RNF-08** | Las credenciales y datos sensibles utilizados por el backend no deberán almacenarse directamente en el código fuente. |
| :material-checkbox-blank-outline: | **RNF-09** | El sistema deberá impedir que dos usuarios confirmen simultáneamente el mismo asiento para un vuelo. |
| :material-checkbox-blank-outline: | **RNF-10** | La creación de una reserva y la asignación de sus asientos deberán realizarse de forma transaccional, evitando reservas parcialmente almacenadas. |
| :material-checkbox-blank-outline: | **RNF-11** | Una reserva confirmada deberá conservar sus datos aunque el usuario cierre sesión o se reinicie el backend. |
| :material-checkbox-blank-outline: | **RNF-12** | El sistema deberá mantener la coherencia entre la disponibilidad de asientos almacenada y los asientos mostrados durante el proceso de reserva. |
| :material-checkbox-blank-outline: | **RNF-13** | El sistema deberá mantener una disponibilidad mínima del **99,5 % mensual**, excluyendo los periodos de mantenimiento programado. |
| :material-checkbox-blank-outline: | **RNF-14** | La base de datos deberá disponer de copias de seguridad con una periodicidad máxima de **24 horas**. |
| :material-checkbox-blank-outline: | **RNF-15** | El sistema deberá permitir recuperar la información de las reservas a partir de una copia de seguridad en caso de pérdida de datos. |
| :material-checkbox-blank-outline: | **RNF-16** | La aplicación web deberá funcionar correctamente en las versiones actuales de **Chrome, Firefox, Edge y Safari**. |
| :material-checkbox-blank-outline: | **RNF-17** | La aplicación móvil deberá funcionar en las versiones de **Android** establecidas como compatibles para el proyecto. |
| :material-checkbox-blank-outline: | **RNF-18** | La API deberá proporcionar respuestas compatibles tanto con la aplicación web como con la aplicación móvil. |
| :material-checkbox-blank-outline: | **RNF-19** | La aplicación web deberá cumplir los criterios aplicables de **WCAG 2.2 nivel AA**. |
| :material-checkbox-blank-outline: | **RNF-20** | Las funciones principales de búsqueda, reserva y gestión de vuelos deberán poder utilizarse mediante teclado sin depender exclusivamente del ratón. |
| :material-checkbox-blank-outline: | **RNF-21** | Los formularios deberán proporcionar información comprensible sobre los errores producidos al introducir datos no válidos. |
| :material-checkbox-blank-outline: | **RNF-22** | La aplicación web deberá adaptarse a dispositivos de escritorio, tabletas y teléfonos móviles mediante un diseño responsive. |
| :material-checkbox-blank-outline: | **RNF-23** | El backend deberá mantener separadas las responsabilidades de presentación, lógica de negocio y acceso a datos. |
| :material-checkbox-blank-outline: | **RNF-24** | La comunicación entre los clientes web y móvil y el backend deberá realizarse mediante una **API REST**. |
| :material-checkbox-blank-outline: | **RNF-25** | La API deberá utilizar **JSON** como formato de intercambio de datos entre clientes y servidor. |
| :material-checkbox-blank-outline: | **RNF-26** | Las operaciones de la API deberán utilizar los métodos HTTP correspondientes a la naturaleza de cada operación. |
| :material-checkbox-blank-outline: | **RNF-27** | El sistema deberá permitir modificar o ampliar las funcionalidades de la aplicación sin requerir cambios innecesarios en el resto de componentes. |
| :material-checkbox-blank-outline: | **RNF-28** | Las operaciones administrativas sobre usuarios, reservas y vuelos deberán quedar registradas junto con el usuario que las realizó y la fecha de ejecución. |
| :material-checkbox-blank-outline: | **RNF-29** | El sistema deberá registrar los errores producidos en el backend para facilitar su diagnóstico y mantenimiento. |
| :material-checkbox-blank-outline: | **RNF-30** | El sistema deberá limitar el acceso a los datos personales de los pasajeros según los permisos del usuario autenticado. |
| :material-checkbox-blank-outline: | **RNF-31** | Los datos personales de los usuarios deberán almacenarse únicamente cuando sean necesarios para proporcionar las funcionalidades del sistema. |
