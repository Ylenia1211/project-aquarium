package com.uge.j2ee.aquarium.service;

import com.uge.j2ee.aquarium.model.Animal;
import com.uge.j2ee.aquarium.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AnimalService {

    @Autowired
    AnimalRepository animalRepo;

    public Iterable<Animal> getAll() {
        return animalRepo.findAll();
    }
    public Animal save(Animal animal) {
        return animalRepo.save(animal);
    }

    public void update(Animal animal) {
        animalRepo.save(animal);
    }

    public Animal getById(String id) {
        return animalRepo.findById(Long.parseLong(id)).get();
    }

    public Animal remove(Animal animal) {
        animalRepo.delete(animal);
        return animal;
    }
}
