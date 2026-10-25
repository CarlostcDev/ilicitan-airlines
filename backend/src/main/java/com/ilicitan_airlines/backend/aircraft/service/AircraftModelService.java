package com.ilicitan_airlines.backend.aircraft.service;

import com.ilicitan_airlines.backend.aircraft.dto.admin.response.AircraftModelOptionAdminResponse;
import com.ilicitan_airlines.backend.aircraft.repository.AircraftModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftModelService {
    private final AircraftModelRepository aircraftModelRepository;

    @Transactional(readOnly = true)
    public List<AircraftModelOptionAdminResponse> getAircraftModelOptions() {
        return aircraftModelRepository.findAll(Sort.by("manufacturer", "model")).stream()
                .map(model -> new AircraftModelOptionAdminResponse(model.getId(), model.getManufacturer(), model.getModel()))
                .toList();
    }
}
