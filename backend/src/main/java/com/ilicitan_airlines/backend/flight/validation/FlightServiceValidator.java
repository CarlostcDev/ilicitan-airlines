package com.ilicitan_airlines.backend.flight.validation;

import com.ilicitan_airlines.backend.flight.dto.user.request.FlightSearchRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public final class FlightServiceValidator {
    private FlightServiceValidator() {}

    public static void validateSearch(FlightSearchRequest request) {
        if (request.originIata().equals(request.destinationIata())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El origen y el destino deben ser diferentes");
        }
        if (request.returnDate() != null && request.returnDate().isBefore(request.departureDate())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de vuelta no puede ser anterior a la fecha de ida");
        }
    }
}
