package com.ilicitan_airlines.backend.aircraft.dto.admin.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Schema(name = "AircraftModelUpdateAdminRequest", description = "Actualización del modelo de avión")
public record AircraftModelUpdateAdminRequest(
        @Schema(description = "Fabricante del modelo de avión", example = "Airbus")
        @Size(min = 1, max = 100) @Pattern(regexp = ".*\\S.*") String manufacturer,

        @Schema(description = "Nombre del modelo del avión", example = "A380-800")
        @Size(min = 1, max = 100) @Pattern(regexp = ".*\\S.*") String model,

        @Schema(description = "Capacidad máxima de pasajeros", example = "375")
        @Positive Short capacity,

        @Schema(description = "Rango en kilómetros máximo que el modelo puede recorrer", example = "15700")
        @Positive Integer range,

        @Schema(description = "Velocidad máxima de crucero al que puede ir el modelo", example = "985")
        @Positive Short cruiseSpeed
) {}