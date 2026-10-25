package com.ilicitan_airlines.backend.aircraft.mapper;

import com.ilicitan_airlines.backend.aircraft.dto.admin.response.AircraftModelAdminResponse;
import com.ilicitan_airlines.backend.aircraft.entity.AircraftModel;

public class AircraftModelMapper {
    public static AircraftModelAdminResponse toAircraftModelAdminResponse(AircraftModel aircraftModel) {
        return AircraftModelAdminResponse.builder()
                .id(aircraftModel.getId())
                .manufacturer(aircraftModel.getManufacturer())
                .model(aircraftModel.getModel())
                .capacity(aircraftModel.getCapacity())
                .rangeKm(aircraftModel.getRange())
                .cruiseSpeedKmh(aircraftModel.getCruiseSpeed())
                .build();
    }
}
