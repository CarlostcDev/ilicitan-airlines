package com.ilicitan_airlines.backend.aircraft.dto.admin.response;

import com.ilicitan_airlines.backend.aircraft.enums.AircraftStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
@Schema(name = "AircraftAdminResponse", description = "Datos del avión para administradores")
public record AircraftAdminResponse(
        @Schema(description = "Identificador del avión", example = "1")
        Long id,

        @Schema(description = "Modelo al que pertenece el avión")
        AircraftModelAdminResponse aircraftModel,

        @Schema(description = "Matrícula del avión", example = "EC-ABC")
        String registration,

        @Schema(description = "Número de serie del fabricante", example = "MSN123456")
        String serialNumber,

        @Schema(description = "Indica si el avión dispone de Starlink", example = "true")
        Boolean starlink,

        @Schema(description = "Estado operativo del avión", example = "ACTIVE")
        AircraftStatus status,

        @Schema(description = "Fecha de creación")
        LocalDateTime createdAt,

        @Schema(description = "Fecha de actualización")
        LocalDateTime updatedAt
) {}