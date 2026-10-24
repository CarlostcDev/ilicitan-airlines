package com.ilicitan_airlines.backend.information.dto.admin.response;

import com.ilicitan_airlines.backend.information.enums.BaggageStatus;
import com.ilicitan_airlines.backend.information.enums.BaggageType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Schema(name = "BaggageOptionAdminResponse", description = "Equipaje con sus estados y registros para su administración")
public record BaggageOptionAdminResponse(
        @Schema(description = "Identificación del equipaje", example = "1")
        Long id,

        @Schema(description = "Nombre del equipaje", example = "Equipaje de cabina")
        String name,

        @Schema(description = "Tipo del equipaje", example = "CABIN")
        BaggageType type,

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
        String currency,

        @Schema(description = "Estado del equipaje", example = "ACTIVE")
        BaggageStatus status,

        @Schema(description = "Fecha de creación del equipaje", example = "2026-10-24 14:35:12.123456")
        LocalDateTime createdAt,

        @Schema(description = "Fecha de actualización del equipaje", example = "2027-04-16 11:25:42.157251")
        LocalDateTime updatedAt
) { }