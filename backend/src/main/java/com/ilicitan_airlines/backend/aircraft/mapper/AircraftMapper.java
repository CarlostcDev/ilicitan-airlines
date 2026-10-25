package com.ilicitan_airlines.backend.aircraft.mapper;

import com.ilicitan_airlines.backend.aircraft.dto.admin.response.AircraftAdminResponse;
import com.ilicitan_airlines.backend.aircraft.entity.Aircraft;

public class AircraftMapper {
    public static AircraftAdminResponse toAdminResponse(Aircraft aircraft) {
        return AircraftAdminResponse.builder()
                .id(aircraft.getId())
                .aircraftModel(AircraftModelMapper.toAircraftModelAdminResponse(aircraft.getAircraftModel()))
                .registration(aircraft.getRegistration())
                .serialNumber(aircraft.getSerialNumber())
                .starlink(aircraft.getStarlink())
                .status(aircraft.getStatus())
                .createdAt(aircraft.getCreatedAt())
                .updatedAt(aircraft.getUpdatedAt())
                .build();
    }
}
