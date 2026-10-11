
package com.carlostcdev.ilicitanairlines.flight.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record FlightSearchRequest(
        @NotBlank @Pattern(regexp = "^[A-Z]{3}$") String originIata,
        @NotBlank @Pattern(regexp = "^[A-Z]{3}$") String destinationIata,
        @NotNull @FutureOrPresent LocalDate departureDate,
        @FutureOrPresent LocalDate returnDate,
        @NotNull @Min(1) @Max(8) Integer passengers,
        @NotBlank @Size(max = 30) @Pattern(regexp = "^[A-Z][A-Z0-9_]*$") String cabinClass
) {}