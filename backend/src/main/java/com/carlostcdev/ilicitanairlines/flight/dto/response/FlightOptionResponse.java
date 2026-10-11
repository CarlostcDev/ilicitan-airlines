package com.carlostcdev.ilicitanairlines.flight.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;

@Schema(name = "FlightOptionResponse", description = "Información de un vuelo disponible y sus tarifas")
public record FlightOptionResponse(
        @Schema(description = "Código identificador del vuelo", example = "IL102")
        String flightNumber,

        @Schema(description = "Código IATA del aeropuerto de origen", example = "ALC")
        String originIata,

        @Schema(description = "Código IATA del aeropuerto de destino", example = "NRT")
        String destinationIata,

        @Schema(description = "Fecha y hora programadas de salida", example = "2026-12-15T10:30:00")
        LocalDateTime departureTime,

        @Schema(description = "Fecha y hora programadas de llegada", example = "2026-12-16T08:45:00")
        LocalDateTime arrivalTime,

        @Schema(description = "Lista de tarifas disponibles para las clases de cabina de este vuelo")
        List<FlightFareOptionResponse> fares
) {}