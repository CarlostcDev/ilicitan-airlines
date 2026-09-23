# Requisitos funcionales

## Gestión de usuarios

| ID        | Requisito                                                                                                                         |
| --------- | --------------------------------------------------------------------------------------------------------------------------------- |
| **RF-01** | El sistema permitirá a los usuarios crear una cuenta mediante correo electrónico y contraseña.                                    |
| **RF-02** | El sistema permitirá registrarse e iniciar sesión mediante una cuenta de Google.                                                  |
| **RF-03** | El sistema permitirá registrarse e iniciar sesión mediante una cuenta de Apple.                                                   |
| **RF-04** | El usuario podrá iniciar y cerrar sesión desde la aplicación web y móvil.                                                         |
| **RF-05** | El usuario podrá consultar y modificar los datos personales almacenados en su perfil.                                             |
| **RF-06** | El usuario podrá establecer, modificar y eliminar su fotografía de perfil.                                                        |
| **RF-07** | El sistema utilizará los datos almacenados en el perfil para rellenar automáticamente los datos del pasajero durante una reserva. |
| **RF-08** | El sistema permitirá realizar reservas sin disponer de una cuenta de usuario.                                                     |

## Búsqueda de vuelos

| ID        | Requisito                                                                                                                |
| --------- | ------------------------------------------------------------------------------------------------------------------------ |
| **RF-09** | El usuario podrá seleccionar si desea realizar un viaje de ida o de ida y vuelta.                                        |
| **RF-10** | El usuario podrá seleccionar un aeropuerto de origen y uno de destino entre los disponibles.                             |
| **RF-11** | El sistema mostrará únicamente los destinos para los que existan vuelos desde el aeropuerto de origen seleccionado.      |
| **RF-12** | El usuario podrá seleccionar la fecha de salida y, en viajes de ida y vuelta, la fecha de regreso.                       |
| **RF-13** | El usuario podrá indicar el número de pasajeros, diferenciando entre adultos, niños y bebés.                             |
| **RF-14** | El sistema permitirá un máximo de 8 pasajeros por reserva.                                                               |
| **RF-15** | El usuario podrá seleccionar la clase de viaje disponible, como Economy o Business.                                      |
| **RF-16** | El sistema mostrará los vuelos disponibles que coincidan con los criterios de búsqueda.                                  |
| **RF-17** | El sistema mostrará inicialmente los resultados ordenados por hora de salida local, de más temprano a más tarde.         |
| **RF-18** | El usuario podrá ordenar los resultados por criterios como precio, duración u hora de salida.                            |
| **RF-19** | El usuario podrá aplicar filtros a los resultados de búsqueda según las características disponibles de los vuelos.       |
| **RF-20** | El sistema no mostrará como disponibles para la reserva los vuelos que hayan alcanzado la capacidad máxima de pasajeros. |

## Funcionalidades adicionales de búsqueda

| ID        | Requisito                                                                                                                                         |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| **RF-21** | El sistema podrá mostrar un mapa con las ciudades desde las que la aerolínea dispone de vuelos, permitiendo seleccionar una de ellas como origen. |
| **RF-22** | El usuario podrá seleccionar la opción "Cualquier lugar" como destino.                                                                            |
| **RF-23** | Al seleccionar "Cualquier lugar", el sistema podrá mostrar en un mapa los destinos disponibles desde el origen seleccionado.                      |
| **RF-24** | El sistema podrá mostrar junto a cada destino del mapa el precio más bajo disponible para la fecha seleccionada.                                  |
| **RF-25** | El sistema podrá proporcionar una lista de aeropuertos cercanos al seleccionar un aeropuerto de origen.                                           |

## Proceso de reserva

