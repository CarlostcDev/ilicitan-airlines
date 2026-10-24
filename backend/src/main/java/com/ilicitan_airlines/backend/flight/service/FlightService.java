package com.ilicitan_airlines.backend.flight.service;

import com.ilicitan_airlines.backend.flight.dto.user.request.FlightSearchRequest;
import com.ilicitan_airlines.backend.flight.dto.user.response.FlightOptionResponse;
import com.ilicitan_airlines.backend.flight.dto.user.response.FlightSearchResponse;
import com.ilicitan_airlines.backend.flight.entity.Flight;
import com.ilicitan_airlines.backend.flight.repository.FlightRepository;
import com.ilicitan_airlines.backend.flight.validation.FlightServiceValidator;
import com.ilicitan_airlines.backend.global.validation.ServiceValidator;
import com.ilicitan_airlines.backend.location.entity.Airport;
import com.ilicitan_airlines.backend.location.repository.AirportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    public FlightService(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @Transactional(readOnly = true)
    public FlightSearchResponse searchFlights(FlightSearchRequest request) {
        FlightServiceValidator.validateSearch(request);
        ServiceValidator.validate(request);
        Airport origin = airportRepository.findByIataCode(request.originIata())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el aeropuerto de origen"));
        Airport destination = airportRepository.findByIataCode(request.destinationIata())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el aeropuerto de destino"));
        List<FlightOptionResponse> outboundFlights = findFlights(origin, destination, request.departureDate());
        List<FlightOptionResponse> returnFlights = request.returnDate() != null ? findFlights(destination, origin, request.returnDate()) : List.of();
        return new FlightSearchResponse(outboundFlights, returnFlights);
    }

    private List<FlightOptionResponse> findFlights(Airport origin, Airport destination, LocalDate date) {
        ZoneId originZone = ZoneId.of(origin.getTimezone());
        LocalDateTime startUtc = date
                .atStartOfDay(originZone)
                .withZoneSameInstant(ZoneOffset.UTC)
                .toLocalDateTime();
        LocalDateTime endUtc = date
                .plusDays(1)
                .atStartOfDay(originZone)
                .withZoneSameInstant(ZoneOffset.UTC)
                .toLocalDateTime();
        return flightRepository.searchFlights(origin.getIataCode(), destination.getIataCode(), startUtc, endUtc)
                .stream()
                .map(this::toFlightOptionResponse)
                .toList();
    }

    private FlightOptionResponse toFlightOptionResponse(Flight flight) {
        LocalDateTime departureTime = flight.getScheduledDepartureUtc()
                .atOffset(ZoneOffset.UTC).atZoneSameInstant(ZoneId.of(flight.getOrigin().getTimezone())).toLocalDateTime();

        LocalDateTime arrivalTime = flight.getScheduledArrivalUtc()
                .atOffset(ZoneOffset.UTC).atZoneSameInstant(ZoneId.of(flight.getDestination().getTimezone())).toLocalDateTime();

        return new FlightOptionResponse(
                flight.getFlightIata(),
                flight.getOrigin().getIataCode(),
                flight.getDestination().getIataCode(),
                departureTime,
                arrivalTime,
                List.of()
        );
    }
}