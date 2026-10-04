package org.arij.collection.repos;


import org.arij.collection.entities.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CollectionRepository extends JpaRepository<Collection, Long>{
    Collection findByColCode(String code);

}
