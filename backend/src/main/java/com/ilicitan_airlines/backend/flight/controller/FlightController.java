package com.ilicitan_airlines.backend.flight.controller;

import com.ilicitan_airlines.backend.flight.dto.request.FlightSearchRequest;
import com.ilicitan_airlines.backend.flight.dto.response.FlightSearchResponse;
import com.ilicitan_airlines.backend.flight.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
@Tag(name = "Flights", description = "Búsqueda y consulta de vuelos")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/search")
    @Operation(
            summary = "Buscar vuelos",
            description = "Busca vuelos de ida o ida y vuelta según los criterios proporcionados"
    )
    public ResponseEntity<FlightSearchResponse> searchFlights(@Valid @RequestBody FlightSearchRequest request) {
        return ResponseEntity.ok(flightService.searchFlights(request));
    }
}