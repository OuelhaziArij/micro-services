package org.arij.collection.service;

import org.arij.collection.dto.CollectionDTO;
import org.arij.collection.entities.Collection;
import org.arij.collection.repos.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionRepository collectionRepository;

    @Override
    public CollectionDTO getCollectionByCode(String code) {
        Collection collection = collectionRepository.findByColCode(code);
        CollectionDTO collectionDto = new CollectionDTO(
                collection.getId(),
                collection.getColName(),
                collection.getColCode(),
                collection.getColDesc()
        );
        return collectionDto;
    }
}