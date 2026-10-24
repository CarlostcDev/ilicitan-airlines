package com.ilicitan_airlines.backend.information.service;

import com.ilicitan_airlines.backend.information.repository.BoardingPassRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardingPassService {
    private final BoardingPassRepository boardingPassRepository;

    public BoardingPassService(BoardingPassRepository boardingPassRepository) {
        this.boardingPassRepository = boardingPassRepository;
    }
}