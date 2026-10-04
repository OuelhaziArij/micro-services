package com.arij.vetements.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDTO {
    private VetementDTO vetementDto;
    private CollectionDTO collectionDto;
}