package com.ilicitan_airlines.backend.information.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@Schema(name = "BaggageOptionResponse", description = "Equipaje que ofrece la aerolínea para todos sus vuelos")
public record BaggageOptionResponse(
        @Schema(description = "Nombre del equipaje", example = "Equipaje de cabina")
        String name,

        @Schema(description = "Límite del peso del equipaje", example = "7")
        BigDecimal weight,

        @Schema(description = "Límite de profundidad del equipaje", example = "40")
        Short length,

        @Schema(description = "Límite de ancho del equipaje", example = "30")
        Short width,

        @Schema(description = "Límite de altura del equipaje", example = "20")
        Short height,

        @Schema(description = "Precio del equipaje", example = "23.99")
        BigDecimal price,

        @Schema(description = "Divisa del precio del equipaje", example = "EUR")
        String currency
) {}