package com.ilicitan_airlines.backend.information.dto.request;

import com.ilicitan_airlines.backend.information.enums.BaggageStatus;
import com.ilicitan_airlines.backend.information.enums.BaggageType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Schema(name = "BaggageOptionUpdateRequest", description = "Actualización del equipaje")
public record BaggageOptionUpdateRequest(
        @Schema(description = "Nombre del equipaje", example = "Equipaje de cabina")
        @Size(min = 1, max = 100) @Pattern(regexp = ".*\\S.*") String name,

        @Schema(description = "Tipo del equipaje", example = "CABIN")
        BaggageType type,

        @Schema(description = "Límite del peso del equipaje", example = "7")
        @Positive BigDecimal weight,

        @Schema(description = "Límite de profundidad del equipaje", example = "40")
        @Positive Short length,

        @Schema(description = "Límite de ancho del equipaje", example = "30")
        @Positive Short width,

        @Schema(description = "Límite de altura del equipaje", example = "20")
        @Positive Short height,

        @Schema(description = "Precio del equipaje", example = "23.99")
        @Positive BigDecimal price,

        @Schema(description = "Divisa del precio del equipaje", example = "EUR")
        @Pattern(regexp = "[A-Z]{3}") String currency,

        @Schema(description = "Estado del equipaje", example = "ACTIVE")
        BaggageStatus status
) {}