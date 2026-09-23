# Diagramas de Actividad

## Registro de un usuario

El siguiente diagrama representa el proceso de creación de una cuenta de usuario en Ilicitan Airlines mediante correo electrónico y contraseña, Google o Apple.

```mermaid
flowchart TD
    A([Inicio]) --> B["Seleccionar Crear cuenta"]
    B --> C{"Seleccionar método de registro"}

    C -->|Correo y contraseña| D["Introducir correo electrónico y contraseña"]
    C -->|Google| E["Iniciar registro con Google"]
    C -->|Apple| F["Iniciar registro con Apple"]

    D --> G{"¿El correo ya está registrado?"}
    G -->|Sí| H["Mostrar error: correo ya registrado"]
    H --> D
    G -->|No| I{"¿Los datos son válidos?"}

    I -->|No| J["Mostrar errores de validación"]
    J --> D
    I -->|Sí| K["Crear cuenta"]
    K --> L["Asignar fotografía de perfil predeterminada"]
    L --> M["Mostrar confirmación de registro"]
    M --> Z([Fin])

    E --> N["Autenticar cuenta de Google"]
    N --> O{"¿Autenticación correcta?"}
    O -->|No| P["Mostrar error de autenticación"]
    P --> Z
    O -->|Sí| Q{"¿El correo ya está registrado?"}
    Q -->|Sí| R["Acceder a la cuenta existente"]
    R --> Z
    Q -->|No| S["Crear cuenta"]
    S --> T{"¿Google proporciona fotografía?"}
    T -->|Sí| U["Guardar fotografía de Google"]
    T -->|No| V["Asignar fotografía de perfil predeterminada"]
    U --> W["Mostrar confirmación de registro"]
    V --> W
    W --> Z

    F --> X["Autenticar cuenta de Apple"]
    X --> Y{"¿Autenticación correcta?"}
    Y -->|No| AA["Mostrar error de autenticación"]
    AA --> Z
    Y -->|Sí| AB{"¿El correo ya está registrado?"}
    AB -->|Sí| AC["Acceder a la cuenta existente"]
    AC --> Z
    AB -->|No| AD["Crear cuenta"]
    AD --> AE{"¿Apple proporciona fotografía?"}
    AE -->|Sí| AF["Guardar fotografía de Apple"]
    AE -->|No| AG["Asignar fotografía de perfil predeterminada"]
    AF --> AH["Mostrar confirmación de registro"]
    AG --> AH
    AH --> Z
```


## Realización de una reserva

El siguiente diagrama representa el flujo principal que sigue un usuario para realizar una reserva en Ilicitan Airlines, desde la introducción de los criterios de búsqueda hasta la confirmación de la reserva.

```mermaid
flowchart TD
    A([Inicio]) --> B[Seleccionar tipo de viaje]
    B --> C[Seleccionar origen y destino]
    C --> D[Seleccionar fecha de salida]
    D --> E{¿Viaje de ida y vuelta?}
    E -->|Sí| F[Seleccionar fecha de regreso]
    E -->|No| G[Indicar número de pasajeros]
    F --> G
    G --> H[Seleccionar clase de viaje]
    H --> I[Buscar vuelos]
    I --> J{¿Hay vuelos disponibles?}
    J -->|No| K[Mostrar mensaje de que no hay vuelos]
    K --> Z([Fin])
    J -->|Sí| L[Mostrar vuelos disponibles]
    L --> M[Aplicar filtros u ordenar resultados]
    M --> N[Seleccionar vuelo de ida]
    N --> O{¿Viaje de ida y vuelta?}
    O -->|Sí| P[Seleccionar vuelo de regreso]
    O -->|No| Q[Introducir datos de los pasajeros]
    P --> Q
    Q --> R{¿Usuario autenticado?}
    R -->|Sí| S[Utilizar datos del perfil para rellenar pasajeros]
    R -->|No| T[Introducir datos manualmente]
    S --> U[Seleccionar asientos]
    T --> U
    U --> V{¿Asiento con coste adicional?}
    V -->|Sí| W[Calcular coste del asiento]
    V -->|No| X[Mantener precio del asiento]
    W --> Y[Gestionar equipaje]
    X --> Y
    Y --> AA{¿Añadir equipaje adicional?}
    AA -->|Sí| AB[Añadir equipaje facturado]
    AA -->|No| AC[Continuar]
    AB --> AC
    AC --> AD[Mostrar resumen de la reserva]
    AD --> AE[Introducir datos de facturación]
    AE --> AF[Seleccionar método de pago]
    AF --> AG[Realizar pago simulado]
    AG --> AH{¿Pago correcto?}
    AH -->|No| AI[Mostrar error de pago]
    AI --> AF
    AH -->|Sí| AJ[Crear y confirmar reserva]
    AJ --> AK[Mostrar confirmación]
    AK --> AL([Fin])
```

## Realización del check-in

El siguiente diagrama representa el proceso de check-in de Ilicitan Airlines, contemplando el acceso de usuarios registrados y no registrados, las diferentes ventanas de apertura según el tipo de vuelo, la gestión de pasajeros y asientos, la modificación de los datos API/APIS y la generación de las tarjetas de embarque.

```mermaid
flowchart TD
    A([Inicio]) --> B{¿Cómo accede al check-in?}

    B -->|Reserva / vuelo específico| C{¿Check-in ya realizado?}
    B -->|Inicio / Hacer check-in| D[Introducir código identificativo y apellidos]

    C -->|Sí| E[Mostrar tarjeta de embarque disponible]
    C -->|No| F{¿Check-in disponible?}

    D --> G{¿Datos correctos?}
    G -->|No| H[Mostrar error de identificación]
    H --> D
    G -->|Sí| I{¿Check-in ya realizado?}

    I -->|Sí| J[Descargar PDF de las tarjetas de embarque]
    J --> Z([Fin])

    I -->|No| K{¿Check-in disponible?}

    K -->|No| L[Mostrar fecha y hora exactas de apertura según la hora local del usuario]
    L --> Z

    K -->|Sí| M[Mostrar resumen del vuelo y pasajeros]
    F -->|No| N[No mostrar botón de check-in]
    N --> Z

    F -->|Sí| M

    M --> O[Modificar datos API/APIS si es necesario]
    O --> P[Confirmar datos API/APIS]
    P --> Q{¿Todos los pasajeros tienen asiento?}

    Q -->|Sí| R[Continuar]
    Q -->|No| S[Asignar aleatoriamente un asiento disponible a cada pasajero sin asiento]
    S --> R

    R --> T[Realizar check-in para todos los pasajeros del vuelo]
    T --> U[Generar tarjetas de embarque]
    U --> V[Generar PDF con las tarjetas de embarque]

    V --> W{¿Plataforma utilizada?}

    W -->|Web| X[Permitir descargar el PDF]
    X --> Z

    W -->|Aplicación móvil| Y[Mostrar tarjeta de embarque en vivo]
    Y --> AA[Permitir descargar PDF]
    AA --> AB[Permitir añadir a Google Wallet o Apple Wallet]
    AB --> Z

    E --> AC{¿Acceso desde aplicación móvil?}
    AC -->|Sí| Y
    AC -->|No| Z
```