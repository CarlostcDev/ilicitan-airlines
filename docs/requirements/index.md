# Inicio

Se pueden ver detalladamente todas las funcionalidades propuestas desde [Requisitos funcionales](./requisitos-funcionales.md) y [Requisitos no funcionales](./requisitos-no-funcionales.md).

## Alcance

Los requisitos definidos en esta sección abarcan las funcionalidades y restricciones principales de la plataforma Ilicitan Airlines, incluyendo la aplicación web, la aplicación móvil, el backend y la gestión de los datos.

Los requisitos contemplan tanto las operaciones realizadas por los usuarios como las funciones disponibles para los administradores.

## Identificación

Los requisitos se identifican mediante un código único:

* **RF-XX** - Requisito funcional.
* **RNF-XX** - Requisito no funcional.
* **RN-XX** - Regla de negocio.

El identificador permite referenciar un requisito desde otras partes de la documentación, como el análisis, la implementación y las pruebas.

---

## Lista de funciones

En la siguiente lista se marcarán las funcionalidades que se hayan implementado, para ello, puede visitar cómo se van a implementar sobre el sistema propuesto en [Implementación](../implementation/index.md).


=== "Requisitos funcionales"

    | Estado | ID | Requisito |
    | --- | --- | --- |
    | :material-checkbox-blank-outline: | **RF-01** | El sistema permitirá a los usuarios crear una cuenta mediante correo electrónico y contraseña. |
    | :material-checkbox-blank-outline: | **RF-02** | El sistema permitirá registrarse e iniciar sesión mediante una cuenta de Google. |
    | :material-checkbox-blank-outline: | **RF-03** | El sistema permitirá registrarse e iniciar sesión mediante una cuenta de Apple. |
    | :material-checkbox-blank-outline: | **RF-04** | El usuario podrá iniciar y cerrar sesión desde la aplicación web y móvil. |
    | :material-checkbox-blank-outline: | **RF-05** | El usuario podrá consultar y modificar los datos personales almacenados en su perfil. |
    | :material-checkbox-blank-outline: | **RF-06** | El usuario podrá establecer, modificar y eliminar su fotografía de perfil. |
    | :material-checkbox-blank-outline: | **RF-07** | El sistema utilizará los datos almacenados en el perfil para rellenar automáticamente los datos del pasajero durante una reserva. |
    | :material-checkbox-blank-outline: | **RF-08** | El sistema permitirá realizar reservas sin disponer de una cuenta de usuario. |
    | :material-checkbox-blank-outline: | **RF-09** | El usuario podrá seleccionar si desea realizar un viaje de ida o de ida y vuelta. |
    | :material-checkbox-blank-outline: | **RF-10** | El usuario podrá seleccionar un aeropuerto de origen y uno de destino entre los disponibles. |
    | :material-checkbox-blank-outline: | **RF-11** | El sistema mostrará únicamente los destinos para los que existan vuelos desde el aeropuerto de origen seleccionado. |
    | :material-checkbox-blank-outline: | **RF-12** | El usuario podrá seleccionar la fecha de salida y, en viajes de ida y vuelta, la fecha de regreso. |
    | :material-checkbox-blank-outline: | **RF-13** | El usuario podrá indicar el número de pasajeros, diferenciando entre adultos, niños y bebés. |
    | :material-checkbox-blank-outline: | **RF-14** | El sistema permitirá un máximo de 8 pasajeros por reserva. |
    | :material-checkbox-blank-outline: | **RF-15** | El usuario podrá seleccionar la clase de viaje disponible, como Economy o Business. |
    | :material-checkbox-blank-outline: | **RF-16** | El sistema mostrará los vuelos disponibles que coincidan con los criterios de búsqueda. |
    | :material-checkbox-blank-outline: | **RF-17** | El sistema mostrará inicialmente los resultados ordenados por hora de salida local, de más temprano a más tarde. |
    | :material-checkbox-blank-outline: | **RF-18** | El usuario podrá ordenar los resultados por criterios como precio, duración u hora de salida. |
    | :material-checkbox-blank-outline: | **RF-19** | El usuario podrá aplicar filtros a los resultados de búsqueda según las características disponibles de los vuelos. |
    | :material-checkbox-blank-outline: | **RF-20** | El sistema no mostrará como disponibles para la reserva los vuelos que hayan alcanzado la capacidad máxima de pasajeros. |
    | :material-checkbox-blank-outline: | **RF-21** | El sistema podrá mostrar un mapa con las ciudades desde las que la aerolínea dispone de vuelos, permitiendo seleccionar una de ellas como origen. |
    | :material-checkbox-blank-outline: | **RF-22** | El usuario podrá seleccionar la opción "Cualquier lugar" como destino. |
    | :material-checkbox-blank-outline: | **RF-23** | Al seleccionar "Cualquier lugar", el sistema podrá mostrar en un mapa los destinos disponibles desde el origen seleccionado. |
    | :material-checkbox-blank-outline: | **RF-24** | El sistema podrá mostrar junto a cada destino del mapa el precio más bajo disponible para la fecha seleccionada. |
    | :material-checkbox-blank-outline: | **RF-25** | El sistema podrá proporcionar una lista de aeropuertos cercanos al seleccionar un aeropuerto de origen. |
    | :material-checkbox-blank-outline: | **RF-26** | El usuario podrá seleccionar un vuelo de ida entre los resultados obtenidos. |
    | :material-checkbox-blank-outline: | **RF-27** | En una reserva de ida y vuelta, el usuario podrá seleccionar posteriormente el vuelo de regreso. |
    | :material-checkbox-blank-outline: | **RF-28** | El sistema permitirá introducir los datos correspondientes a cada pasajero de la reserva. |
    | :material-checkbox-blank-outline: | **RF-29** | El usuario autenticado podrá utilizar los datos de su perfil para rellenar automáticamente los datos del pasajero. |
    | :material-checkbox-blank-outline: | **RF-30** | El usuario podrá seleccionar el asiento de cada pasajero entre los asientos disponibles. |
    | :material-checkbox-blank-outline: | **RF-31** | El sistema determinará si la selección del asiento tiene un coste adicional según las condiciones aplicables a la reserva. |
    | :material-checkbox-blank-outline: | **RF-32** | El sistema asignará automáticamente el equipaje incluido en la tarifa según las condiciones establecidas. |
    | :material-checkbox-blank-outline: | **RF-33** | El usuario podrá añadir equipaje facturado adicional durante el proceso de reserva. |
    | :material-checkbox-blank-outline: | **RF-34** | El sistema mostrará las condiciones y dimensiones máximas correspondientes a cada tipo de equipaje. |
    | :material-checkbox-blank-outline: | **RF-35** | Antes de confirmar la compra, el sistema mostrará un resumen del viaje, pasajeros, asientos, equipaje, extras y precio total. |
    | :material-checkbox-blank-outline: | **RF-36** | El usuario podrá introducir los datos necesarios para la facturación de la compra. |
    | :material-checkbox-blank-outline: | **RF-37** | El usuario podrá seleccionar un método de pago durante el proceso de compra. |
    | :material-checkbox-blank-outline: | **RF-38** | El sistema permitirá completar la compra mediante un sistema de pago simulado sin realizar una transacción económica real. |
    | :material-checkbox-blank-outline: | **RF-39** | Una vez completado el proceso de compra, el sistema generará y confirmará la reserva. |
    | :material-checkbox-blank-outline: | **RF-40** | Las reservas realizadas por usuarios autenticados quedarán asociadas a sus cuentas. |
    | :material-checkbox-blank-outline: | **RF-41** | El usuario autenticado podrá consultar sus reservas desde el apartado "Mis reservas". |
    | :material-checkbox-blank-outline: | **RF-42** | El usuario podrá consultar el detalle de una reserva, incluyendo vuelos, pasajeros, asientos, equipaje, clase y condiciones. |
    | :material-checkbox-blank-outline: | **RF-43** | El usuario podrá solicitar la cancelación de una reserva cuando las condiciones del billete lo permitan. |
    | :material-checkbox-blank-outline: | **RF-44** | El usuario podrá modificar el asiento asignado cuando exista disponibilidad y las condiciones del billete lo permitan. |
    | :material-checkbox-blank-outline: | **RF-45** | El usuario podrá modificar los datos del pasajero que puedan cambiarse sin realizar una nueva reserva. |
    | :material-checkbox-blank-outline: | **RF-46** | Los usuarios sin cuenta podrán consultar y gestionar sus reservas mediante los mecanismos habilitados para ello. |
    | :material-checkbox-blank-outline: | **RF-47** | El usuario podrá consultar individualmente cada vuelo incluido en una reserva. |
    | :material-checkbox-blank-outline: | **RF-48** | El usuario registrado podrá iniciar el proceso de check-in desde el detalle del vuelo de una reserva asociada a su cuenta. |
    | :material-checkbox-blank-outline: | **RF-49** | El usuario sin cuenta podrá iniciar el proceso de check-in mediante un mecanismo de identificación basado en el código identificativo de la reserva y los apellidos correspondientes. |
    | :material-checkbox-blank-outline: | **RF-50** | El sistema verificará que el código identificativo y los apellidos introducidos correspondan con una reserva válida antes de permitir el check-in. |
    | :material-checkbox-blank-outline: | **RF-51** | El sistema permitirá realizar el check-in únicamente durante el periodo habilitado para el vuelo correspondiente. |
    | :material-checkbox-blank-outline: | **RF-52** | Para vuelos internacionales, el sistema permitirá realizar el check-in desde 48 horas antes de la hora prevista de salida hasta 2 horas antes de dicha salida. |
    | :material-checkbox-blank-outline: | **RF-53** | Para vuelos nacionales, el sistema permitirá realizar el check-in desde 24 horas antes de la hora prevista de salida hasta 2 horas antes de dicha salida. |
    | :material-checkbox-blank-outline: | **RF-54** | El sistema permitirá consultar la fecha y hora exactas de apertura del check-in cuando todavía no se encuentre disponible. |
    | :material-checkbox-blank-outline: | **RF-55** | El sistema impedirá iniciar el proceso de check-in cuando los datos de identificación proporcionados por un usuario sin cuenta no correspondan con la reserva. |
    | :material-checkbox-blank-outline: | **RF-56** | El sistema mostrará un resumen del vuelo y de los pasajeros antes de completar el check-in. |
    | :material-checkbox-blank-outline: | **RF-57** | El usuario podrá consultar y modificar los datos API/APIS de los pasajeros durante el proceso de check-in. |
    | :material-checkbox-blank-outline: | **RF-58** | El sistema realizará el check-in de todos los pasajeros de la reserva correspondientes al vuelo seleccionado. |
    | :material-checkbox-blank-outline: | **RF-59** | Si un pasajero no dispone de asiento asignado al realizar el check-in, el sistema le asignará uno entre los asientos disponibles. |
    | :material-checkbox-blank-outline: | **RF-60** | El sistema generará una tarjeta de embarque para cada pasajero incluido en el check-in. |
    | :material-checkbox-blank-outline: | **RF-61** | El sistema permitirá obtener las tarjetas de embarque correspondientes a todos los pasajeros del vuelo que haya sido facturado. |
    | :material-checkbox-blank-outline: | **RF-62** | El usuario podrá descargar en formato PDF las tarjetas de embarque generadas después del check-in. |
    | :material-checkbox-blank-outline: | **RF-63** | El sistema no permitirá realizar nuevamente el proceso de check-in sobre un vuelo que ya haya sido facturado. |
    | :material-checkbox-blank-outline: | **RF-64** | Si el usuario vuelve a acceder al check-in de un vuelo ya facturado, el sistema permitirá obtener nuevamente las tarjetas de embarque correspondientes. |
    | :material-checkbox-blank-outline: | **RF-65** | En la aplicación móvil, el sistema permitirá consultar la tarjeta de embarque del vuelo facturado para su utilización durante el embarque. |
    | :material-checkbox-blank-outline: | **RF-66** | En la aplicación móvil, el usuario podrá descargar las tarjetas de embarque en formato PDF. |
    | :material-checkbox-blank-outline: | **RF-67** | En la aplicación móvil, el usuario podrá añadir las tarjetas de embarque a servicios de cartera digital compatibles. |
    | :material-checkbox-blank-outline: | **RF-68** | El sistema realizará el check-in de cada vuelo de una reserva de forma independiente. |
    | :material-checkbox-blank-outline: | **RF-69** | En una reserva de ida y vuelta, el usuario podrá realizar inicialmente el check-in del vuelo cuya ventana de check-in se encuentre abierta y deberá realizar posteriormente el check-in del vuelo de regreso cuando se abra su correspondiente periodo. |
    | :material-checkbox-blank-outline: | **RF-70** | El administrador de usuarios podrá crear, consultar, modificar y eliminar usuarios. |
    | :material-checkbox-blank-outline: | **RF-71** | El administrador de usuarios podrá modificar los datos de los perfiles de los usuarios. |
    | :material-checkbox-blank-outline: | **RF-72** | El administrador de usuarios podrá consultar, crear, modificar y eliminar reservas. |
    | :material-checkbox-blank-outline: | **RF-73** | El administrador de usuarios podrá gestionar las reservas asociadas a cualquier usuario. |
    | :material-checkbox-blank-outline: | **RF-74** | El administrador de usuarios dispondrá de un panel independiente para gestionar usuarios y reservas. |
    | :material-checkbox-blank-outline: | **RF-75** | El administrador de vuelos podrá crear, consultar, modificar, desactivar y eliminar ciudades y aeropuertos. |
    | :material-checkbox-blank-outline: | **RF-76** | El administrador de vuelos podrá crear, consultar, modificar, desactivar y eliminar aeronaves de la flota. |
    | :material-checkbox-blank-outline: | **RF-77** | El administrador de vuelos podrá crear, consultar, modificar, desactivar y eliminar vuelos. |
    | :material-checkbox-blank-outline: | **RF-78** | El administrador de vuelos podrá asignar una aeronave a un vuelo cuando sea compatible con el recorrido. |
    | :material-checkbox-blank-outline: | **RF-79** | El administrador de vuelos podrá activar o desactivar vuelos para controlar su disponibilidad para la venta. |
    | :material-checkbox-blank-outline: | **RF-80** | El administrador podrá importar y exportar información relacionada con vuelos, usuarios, aeronaves, aeropuertos y demás entidades gestionadas por el sistema. |

