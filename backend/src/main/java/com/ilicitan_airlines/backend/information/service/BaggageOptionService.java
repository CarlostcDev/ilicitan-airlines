package com.ilicitan_airlines.backend.information.service;

import com.ilicitan_airlines.backend.information.dto.request.BaggageOptionUpdateRequest;
import com.ilicitan_airlines.backend.information.dto.response.BaggageOptionAdminResponse;
import com.ilicitan_airlines.backend.information.dto.response.BaggageOptionResponse;
import com.ilicitan_airlines.backend.information.entity.BaggageOption;
import com.ilicitan_airlines.backend.information.enums.BaggageStatus;
import com.ilicitan_airlines.backend.information.repository.BaggageOptionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BaggageOptionService {
    private final BaggageOptionRepository baggageOptionRepository;

    public BaggageOptionService(BaggageOptionRepository baggageOptionRepository) {
        this.baggageOptionRepository = baggageOptionRepository;
    }

    @Transactional(readOnly = true)
    public List<BaggageOptionResponse> getBaggageOption(BaggageStatus status) {
        return baggageOptionRepository.findAllByStatus(status).stream()
                .map(bo -> BaggageOptionResponse.builder()
                        .name(bo.getName())
                        .weight(bo.getWeight())
                        .length(bo.getLength())
                        .width(bo.getWidth())
                        .height(bo.getHeight())
                        .price(bo.getPrice())
                        .currency(bo.getCurrency())
                        .build())
                .toList();
    }

    @Transactional(readOnly = true)
    public List<BaggageOptionAdminResponse> getAllBaggageOption() {
        return baggageOptionRepository.findAll().stream()
                .map(bo -> BaggageOptionAdminResponse.builder()
                        .id(bo.getId())
                        .name(bo.getName())
                        .type(bo.getType())
                        .weight(bo.getWeight())
                        .length(bo.getLength())
                        .width(bo.getWidth())
                        .height(bo.getHeight())
                        .price(bo.getPrice())
                        .currency(bo.getCurrency())
                        .status(bo.getStatus())
                        .createdAt(bo.getCreatedAt())
                        .updatedAt(bo.getUpdatedAt())
                        .build())
                .toList();
    }

    @Transactional
    public void updateBaggageOption(Long id, BaggageOptionUpdateRequest request) {
        BaggageOption baggageOption = baggageOptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el equipaje " + id));

        baggageOption.updateDetails(
                request.name(),
                request.type(),
                request.weight(),
                request.length(),
                request.width(),
                request.height(),
                request.price(),
                request.currency(),
                request.status()
        );
    }
}
