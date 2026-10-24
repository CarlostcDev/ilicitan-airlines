package com.ilicitan_airlines.backend.aircraft.dto.request;

import com.ilicitan_airlines.backend.aircraft.enums.AircraftStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Schema(name = "AircraftUpdateAdminRequest", description = "Actualización del avión")
public record AircraftUpdateAdminRequest(
        @Schema(description = "Identificador del modelo seleccionado", example = "1")
        @Positive Long aircraftModelId,

        @Schema(description = "Matrícula del avión", example = "EC-ABC")
        @Size(min = 1, max = 20)
        @Pattern(regexp = "^[A-Z0-9]+(?:-[A-Z0-9]+)*$")
        String registration,

        @Schema(description = "Número de serie del fabricante", example = "MSN123456")
        @Size(max = 50)
        @Pattern(regexp = ".*\\S.*")
        String serialNumber,

        @Schema(description = "Indica si dispone de Starlink", example = "true")
        Boolean starlink,

        @Schema(description = "Estado operativo del avión", example = "ACTIVE")
        AircraftStatus status
) {}