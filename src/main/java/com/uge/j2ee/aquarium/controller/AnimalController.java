package com.uge.j2ee.aquarium.controller;


import com.uge.j2ee.aquarium.model.Animal;
import com.uge.j2ee.aquarium.model.AnimalSpecies;
import com.uge.j2ee.aquarium.model.Pool;
import com.uge.j2ee.aquarium.service.AnimalService;
import com.uge.j2ee.aquarium.service.PoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {
    @Autowired
    AnimalService animalService;

    @Autowired
    PoolService poolService;

    @GetMapping("/animal")
    public Iterable<Animal> getAll() {
        return animalService.getAll();
    }

    @GetMapping("/animal/species")
    public List<String> getAllSpecies() {
        return animalService.getAllSpecies();
    }

    @PostMapping("/species")
    @ResponseBody
    public AnimalSpecies addSpecies(@RequestBody AnimalSpecies animal) {
        return animalService.saveSpecie(animal);
    }

    @GetMapping("/species/{id}")
    public AnimalSpecies getByIdSpecie(@PathVariable String id) {
        return animalService.getByIdSpecie(id);
    }

    @GetMapping("/species")
    public Iterable<AnimalSpecies> getAllS() {
        return animalService.getAllS();
    }

    @DeleteMapping("/species/{id}")
    public AnimalSpecies deleteSpecie(@PathVariable String id) {
        return animalService.removeSpecie(animalService.getByIdSpecie(id));
    }


    @GetMapping("/animal/name")
    public List<String> getAllName() {
        return animalService.getAllName();
    }

    @GetMapping("/animal/{id}")
    public Animal getById(@PathVariable String id) {
        return animalService.getById(id);
    }

    @PostMapping("/animal/pool/{poolId}")
    @ResponseBody
    public Animal addAnimal(@RequestBody Animal animal,  @PathVariable String poolId)
    {
        Pool poolRes = poolService.getById(poolId);
        animal.setPool(poolRes);
        return animalService.save(animal);
    }

    @PutMapping("/animal/{id}")
    @ResponseBody
    public Animal updateAnimal(@PathVariable String id, @RequestBody Map<String, String> allParams) {
        Animal p = animalService.getById(id);
        p.setName(allParams.get("name"));
        p.setSpecies(allParams.get("species"));
        return animalService.save(p);
    }

    @DeleteMapping("/animal/{id}")
    public Animal deleteAnimal(@PathVariable String id) {
        return animalService.remove(animalService.getById(id));
    }



}
