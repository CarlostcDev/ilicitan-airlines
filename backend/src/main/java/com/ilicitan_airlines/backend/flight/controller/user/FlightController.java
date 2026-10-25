package com.ilicitan_airlines.backend.flight.controller.user;

import com.ilicitan_airlines.backend.flight.dto.user.request.FlightSearchRequest;
import com.ilicitan_airlines.backend.flight.dto.user.response.FlightSearchResponse;
import com.ilicitan_airlines.backend.flight.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flight")
@Tag(name = "Flights", description = "Flight search and inquiry")
public class FlightController {
    private final FlightService flightService;

    @PostMapping("/search")
    @Operation(
            summary = "Search for flights",
            description = "Search for one-way or round-trip flights based on the provided criteria"
    )
    public ResponseEntity<FlightSearchResponse> searchFlights(@Valid @RequestBody FlightSearchRequest request) {
        return ResponseEntity.ok(flightService.searchFlights(request));
    }
}