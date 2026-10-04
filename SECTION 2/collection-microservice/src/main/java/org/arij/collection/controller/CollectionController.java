package org.arij.collection.controller;

import lombok.AllArgsConstructor;
import org.arij.collection.dto.CollectionDTO;
import org.arij.collection.entities.Collection;
import org.arij.collection.repos.CollectionRepository;
import org.arij.collection.service.CollectionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/collections")
@AllArgsConstructor
public class CollectionController {

    private CollectionService collectionService;

    @GetMapping("{code}")
    public ResponseEntity<CollectionDTO> getCollectionByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(
                collectionService.getCollectionByCode(code),
                HttpStatus.OK);
    }

    @Bean
    CommandLineRunner commandLineRunner(CollectionRepository collectionRepository) {
        return args -> {
            collectionRepository.save(Collection.builder()
                    .colName("Été")
                    .colCode("ETE")
                    .colDesc("Vêtements légers pour la saison chaude")
                    .build());

            collectionRepository.save(Collection.builder()
                    .colName("Hiver")
                            .colCode("Hiver")
                    .colDesc("Vêtements chauds pour la saison froide")
                    .build());
        };
    }

}