package com.arij.vetements.restControllers;

import com.arij.vetements.dto.VetementDTO;
import com.arij.vetements.entities.Vetement;
import com.arij.vetements.repos.VetementRepository;
import com.arij.vetements.service.VetementService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/vetements")
@AllArgsConstructor
public class VetementController {
    private VetementService vetementsService;
    @GetMapping("{id}")
    public ResponseEntity<VetementDTO> getVetementById(@PathVariable("id") Long id )
    {
        return new ResponseEntity<VetementDTO>(
                vetementsService.getVetementById(id), HttpStatus.OK);
    }

    @Bean
    CommandLineRunner commandLineRunner(VetementRepository vetementRepository) {
        return args -> {
            vetementRepository.save(Vetement.builder()
                    .Name("Robe")
                    .Marque("Zara")
                    .build());

        };
    }
}
