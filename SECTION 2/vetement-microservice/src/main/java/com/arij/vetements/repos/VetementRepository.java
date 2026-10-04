package com.arij.vetements.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arij.vetements.entities.Vetement;
public interface VetementRepository extends JpaRepository<Vetement, Long> {
}
