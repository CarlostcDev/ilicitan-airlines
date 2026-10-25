package com.ilicitan_airlines.backend.aircraft.controller.admin;

import com.ilicitan_airlines.backend.aircraft.dto.admin.request.*;
import com.ilicitan_airlines.backend.aircraft.dto.admin.response.*;
import com.ilicitan_airlines.backend.aircraft.service.AircraftService;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/aircrafts")
@Tag(name = "Aircrafts", description = "Aircraft management for administrators")
public class AircraftAdminController {
    private final AircraftService aircraftService;

    @GetMapping
    @Operation(summary = "Retrieve all aircraft", description = "Returns the list of aircraft registered in the system.")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Aircraft retrieved successfully")})
    public List<AircraftAdminResponse> getAircrafts() {
        return aircraftService.getAllAircrafts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve an aircraft", description = "Returns the details of a specific aircraft by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Aircraft retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Aircraft not found", content = @Content)
    })
    public AircraftAdminResponse getAircraft(@Parameter(description = "Unique identifier of the aircraft", example = "15") @PathVariable Long id) {
        return aircraftService.getAircraftById(id);
    }

    @PostMapping
    @Operation(summary = "Create an aircraft", description = "Registers a new aircraft in the system.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Aircraft created successfully", content = @Content(schema = @Schema(implementation = AircraftAdminResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid aircraft data", content = @Content)
    })
    public ResponseEntity<AircraftAdminResponse> createAircraft(
            @Valid
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Aircraft information required for creation", required = true)
            AircraftCreateAdminRequest request
    ) {
        AircraftAdminResponse response = aircraftService.createAircraft(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    @Operation(
            summary = "Update an aircraft",
            description = "Updates the specified aircraft. Only the fields provided in the request are modified."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Aircraft updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid aircraft data", content = @Content),
            @ApiResponse(responseCode = "404", description = "Aircraft or aircraft model not found", content = @Content)
    })
    public ResponseEntity<Void> updateAircraft(
            @Parameter(description = "Unique identifier of the aircraft to update", example = "15")
            @PathVariable Long id,
            @Valid
            @RequestBody
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Fields to update. Omitted or null fields remain unchanged.", required = true)
            AircraftUpdateAdminRequest request
    ) {
        aircraftService.updateAircraft(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an aircraft", description = "Deletes the specified aircraft from the system.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Aircraft deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Aircraft not found", content = @Content)
    })
    public ResponseEntity<Void> deleteAircraft(@Parameter(description = "Unique identifier of the aircraft to delete", example = "15") @PathVariable Long id) {
        aircraftService.deleteAircraft(id);
        return ResponseEntity.noContent().build();
    }
}