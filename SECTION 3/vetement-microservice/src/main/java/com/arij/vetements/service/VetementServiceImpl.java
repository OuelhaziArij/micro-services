package com.arij.vetements.service;

import com.arij.vetements.dto.APIResponseDTO;
import com.arij.vetements.dto.CollectionDTO;
import com.arij.vetements.dto.VetementDTO;
import com.arij.vetements.entities.Vetement;
import com.arij.vetements.repos.VetementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class VetementServiceImpl implements VetementService {

    private VetementRepository vetementRepository;
    private WebClient webClient;

    @Override
    public APIResponseDTO getVetementById(Long id) {
        Vetement vetement = vetementRepository.findById(id).get();

        CollectionDTO collectionDto = webClient.get()
                .uri("http://localhost:8080/api/collections/" + vetement.getColName())
                .retrieve()
                .bodyToMono(CollectionDTO.class)
                .block();

        VetementDTO vetementDto = new VetementDTO(
                vetement.getId(),
                vetement.getName(),
                vetement.getMarque(),
                vetement.getColName()
        );

        APIResponseDTO apiResponseDto = new APIResponseDTO();
        apiResponseDto.setVetementDto(vetementDto);
        apiResponseDto.setCollectionDto(collectionDto);
        return apiResponseDto;
    }
}