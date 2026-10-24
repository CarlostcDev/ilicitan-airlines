package com.ilicitan_airlines.backend.information.service;

import com.ilicitan_airlines.backend.information.repository.BoardingPassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardingPassService {
    private final BoardingPassRepository boardingPassRepository;
}