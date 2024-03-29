package com.uge.j2ee.aquarium.repository;

import com.uge.j2ee.aquarium.model.Animal;
import com.uge.j2ee.aquarium.model.AnimalSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long>{

    @Query("select a.name from Animal a")
    public List<String> getAllName();

}