| ID        | Requisito                                                                                                                  |
| --------- | -------------------------------------------------------------------------------------------------------------------------- |
| **RF-26** | El usuario podrá seleccionar un vuelo de ida entre los resultados obtenidos.                                               |
| **RF-27** | En una reserva de ida y vuelta, el usuario podrá seleccionar posteriormente el vuelo de regreso.                           |
| **RF-28** | El sistema permitirá introducir los datos correspondientes a cada pasajero de la reserva.                                  |
| **RF-29** | El usuario autenticado podrá utilizar los datos de su perfil para rellenar automáticamente los datos del pasajero.         |
| **RF-30** | El usuario podrá seleccionar el asiento de cada pasajero entre los asientos disponibles.                                   |
| **RF-31** | El sistema determinará si la selección del asiento tiene un coste adicional según las condiciones aplicables a la reserva. |
| **RF-32** | El sistema asignará automáticamente el equipaje incluido en la tarifa según las condiciones establecidas.                  |
| **RF-33** | El usuario podrá añadir equipaje facturado adicional durante el proceso de reserva.                                        |
| **RF-34** | El sistema mostrará las condiciones y dimensiones máximas correspondientes a cada tipo de equipaje.                        |

## Proceso de compra

| ID        | Requisito                                                                                                                     |
| --------- | ----------------------------------------------------------------------------------------------------------------------------- |
| **RF-35** | Antes de confirmar la compra, el sistema mostrará un resumen del viaje, pasajeros, asientos, equipaje, extras y precio total. |
| **RF-36** | El usuario podrá introducir los datos necesarios para la facturación de la compra.                                            |
| **RF-37** | El usuario podrá seleccionar un método de pago durante el proceso de compra.                                                  |
| **RF-38** | El sistema permitirá completar la compra mediante un sistema de pago simulado sin realizar una transacción económica real.    |
| **RF-39** | Una vez completado el proceso de compra, el sistema generará y confirmará la reserva.                                         |
| **RF-40** | Las reservas realizadas por usuarios autenticados quedarán asociadas a sus cuentas.                                           |

## Gestión de reservas

| ID        | Requisito                                                                                                                    |
| --------- | ---------------------------------------------------------------------------------------------------------------------------- |
| **RF-41** | El usuario autenticado podrá consultar sus reservas desde el apartado "Mis reservas".                                        |
| **RF-42** | El usuario podrá consultar el detalle de una reserva, incluyendo vuelos, pasajeros, asientos, equipaje, clase y condiciones. |
| **RF-43** | El usuario podrá solicitar la cancelación de una reserva cuando las condiciones del billete lo permitan.                     |
| **RF-44** | El usuario podrá modificar el asiento asignado cuando exista disponibilidad y las condiciones del billete lo permitan.       |
| **RF-45** | El usuario podrá modificar los datos del pasajero que puedan cambiarse sin realizar una nueva reserva.                       |
| **RF-46** | Los usuarios sin cuenta podrán consultar y gestionar sus reservas mediante los mecanismos habilitados para ello.             |
| **RF-47** | El usuario podrá consultar individualmente cada vuelo incluido en una reserva.                                               |

## Check-in y embarque

