# Casos de Uso

## Autenticación, Usuarios y Perfil

```mermaid
graph TD
    actorInvitado[("Cliente no autenticado")]
    actorUsuario[("Cliente autenticado")]
    extGoogle[("Google")]
    extApple[("Apple")]

    actorUsuario -->|Hereda permisos| actorInvitado

    subgraph Modulo_Usuarios["Gestión de Usuarios y Perfil"]
        UC_RF01["RF-01: Registro / Login con Email y Password"]
        UC_RF02_G["RF-02: Auth con Google"]
        UC_RF02_A["RF-02: Auth con Apple"]
        UC_RF03["RF-03: Iniciar y Cerrar Sesión"]
        UC_RF04["RF-04/05: Consultar y Modificar Perfil / Foto"]
    end

    actorInvitado --> UC_RF01
    actorInvitado --> UC_RF02_G
    actorInvitado --> UC_RF02_A
    actorInvitado --> UC_RF03
    actorUsuario --> UC_RF04

    UC_RF02_G <-->|API OAuth| extGoogle
    UC_RF02_A <-->|API OAuth / Sign in with Apple| extApple
```

## Búsqueda, Proceso de Reserva y Pago

```mermaid
graph TD
    actorCliente[("Cliente (Autenticado / Sin autenticar)")]
    extPago[("Sistema de pago simulado")]

    subgraph Modulo_Reserva["Búsqueda y Flujo de Compra"]
        UC_Busqueda["RF-08 a 15, 60: Buscar Vuelos y Listar Cercanos"]
        UC_Filtros["RF-17/18: Filtrar y Ordenar Resultados"]
        UC_Mapa["RF-19 a 22: Exploración por Mapa"]
        UC_SelVuelo["RF-23/24: Seleccionar Vuelo (Ida/Vuelta)"]
        UC_Pasajeros["RF-25/26: Datos de Pasajeros / Autocompletado"]
        UC_Asientos["RF-27/28: Selección y Coste de Asientos"]
        UC_Equipaje["RF-29 a 31: Selección de Equipaje y Extras"]
        UC_Pago["RF-32 a 35: Resumen, Facturación y Pago Simulado"]
        UC_Confirmacion["RF-36/37: Generar y Confirmar Reserva"]
    end

    actorCliente --> UC_Busqueda
    actorCliente --> UC_Filtros
    actorCliente --> UC_Mapa
    
    UC_Busqueda --> UC_SelVuelo
    UC_SelVuelo --> UC_Pasajeros
    UC_Pasajeros --> UC_Asientos
    UC_Asientos --> UC_Equipaje
    UC_Equipaje --> UC_Pago
    UC_Pago --> UC_Confirmacion

    UC_Pago <-->|Procesar Transacción| extPago
```

## Gestión de Reservas y Check-in

```mermaid
graph TD
    actorInvitado[("Usuario sin Cuenta")]
    actorUsuario[("Usuario Autenticado")]

    subgraph Modulo_Gestion["Gestión de Reservas y Check-in"]
        UC_Consultar["RF-38/39/43: Consultar / Detalle de Reserva"]
        UC_Modificar["RF-40 a 42: Cancelar o Modificar Asiento / Datos"]
        UC_CheckIn["RF-44 a 46: Realizar Check-in"]
        UC_Tarjeta["RF-47/48: Generar y Descargar Tarjeta de Embarque"]
    end

    actorInvitado --> UC_Consultar
    actorInvitado --> UC_CheckIn
    
    actorUsuario --> UC_Consultar
    actorUsuario --> UC_Modificar
    actorUsuario --> UC_CheckIn

    UC_CheckIn --> UC_Tarjeta
```

## Panel de Administración de Gestión de Usuarios y Reservas

```mermaid
graph TD
    actorAdminUser[("Administrador de Usuarios")]

    subgraph Modulo_AdminUsers["Administración de Usuarios y Reservas"]
        UC_CRUD_Users["RF-49/50: Gestionar Usuarios y Perfiles"]
        UC_CRUD_Res["RF-51/52/53: Gestionar Reservas del Sistema"]
        UC_IO_Users["RF-59: Importar / Exportar Datos (CSV)"]
    end

    actorAdminUser --> UC_CRUD_Users
    actorAdminUser --> UC_CRUD_Res
    actorAdminUser --> UC_IO_Users
```

## Panel de Administración de Gestión de Vuelos y Flota

```mermaid
graph TD
    actorAdminVuelos[("Administrador de Vuelos")]

    subgraph Modulo_AdminVuelos["Administración de Vuelos y Flota"]
        UC_Aero["RF-54: Gestionar Ciudades y Aeropuertos"]
        UC_Flota["RF-55: Gestionar Aeronaves de la Flota"]
        UC_Vuelos["RF-56/58: Crear, Modificar y Activar Vuelos"]
        UC_Asignar["RF-57: Asignar Aeronave a Vuelo"]
        UC_IO_Vuelos["RF-59: Importar / Exportar Datos (CSV)"]
    end

    actorAdminVuelos --> UC_Aero
    actorAdminVuelos --> UC_Flota
    actorAdminVuelos --> UC_Vuelos
    actorAdminVuelos --> UC_Asignar
    actorAdminVuelos --> UC_IO_Vuelos
```