=== "Requisitos no funcionales"

    | Estado | ID | Requisito |
    | --- | --- | --- |
    | :material-checkbox-blank-outline: | **RNF-01** | El sistema deberá responder a las consultas de vuelos en un máximo de **2 segundos** en condiciones normales de funcionamiento. |
    | :material-checkbox-blank-outline: | **RNF-02** | El sistema deberá soportar al menos **500 usuarios conectados simultáneamente** sin degradar las funcionalidades principales. |
    | :material-checkbox-blank-outline: | **RNF-03** | Las operaciones de búsqueda y filtrado de vuelos deberán mantener un tiempo de respuesta inferior a **2 segundos** con el volumen de datos previsto para el proyecto. |
    | :material-checkbox-blank-outline: | **RNF-04** | Toda comunicación entre las aplicaciones cliente y el backend deberá realizarse mediante **HTTPS**. |
    | :material-checkbox-blank-outline: | **RNF-05** | Las contraseñas de los usuarios no deberán almacenarse en texto plano en la base de datos. |
    | :material-checkbox-blank-outline: | **RNF-06** | El sistema deberá impedir que un usuario acceda a las reservas o datos personales pertenecientes a otro usuario sin disponer de los permisos correspondientes. |
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
    | :material-checkbox-blank-outline: | **RNF-18** | La API deberá proporcionar respuestas compatibles con las aplicaciones web y móvil. |
    | :material-checkbox-blank-outline: | **RNF-19** | La aplicación web deberá cumplir los criterios aplicables de **WCAG 2.2 nivel AA**. |
    | :material-checkbox-blank-outline: | **RNF-20** | Las funciones principales de búsqueda, reserva y gestión de vuelos deberán poder utilizarse mediante teclado sin depender exclusivamente del ratón. |
    | :material-checkbox-blank-outline: | **RNF-21** | Los formularios deberán proporcionar información comprensible sobre los errores producidos al introducir datos no válidos. |
    | :material-checkbox-blank-outline: | **RNF-22** | La aplicación web deberá adaptarse a dispositivos de escritorio, tabletas y teléfonos móviles mediante un diseño responsive. |
    | :material-checkbox-blank-outline: | **RNF-23** | El backend deberá mantener separadas las responsabilidades de presentación, lógica de negocio y acceso a datos. |
    | :material-checkbox-blank-outline: | **RNF-24** | La comunicación entre las aplicaciones cliente y el backend deberá realizarse mediante una **API REST**. |
    | :material-checkbox-blank-outline: | **RNF-25** | La API deberá utilizar **JSON** como formato de intercambio de datos entre clientes y servidor. |
    | :material-checkbox-blank-outline: | **RNF-26** | Las operaciones de la API deberán utilizar los métodos HTTP correspondientes a la naturaleza de cada operación. |
    | :material-checkbox-blank-outline: | **RNF-27** | El sistema deberá permitir modificar o ampliar las funcionalidades de la aplicación sin requerir cambios innecesarios en el resto de componentes. |
    | :material-checkbox-blank-outline: | **RNF-28** | Las operaciones administrativas sobre usuarios, reservas y vuelos deberán quedar registradas junto con el usuario que las realizó y la fecha de ejecución. |
    | :material-checkbox-blank-outline: | **RNF-29** | El sistema deberá registrar los errores producidos en el backend para facilitar su diagnóstico y mantenimiento. |
    | :material-checkbox-blank-outline: | **RNF-30** | El sistema deberá limitar el acceso a los datos personales de los pasajeros según los permisos del usuario autenticado. |
    | :material-checkbox-blank-outline: | **RNF-31** | Los datos personales de los usuarios deberán almacenarse únicamente cuando sean necesarios para proporcionar las funcionalidades del sistema. |
    | :material-checkbox-blank-outline: | **RNF-32** | El sistema deberá mantener la integridad y consistencia de la información relacionada con reservas, pasajeros, vuelos y asientos. |
    | :material-checkbox-blank-outline: | **RNF-33** | El sistema deberá garantizar que la capacidad disponible de un vuelo sea coherente con la capacidad de la aeronave asignada y las reservas confirmadas. |

