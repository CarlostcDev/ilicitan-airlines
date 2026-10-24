package com.ilicitan_airlines.backend.logging.dto.admin.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "ActivityLogsResponse", description = "Registros técnicos de actividad")
public record ActivityLogsResponse(
        @Schema(description = "Líneas del archivo de logs", example = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
        List<String> lines,

        @Schema(description = "Número de líneas devueltas", example = "200")
        int count
) {}