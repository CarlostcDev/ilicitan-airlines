# Requisitos funcionales

## Gestión de usuarios

| ID | Requisito |
|---|---|
| **RF-01** | El sistema permitirá a los usuarios crear una cuenta mediante correo electrónico y contraseña. |
| **RF-02** | El sistema permitirá registrarse e iniciar sesión mediante una cuenta de Google. |
| **RF-03** | El usuario podrá iniciar y cerrar sesión desde la aplicación web y móvil. |
| **RF-04** | El usuario podrá consultar y modificar los datos personales almacenados en su perfil. |
| **RF-05** | El usuario podrá establecer, modificar y eliminar su fotografía de perfil. |
| **RF-06** | El sistema utilizará los datos almacenados en el perfil para rellenar automáticamente los datos del pasajero durante una reserva. |
| **RF-07** | El sistema permitirá realizar reservas sin disponer de una cuenta de usuario. |

## Búsqueda de vuelos

| ID | Requisito |
|---|---|
| **RF-08** | El usuario podrá seleccionar si desea realizar un viaje de ida o de ida y vuelta. |
| **RF-09** | El usuario podrá seleccionar un aeropuerto de origen y uno de destino entre los disponibles. |
| **RF-10** | El sistema mostrará únicamente los destinos para los que existan vuelos desde el aeropuerto de origen seleccionado. |
| **RF-11** | El usuario podrá seleccionar la fecha de salida y, en viajes de ida y vuelta, la fecha de regreso. |
| **RF-12** | El usuario podrá indicar el número de pasajeros, diferenciando entre adultos, niños y bebés. |
| **RF-13** | El sistema permitirá un máximo de 8 pasajeros por reserva. |
| **RF-14** | El usuario podrá seleccionar la clase de viaje disponible, como Economy o Business. |
| **RF-15** | El sistema mostrará los vuelos disponibles que coincidan con los criterios de búsqueda. |
| **RF-16** | El sistema mostrará inicialmente los resultados ordenados por hora de salida local, de más temprano a más tarde. |
| **RF-17** | El usuario podrá ordenar los resultados por criterios como precio, duración u hora de salida. |
| **RF-18** | El usuario podrá aplicar filtros a los resultados de búsqueda según las características disponibles de los vuelos. |

## Funcionalidades adicionales de búsqueda

| ID | Requisito |
|---|---|
| **RF-19** | El sistema podrá mostrar un mapa con las ciudades desde las que la aerolínea dispone de vuelos, permitiendo seleccionar una de ellas como origen. |
| **RF-20** | El usuario podrá seleccionar la opción "Cualquier lugar" como destino. |
| **RF-21** | Al seleccionar "Cualquier lugar", el sistema podrá mostrar en un mapa los destinos disponibles desde el origen seleccionado. |
| **RF-22** | El sistema podrá mostrar junto a cada destino del mapa el precio más bajo disponible para la fecha seleccionada. |

## Proceso de reserva

| ID | Requisito |
|---|---|
| **RF-23** | El usuario podrá seleccionar un vuelo de ida entre los resultados obtenidos. |
| **RF-24** | En una reserva de ida y vuelta, el usuario podrá seleccionar posteriormente el vuelo de regreso. |
| **RF-25** | El sistema permitirá introducir los datos correspondientes a cada pasajero de la reserva. |
| **RF-26** | El usuario autenticado podrá utilizar los datos de su perfil para rellenar automáticamente los datos del pasajero. |
| **RF-27** | El usuario podrá seleccionar el asiento de cada pasajero entre los asientos disponibles. |
| **RF-28** | El sistema determinará si la selección del asiento tiene un coste adicional según la clase y las condiciones del vuelo. |
| **RF-29** | El sistema asignará automáticamente el equipaje incluido en la tarifa según las condiciones establecidas. |
| **RF-30** | El usuario podrá añadir equipaje facturado adicional durante el proceso de reserva. |
| **RF-31** | El sistema mostrará las condiciones y dimensiones máximas correspondientes a cada tipo de equipaje. |

