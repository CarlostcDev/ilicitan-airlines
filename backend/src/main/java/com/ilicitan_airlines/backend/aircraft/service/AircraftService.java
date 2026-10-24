package com.ilicitan_airlines.backend.aircraft.service;

import com.ilicitan_airlines.backend.aircraft.dto.request.AircraftUpdateAdminRequest;
import com.ilicitan_airlines.backend.aircraft.dto.response.AircraftModelOptionResponse;
import com.ilicitan_airlines.backend.aircraft.entity.Aircraft;
import com.ilicitan_airlines.backend.aircraft.entity.AircraftModel;
import com.ilicitan_airlines.backend.aircraft.repository.AircraftModelRepository;
import com.ilicitan_airlines.backend.aircraft.repository.AircraftRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AircraftService {
    private final AircraftRepository aircraftRepository;
    private final AircraftModelRepository aircraftModelRepository;

    public AircraftService(AircraftRepository aircraftRepository, AircraftModelRepository aircraftModelRepository) {
        this.aircraftRepository = aircraftRepository;
        this.aircraftModelRepository = aircraftModelRepository;
    }

    @Transactional(readOnly = true)
    public List<AircraftModelOptionResponse> getAircraftModelOptions() {
        return aircraftModelRepository.findAll(Sort.by("manufacturer", "model")).stream()
                .map(model -> new AircraftModelOptionResponse(
                        model.getId(),
                        model.getManufacturer(),
                        model.getModel()
                ))
                .toList();
    }

    @Transactional
    public void updateAircraft(Long id, AircraftUpdateAdminRequest request) {
        Aircraft aircraft = aircraftRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft not found: " + id));

        AircraftModel aircraftModel = null;
        if (request.aircraftModelId() != null) {
            aircraftModel = aircraftModelRepository.findById(request.aircraftModelId())
                    .orElseThrow(() -> new EntityNotFoundException("Aircraft model not found: " + request.aircraftModelId()));
        }

        aircraft.updateAircraft(
                aircraftModel,
                request.registration(),
                request.serialNumber(),
                request.starlink(),
                request.status()
        );
    }
}