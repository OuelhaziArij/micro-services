package com.arij.vetements.service;

import com.arij.vetements.dto.CollectionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COLLECTION")
public interface APIClient {

    @GetMapping("api/collections/{code}")
    CollectionDTO getColByCode(@PathVariable("code") String code);
}