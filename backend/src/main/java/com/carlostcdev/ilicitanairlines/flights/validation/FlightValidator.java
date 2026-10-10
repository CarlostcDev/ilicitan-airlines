package com.carlostcdev.ilicitanairlines.flights.exception;

import com.carlostcdev.ilicitanairlines.location.entity.Airport;
import java.time.LocalDateTime;

public final class FlightValidator {
    private FlightValidator() {}

    public static void validateSchedule(LocalDateTime departure, LocalDateTime arrival) {
        if (departure == null || arrival == null) {
            throw new FlightException("Debe indicar ambos horarios estimados");
        }

        if (!arrival.isAfter(departure)) {
            throw new FlightException("La llegada programada debe ser posterior a la salida");
        }
    }

    public static void validateEstimated(LocalDateTime departure, LocalDateTime arrival) {
        if (departure != null && arrival != null) {
            if (!arrival.isAfter(departure)) {
                throw new FlightException("La llegada estimada debe ser posterior a la salida");
            }
        }
    }

    public static void validateAirports(Airport departure, Airport arrival) {
        if (departure == null || arrival == null) {
            throw new FlightException("Los aeropuertos de origen y destino son obligatorios");
        }

        if (departure.getIataCode().equals(arrival.getIataCode())) {
            throw new FlightException("El aeropuerto de destino no puede ser el mismo que el de origen");
        }
    }
}
