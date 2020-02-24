package com.uge.j2ee.aquarium.repository;

import com.uge.j2ee.aquarium.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
