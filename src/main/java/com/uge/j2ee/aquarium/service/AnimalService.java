package com.uge.j2ee.aquarium.service;

import com.uge.j2ee.aquarium.model.Animal;
import com.uge.j2ee.aquarium.model.AnimalSpecies;
import com.uge.j2ee.aquarium.repository.AnimalDetailRepository;
import com.uge.j2ee.aquarium.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepo;
    @Autowired
    AnimalDetailRepository animalRepoD;

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


    public List<String> getAllSpecies() {
        return animalRepoD.getAllSpecies();
    }
    /*public  List<Animal> getAllAnimalBySpecies(){
        return animalRepoD.getAllAnimalBySpecies();
    }*/
    public Iterable<AnimalSpecies> getAllS() {
        return animalRepoD.findAll();
    }

    public AnimalSpecies saveSpecie(AnimalSpecies species) {
        return animalRepoD.save(species);
    }

    public AnimalSpecies getByIdSpecie(String id) {
        return animalRepoD.findById(Long.parseLong(id)).get();
    }
    public AnimalSpecies removeSpecie(AnimalSpecies animal) {
        animalRepoD.delete(animal);
        return animal;
    }
    public List<String> getAllName() {
        return  animalRepo.getAllName();
    }
}
