package com.carlostcdev.ilicitanairlines.flight.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(name = "FlightSearchResponse", description = "Resultados de una búsqueda de vuelos de ida o ida y vuelta")
public record FlightSearchResponse(
        @Schema(description = "Lista de vuelos disponibles para el trayecto de ida")
        List<FlightOptionResponse> outboundFlights,

        @Schema(description = "Lista de vuelos disponibles para el trayecto de vuelta. Estará vacía si la búsqueda es solo de ida")
        List<FlightOptionResponse> returnFlights
) {}