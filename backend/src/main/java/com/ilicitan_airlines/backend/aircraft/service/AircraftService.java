package com.ilicitan_airlines.backend.aircraft.service;

import com.ilicitan_airlines.backend.aircraft.dto.admin.request.AircraftCreateAdminRequest;
import com.ilicitan_airlines.backend.aircraft.dto.admin.request.AircraftUpdateAdminRequest;
import com.ilicitan_airlines.backend.aircraft.dto.admin.response.AircraftAdminResponse;
import com.ilicitan_airlines.backend.aircraft.entity.Aircraft;
import com.ilicitan_airlines.backend.aircraft.entity.AircraftModel;
import com.ilicitan_airlines.backend.aircraft.mapper.AircraftMapper;
import com.ilicitan_airlines.backend.aircraft.repository.AircraftModelRepository;
import com.ilicitan_airlines.backend.aircraft.repository.AircraftRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftService {
    private final AircraftRepository aircraftRepository;
    private final AircraftModelRepository aircraftModelRepository;

    @Transactional(readOnly = true)
    public List<AircraftAdminResponse> getAllAircrafts() {
        return aircraftRepository.findAll()
                .stream()
                .map(AircraftMapper::toAdminResponse)
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

    @Transactional(readOnly = true)
    public AircraftAdminResponse getAircraftById(Long id) {
        Aircraft aircraft = aircraftRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft not found: " + id));
        return AircraftMapper.toAdminResponse(aircraft);
    }

    @Transactional
    public void deleteAircraft(Long id) {
        Aircraft aircraft = aircraftRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft not found: " + id));

        aircraftRepository.delete(aircraft);
    }

    @Transactional
    public AircraftAdminResponse createAircraft(AircraftCreateAdminRequest request) {
        AircraftModel aircraftModel = aircraftModelRepository.findById(request.aircraftModelId())
                .orElseThrow(() -> new EntityNotFoundException("Aircraft model not found: " + request.aircraftModelId()));

        Aircraft aircraft = Aircraft.builder()
                .aircraftModel(aircraftModel)
                .registration(request.registration())
                .serialNumber(request.serialNumber())
                .starlink(request.starlink())
                .status(request.status())
                .build();

        Aircraft savedAircraft = aircraftRepository.save(aircraft);
        return AircraftMapper.toAdminResponse(savedAircraft);
    }
}