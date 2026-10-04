package com.arij.vetements.restControllers;

import com.arij.vetements.dto.APIResponseDTO;
import com.arij.vetements.service.VetementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vetements")
@AllArgsConstructor
public class VetementController {

    private VetementService vetementsService;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDTO> getVetementById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(vetementsService.getVetementById(id), HttpStatus.OK);
    }
}