package com.arij.vetements.service;

import com.arij.vetements.dto.APIResponseDTO;

public interface VetementService {
    APIResponseDTO getVetementById(Long id);
}