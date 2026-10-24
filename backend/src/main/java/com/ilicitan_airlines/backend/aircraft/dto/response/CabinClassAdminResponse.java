package com.ilicitan_airlines.backend.aircraft.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(name = "CabinClassAdminResponse", description = "Clases de cabina disponibles en la aerolínea")
public record CabinClassAdminResponse(
        @Schema(description = "Identificador de la clase", example = "1")
        Long id,

        @Schema(description = "Código identificativo de la clase", example = "1")
        String code,

        @Schema(description = "Nombre de la clase", example = "1")
        String name
) {}