=== "Reglas de negocio"

    | Estado | ID | Regla |
    | --- | --- | --- |
    | :material-checkbox-blank-outline: | **RN-01** | Cada dirección de correo electrónico podrá estar asociada a una única cuenta de usuario. |
    | :material-checkbox-blank-outline: | **RN-02** | Una cuenta creada mediante correo electrónico y contraseña, Google o Apple no podrá utilizar posteriormente el mismo correo electrónico para crear una segunda cuenta mediante otro método de registro. |
    | :material-checkbox-blank-outline: | **RN-03** | Un usuario podrá realizar múltiples reservas, siempre que cada una cumpla las condiciones establecidas por el sistema. |
    | :material-checkbox-blank-outline: | **RN-04** | No se podrá realizar una reserva para un vuelo cuya fecha de salida ya haya pasado. |
    | :material-checkbox-blank-outline: | **RN-05** | Un usuario únicamente podrá consultar y gestionar las reservas asociadas a su propia cuenta. |
    | :material-checkbox-blank-outline: | **RN-06** | Una reserva podrá incluir como máximo 8 pasajeros. |
    | :material-checkbox-blank-outline: | **RN-07** | La clase de viaje seleccionada para una reserva se aplicará a todos los pasajeros incluidos en dicha reserva. |
    | :material-checkbox-blank-outline: | **RN-08** | Los usuarios registrados mediante correo electrónico y contraseña recibirán una fotografía de perfil predeterminada cuando no dispongan de una fotografía propia. |
    | :material-checkbox-blank-outline: | **RN-09** | Los usuarios registrados mediante Google utilizarán como fotografía de perfil la proporcionada por su cuenta de Google cuando esté disponible; en caso contrario, se utilizará una fotografía predeterminada. |
    | :material-checkbox-blank-outline: | **RN-10** | Los usuarios registrados mediante Apple utilizarán como fotografía de perfil la proporcionada por su cuenta de Apple cuando esté disponible; en caso contrario, se utilizará una fotografía predeterminada. |
    | :material-checkbox-blank-outline: | **RN-11** | Un vuelo deberá tener un aeropuerto de origen y un aeropuerto de destino diferentes. |
    | :material-checkbox-blank-outline: | **RN-12** | Los administradores no accederán a las funciones destinadas a los usuarios normales, sino únicamente a las funciones administrativas correspondientes a su rol. |
    | :material-checkbox-blank-outline: | **RN-13** | Los administradores podrán importar y exportar información del sistema mediante archivos en formato CSV. |
    | :material-checkbox-blank-outline: | **RN-14** | Un asiento no podrá estar asignado simultáneamente a más de un pasajero en un mismo vuelo. |
    | :material-checkbox-blank-outline: | **RN-15** | Un vuelo no podrá tener más pasajeros que la capacidad máxima de la aeronave asignada. |
    | :material-checkbox-blank-outline: | **RN-16** | La aeronave asignada a un vuelo deberá ser compatible con las características y condiciones establecidas para dicho vuelo. |
    | :material-checkbox-blank-outline: | **RN-17** | Los datos de una reserva confirmada deberán conservarse independientemente de que el usuario cierre sesión o deje de utilizar temporalmente la aplicación. |
    | :material-checkbox-blank-outline: | **RN-18** | Las operaciones administrativas estarán limitadas a las funciones autorizadas para el rol correspondiente. |
    | :material-checkbox-blank-outline: | **RN-19** | La disponibilidad de un asiento deberá actualizarse cuando sea asignado a un pasajero, evitando que pueda ser asignado posteriormente a otro pasajero del mismo vuelo. |
    | :material-checkbox-blank-outline: | **RN-20** | Una reserva de ida y vuelta deberá estar formada por un vuelo de ida y un vuelo de regreso compatibles con las fechas seleccionadas. |
    | :material-checkbox-blank-outline: | **RN-21** | Las condiciones de modificación y cancelación de una reserva deberán respetar las condiciones establecidas para el billete adquirido. |
    | :material-checkbox-blank-outline: | **RN-22** | La disponibilidad del check-in estará determinada por el tipo de vuelo y el periodo establecido para realizarlo. |
    | :material-checkbox-blank-outline: | **RN-23** | El check-in de un vuelo internacional podrá realizarse desde 48 horas antes de su salida y hasta 2 horas antes de la misma. |
    | :material-checkbox-blank-outline: | **RN-24** | El check-in de un vuelo nacional podrá realizarse desde 24 horas antes de su salida y hasta 2 horas antes de la misma. |
    | :material-checkbox-blank-outline: | **RN-25** | El check-in se realizará de forma independiente para cada vuelo incluido en una reserva. |
    | :material-checkbox-blank-outline: | **RN-26** | En una reserva de ida y vuelta, el check-in del vuelo de ida no implicará el check-in del vuelo de regreso. |
    | :material-checkbox-blank-outline: | **RN-27** | El check-in de una reserva se realizará para todos los pasajeros asociados al vuelo seleccionado. |
    | :material-checkbox-blank-outline: | **RN-28** | Cuando un pasajero no disponga de un asiento asignado al realizar el check-in, deberá recibir uno de los asientos disponibles del vuelo. |
    | :material-checkbox-blank-outline: | **RN-29** | Una vez realizado el check-in de un vuelo, no podrá volver a realizarse el proceso de check-in sobre ese mismo vuelo. |
    | :material-checkbox-blank-outline: | **RN-30** | Las tarjetas de embarque generadas corresponderán únicamente a los pasajeros y vuelos que hayan completado el proceso de check-in. |
    | :material-checkbox-blank-outline: | **RN-31** | Los datos API/APIS de los pasajeros podrán ser modificados durante el proceso de check-in antes de su confirmación. |
    | :material-checkbox-blank-outline: | **RN-32** | Los datos de un usuario no podrán ser modificados ni eliminados por otro usuario que no disponga de los permisos administrativos correspondientes. |

