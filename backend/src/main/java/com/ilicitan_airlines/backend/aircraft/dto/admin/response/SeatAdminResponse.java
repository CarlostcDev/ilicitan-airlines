package com.ilicitan_airlines.backend.aircraft.dto.admin.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(name = "SeatAdminResponse", description = "Datos de los asientos para administradores")
public record SeatAdminResponse(
        @Schema(description = "Identificador del asiento", example = "1")
        Long id,

        @Schema(description = "Avión al que pertenece el asiento")
        AircraftAdminResponse aircraftAdminResponse,

        @Schema(description = "Clase al que pertenece el asiento")
        CabinClassAdminResponse cabinClassAdminResponse,

        @Schema(description = "Número de asiento", example = "12A")
        String seatNumber,

        @Schema(description = "Fila del asiento", example = "12")
        Short seatRow,

        @Schema(description = "Letra del asiento", example = "A")
        String seatLetter
) {}