# Propuesta individual de proyecto

| Campo | Información |
|---|---|
| Actividad | Actividad 1 |
| Nombre | Carlos Tormo Castaño |
| FP | Desarrollo de Aplicaciones Multiplataforma |
| Curso | 2º K |

### Finalidad del proyecto

El proyecto consistirá en la venta de vuelos de una aerolínea ficticia a sus usuarios. Para ello, se propone hacer una web y una aplicación. La elección de este proyecto se debe a una combinación de interés personal, originalidad en su diseño y funcionalidades, y la viabilidad técnica. Esta idea sólida proveniente del 1º curso cumpliría con todos los requisitos del proyecto, permitiría añadir funcionalidades extras con valor añadido, y cubriría todos los módulos de DAM sin ser un simple CRUD.

### Tipos de usuario y permisos

Para que el servicio sea consistente existirá una estructura de roles, en los que se encuentra el cliente principal, el usuario básico. Este usuario podrá registrarse/iniciar sesión en la web/aplicación, buscar vuelos, comprarlos, gestionarlos, cancelarlos, agregar información a su perfil y demás.

Luego, existirá el rol del administrador de vuelos, este podrá crear, modificar y eliminar vuelos para que estén disponibles para su venta. Y el rol de administrador de usuario, encargado de toda la gestión de usuarios y vuelos de usuario, como su creación, modificación del perfil y su eliminación.

### Recursos a gestionar

El recurso más relevante del proyecto es la reserva de un vuelo. Dicho vuelo estará relacionado con 1 aeropuerto como origen, 1 aeropuerto como destino y 1 avión disponible y apto para dicho recorrido.

Aunque hay más entidades, como la flota de aviones que dispone la aerolínea que tendrá su nombre, modelo, capacidad, combustible, peso, si tiene un vuelo asignado o no, etc.

También existirán los aeropuertos base en los cuales operan dichos vuelos, que tendrá el nombre de la ciudad, su código IATA, su timezone, la fecha UTC y local, las coordenadas y el nombre del aeropuerto y su código IATA.

### Funcionalidades extras

Es complicado y muy variable hacer una lista de funcionalidades, pero si existen algunos interesantes.

Los usuarios podrían:

- En el buscador podrán visualizar un mapa del mundo donde se verán fijados todas las ciudades orígenes en los que haya vuelos, permitiéndole seleccionarlos para su búsqueda.
- En el formulario, el usuario podrá indicar como destino “Cualquier lugar”, esta opción le llevará a dicho mapa anterior, pero esta vez indicándole solo los destinos que existen desde el origen seleccionado. Dichos destinos tendrán una etiqueta indicando el vuelo más barato de dicho día.
- Además de lo anterior, el usuario podrá seleccionar asiento, clase, equipaje y extras durante el formulario de reserva.

Los administradores podrían:

- Crear, ver, modificar, desactivar, exportar, importar y borrar vuelos, usuarios, aviones, aeropuertos y demás, a través de su panel de administración.

Además de esto, se integrarán progresivamente todas las funcionalidades que tendría una página web de una aerolínea profesional a la hora de la implementación, por ejemplo, que el usuario pueda seleccionar un rango de fechas usando un calendario, o bien, que el usuario descargue el billete de embarque al hacer check-in.