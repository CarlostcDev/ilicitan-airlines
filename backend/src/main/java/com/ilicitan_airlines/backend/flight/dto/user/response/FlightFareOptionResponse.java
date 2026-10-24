package com.ilicitan_airlines.backend.flight.dto.user.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Schema(name = "FlightFareOptionResponse", description = "Información de la tarifa y disponibilidad de una clase de cabina para un vuelo")
public record FlightFareOptionResponse(
        @Schema(description = "Nombre de la clase de cabina", example = "Economy")
        String cabinClassName,

        @Schema(description = "Número de asientos disponibles en esta clase para el vuelo", example = "12")
        Integer availableSeats,

        @Schema(description = "Precio base de la tarifa por pasajero", example = "420.50")
        BigDecimal basePrice,

        @Schema(description = "Código ISO 4217 de la moneda del precio", example = "EUR")
        String currency,

        @Schema(description = "Indica si la tarifa permite reembolsos", example = "false")
        Boolean refundable,

        @Schema(description = "Indica si la tarifa permite cambios", example = "true")
        Boolean changeable
) {}