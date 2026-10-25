package com.ilicitan_airlines.backend.aircraft.dto.admin.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "AircraftModelOptionResponse", description = "Modelo de avión disponible para seleccionar")
public record AircraftModelOptionAdminResponse(
        @Schema(description = "Identificador del modelo", example = "1")
        Long id,

        @Schema(description = "Fabricante del avión", example = "Airbus")
        String manufacturer,

        @Schema(description = "Nombre del modelo", example = "A320")
        String model
) {}