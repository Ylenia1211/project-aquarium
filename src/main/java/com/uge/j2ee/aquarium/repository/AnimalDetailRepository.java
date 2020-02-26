package com.uge.j2ee.aquarium.repository;

import com.uge.j2ee.aquarium.model.Animal;
import com.uge.j2ee.aquarium.model.AnimalSpecies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalDetailRepository  extends CrudRepository<AnimalSpecies, Long> {

    @Query("select a.nameSpecies from animal_species a")
    public List<String> getAllSpecies();
}
