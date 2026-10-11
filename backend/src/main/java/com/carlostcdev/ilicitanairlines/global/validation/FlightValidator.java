package com.carlostcdev.ilicitanairlines.global.validation;

import com.carlostcdev.ilicitanairlines.flight.dto.request.FlightSearchRequest;
import com.carlostcdev.ilicitanairlines.global.exception.IlicitanAirlinesException;
import com.carlostcdev.ilicitanairlines.location.entity.Airport;
import java.time.LocalDateTime;

public final class FlightValidator {
    private FlightValidator() {}

    public static void validateSchedule(LocalDateTime departure, LocalDateTime arrival) {
        if (departure == null || arrival == null) {
            throw new IlicitanAirlinesException("Debe indicar ambos horarios estimados");
        }

        if (!arrival.isAfter(departure)) {
            throw new IlicitanAirlinesException("La llegada programada debe ser posterior a la salida");
        }
    }

    public static void validateEstimated(LocalDateTime departure, LocalDateTime arrival) {
        if (departure != null && arrival != null) {
            if (!arrival.isAfter(departure)) {
                throw new IlicitanAirlinesException("La llegada estimada debe ser posterior a la salida");
            }
        }
    }

    public static void validateAirports(Airport departure, Airport arrival) {
        if (departure == null || arrival == null) {
            throw new IlicitanAirlinesException("Los aeropuertos de origen y destino son obligatorios");
        }

        if (departure.getIataCode().equals(arrival.getIataCode())) {
            throw new IlicitanAirlinesException("El aeropuerto de destino no puede ser el mismo que el de origen");
        }
    }

    public static void validateSearch(FlightSearchRequest request) {
        if (request.originIata() != null &&
            request.originIata().equals(request.destinationIata())) {
            throw new IlicitanAirlinesException("El aeropuerto de origen no puede ser el mismo que el de destino");
        }

        if (request.departureDate() != null &&
            request.returnDate() != null &&
            request.returnDate().isBefore(request.departureDate())) {
            throw new IlicitanAirlinesException("La fecha de vuelta no puede ser anterior a la fecha de ida");
        }
    }
}
