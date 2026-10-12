package com.ilicitan_airlines.backend.flight.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Schema(name = "FlightSearchRequest", description = "Criterios para buscar vuelos de ida o ida y vuelta")
public record FlightSearchRequest(
        @Schema(description = "Código IATA del aeropuerto de origen", example = "ALC", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank @Pattern(regexp = "^[A-Z]{3}$") String originIata,

        @Schema(description = "Código IATA del aeropuerto de destino", example = "NRT", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank @Pattern(regexp = "^[A-Z]{3}$") String destinationIata,

        @Schema(description = "Fecha de salida del vuelo de ida", example = "2027-06-15", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull @FutureOrPresent LocalDate departureDate,

        @Schema(description = "Fecha de vuelta. Se omite en las búsquedas de solo ida", example = "2027-06-28")
        @FutureOrPresent LocalDate returnDate,

        @Schema(description = "Número de pasajeros", example = "2", minimum = "1", maximum = "8", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull @Min(1) @Max(8) Integer passengers,

        @Schema(description = "Código de la clase de cabina que se desea buscar", example = "ECONOMY", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank @Size(max = 30) @Pattern(regexp = "^[A-Z][A-Z0-9_]*$") String cabinClass
) {}