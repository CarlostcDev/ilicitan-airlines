package com.ilicitan_airlines.backend.aircraft.dto.admin.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(name = "AircraftModelAdminResponse", description = "Modelo de avión para su administración")
public record AircraftModelAdminResponse(
        @Schema(description = "Identificador del modelo", example = "1")
        Long id,

        @Schema(description = "Fabricante del avión", example = "Airbus")
        String manufacturer,

        @Schema(description = "Modelo del avión", example = "A320")
        String model,

        @Schema(description = "Capacidad de pasajeros del modelo", example = "180")
        Short capacity,

        @Schema(description = "Autonomía máxima en kilómetros", example = "6100")
        Short rangeKm,

        @Schema(description = "Velocidad de crucero en km/h", example = "840")
        Short cruiseSpeedKmh
) {}