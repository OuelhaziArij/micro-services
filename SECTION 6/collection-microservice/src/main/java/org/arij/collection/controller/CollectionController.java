package org.arij.collection.controller;

import lombok.RequiredArgsConstructor;
import org.arij.collection.config.AuthorProperties;
import org.arij.collection.dto.CollectionDTO;
import org.arij.collection.entities.Collection;
import org.arij.collection.repos.CollectionRepository;
import org.arij.collection.service.CollectionService;
import org.springframework.beans.factory.annotation.Value;
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
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;
    private final AuthorProperties authorProperties;

    @Value("${build.version}")
    private String buildVersion;

    @GetMapping("{code}")
    public ResponseEntity<CollectionDTO> getCollectionByCode(@PathVariable("code") String code) {
        return new ResponseEntity<>(collectionService.getCollectionByCode(code), HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authorProperties.getName() + " " + authorProperties.getEmail());
    }

    @Bean
    CommandLineRunner commandLineRunner(CollectionRepository collectionRepository) {
        return args -> {
            collectionRepository.save(Collection.builder()
                    .colName("Été").colCode("ETE")
                    .colDesc("Vêtements légers pour la saison chaude").build());
            collectionRepository.save(Collection.builder()
                    .colName("Hiver").colCode("Hiver")
                    .colDesc("Vêtements chauds pour la saison froide").build());
        };
    }
}