## Proceso de compra

| ID | Requisito |
|---|---|
| **RF-32** | Antes de confirmar la compra, el sistema mostrará un resumen del viaje, pasajeros, asientos, equipaje, extras y precio total. |
| **RF-33** | El usuario podrá introducir los datos necesarios para la facturación de la compra. |
| **RF-34** | El usuario podrá seleccionar un método de pago durante el proceso de compra. |
| **RF-35** | El sistema permitirá completar la compra mediante un sistema de pago simulado sin realizar una transacción económica real. |
| **RF-36** | Una vez completado el proceso de compra, el sistema generará y confirmará la reserva. |
| **RF-37** | Las reservas realizadas por usuarios autenticados quedarán asociadas a sus cuentas. |

## Gestión de reservas

| ID | Requisito |
|---|---|
| **RF-38** | El usuario autenticado podrá consultar sus reservas desde el apartado "Mis reservas". |
| **RF-39** | El usuario podrá consultar el detalle de una reserva, incluyendo vuelos, pasajeros, asientos, equipaje, clase y condiciones. |
| **RF-40** | El usuario podrá solicitar la cancelación de una reserva cuando las condiciones del billete lo permitan. |
| **RF-41** | El usuario podrá modificar el asiento asignado cuando exista disponibilidad y las condiciones del billete lo permitan. |
| **RF-42** | El usuario podrá modificar los datos del pasajero que puedan cambiarse sin realizar una nueva reserva. |
| **RF-43** | Los usuarios sin cuenta podrán consultar y gestionar sus reservas mediante los formularios habilitados para ello. |

## Check-in y embarque

| ID | Requisito |
|---|---|
| **RF-44** | El usuario podrá realizar el check-in desde el detalle de su reserva cuando se encuentre dentro del periodo permitido. |
| **RF-45** | Los usuarios sin cuenta podrán realizar el check-in mediante el formulario de gestión de reservas. |
| **RF-46** | El sistema determinará la disponibilidad del check-in en función de la clase del billete, el tipo de vuelo y el tiempo restante hasta la salida. |
| **RF-47** | El sistema generará una tarjeta de embarque digital después de completar el check-in. |
| **RF-48** | El usuario podrá descargar la tarjeta de embarque generada. |

## Administración de usuarios y reservas

| ID | Requisito |
|---|---|
| **RF-49** | El administrador de usuarios podrá crear, consultar, modificar y eliminar usuarios. |
| **RF-50** | El administrador de usuarios podrá modificar los datos de los perfiles de los usuarios. |
| **RF-51** | El administrador de usuarios podrá consultar, crear, modificar y eliminar reservas. |
| **RF-52** | El administrador de usuarios podrá gestionar las reservas asociadas a cualquier usuario. |
| **RF-53** | El administrador de usuarios dispondrá de un panel independiente para gestionar usuarios y reservas. |

## Administración de vuelos y recursos

| ID | Requisito |
|---|---|
| **RF-54** | El administrador de vuelos podrá crear, consultar, modificar, desactivar y eliminar ciudades y aeropuertos. |
| **RF-55** | El administrador de vuelos podrá crear, consultar, modificar, desactivar y eliminar aeronaves de la flota. |
| **RF-56** | El administrador de vuelos podrá crear, consultar, modificar, desactivar y eliminar vuelos. |
| **RF-57** | El administrador de vuelos podrá asignar una aeronave a un vuelo cuando sea compatible con el recorrido. |
| **RF-58** | El administrador de vuelos podrá activar o desactivar vuelos para controlar su disponibilidad para la venta. |
| **RF-59** | El administrador podrá importar y exportar información relacionada con vuelos, usuarios, aeronaves, aeropuertos y demás entidades gestionadas por el sistema. |
| **RF-60** | El usuario deberá tener una lista de aeropuertos cercanos al seleccionar un aeropuerto origen |