| ID        | Requisito                                                                                                                                                                                                                                               |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **RF-48** | El usuario registrado podrá iniciar el proceso de check-in desde el detalle del vuelo de una reserva asociada a su cuenta.                                                                                                                              |
| **RF-49** | El usuario sin cuenta podrá iniciar el proceso de check-in mediante un mecanismo de identificación basado en el código identificativo de la reserva y los apellidos correspondientes.                                                                   |
| **RF-50** | El sistema verificará que el código identificativo y los apellidos introducidos correspondan con una reserva válida antes de permitir el check-in.                                                                                                      |
| **RF-51** | El sistema permitirá realizar el check-in únicamente durante el periodo habilitado para el vuelo correspondiente.                                                                                                                                       |
| **RF-52** | Para vuelos internacionales, el sistema permitirá realizar el check-in desde 48 horas antes de la hora prevista de salida hasta 2 horas antes de dicha salida.                                                                                          |
| **RF-53** | Para vuelos nacionales, el sistema permitirá realizar el check-in desde 24 horas antes de la hora prevista de salida hasta 2 horas antes de dicha salida.                                                                                               |
| **RF-54** | El sistema permitirá consultar la fecha y hora exactas de apertura del check-in cuando todavía no se encuentre disponible.                                                                                                                              |
| **RF-55** | El sistema impedirá iniciar el proceso de check-in cuando los datos de identificación proporcionados por un usuario sin cuenta no correspondan con la reserva.                                                                                          |
| **RF-56** | El sistema mostrará un resumen del vuelo y de los pasajeros antes de completar el check-in.                                                                                                                                                             |
| **RF-57** | El usuario podrá consultar y modificar los datos API/APIS de los pasajeros durante el proceso de check-in.                                                                                                                                              |
| **RF-58** | El sistema realizará el check-in de todos los pasajeros de la reserva correspondientes al vuelo seleccionado.                                                                                                                                           |
| **RF-59** | Si un pasajero no dispone de asiento asignado al realizar el check-in, el sistema le asignará uno entre los asientos disponibles.                                                                                                                       |
| **RF-60** | El sistema generará una tarjeta de embarque para cada pasajero incluido en el check-in.                                                                                                                                                                 |
| **RF-61** | El sistema permitirá obtener las tarjetas de embarque correspondientes a todos los pasajeros del vuelo que haya sido facturado.                                                                                                                         |
| **RF-62** | El usuario podrá descargar en formato PDF las tarjetas de embarque generadas después del check-in.                                                                                                                                                      |
| **RF-63** | El sistema no permitirá realizar nuevamente el proceso de check-in sobre un vuelo que ya haya sido facturado.                                                                                                                                           |
| **RF-64** | Si el usuario vuelve a acceder al check-in de un vuelo ya facturado, el sistema permitirá obtener nuevamente las tarjetas de embarque correspondientes.                                                                                                 |
| **RF-65** | En la aplicación móvil, el sistema permitirá consultar la tarjeta de embarque del vuelo facturado para su utilización durante el embarque.                                                                                                              |
| **RF-66** | En la aplicación móvil, el usuario podrá descargar las tarjetas de embarque en formato PDF.                                                                                                                                                             |
| **RF-67** | En la aplicación móvil, el usuario podrá añadir las tarjetas de embarque a servicios de cartera digital compatibles.                                                                                                                                    |
| **RF-68** | El sistema realizará el check-in de cada vuelo de una reserva de forma independiente.                                                                                                                                                                   |
| **RF-69** | En una reserva de ida y vuelta, el usuario podrá realizar inicialmente el check-in del vuelo cuya ventana de check-in se encuentre abierta y deberá realizar posteriormente el check-in del vuelo de regreso cuando se abra su correspondiente periodo. |

## Administración de usuarios y reservas

| ID        | Requisito                                                                                            |
| --------- | ---------------------------------------------------------------------------------------------------- |
| **RF-70** | El administrador de usuarios podrá crear, consultar, modificar y eliminar usuarios.                  |
| **RF-71** | El administrador de usuarios podrá modificar los datos de los perfiles de los usuarios.              |
| **RF-72** | El administrador de usuarios podrá consultar, crear, modificar y eliminar reservas.                  |
| **RF-73** | El administrador de usuarios podrá gestionar las reservas asociadas a cualquier usuario.             |
| **RF-74** | El administrador de usuarios dispondrá de un panel independiente para gestionar usuarios y reservas. |

## Administración de vuelos y recursos

| ID        | Requisito                                                                                                                                                     |
| --------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **RF-75** | El administrador de vuelos podrá crear, consultar, modificar, desactivar y eliminar ciudades y aeropuertos.                                                   |
| **RF-76** | El administrador de vuelos podrá crear, consultar, modificar, desactivar y eliminar aeronaves de la flota.                                                    |
| **RF-77** | El administrador de vuelos podrá crear, consultar, modificar, desactivar y eliminar vuelos.                                                                   |
| **RF-78** | El administrador de vuelos podrá asignar una aeronave a un vuelo cuando sea compatible con el recorrido.                                                      |
| **RF-79** | El administrador de vuelos podrá activar o desactivar vuelos para controlar su disponibilidad para la venta.                                                  |
| **RF-80** | El administrador podrá importar y exportar información relacionada con vuelos, usuarios, aeronaves, aeropuertos y demás entidades gestionadas por el sistema. |