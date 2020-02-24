package com.uge.j2ee.aquarium.controller;


import com.uge.j2ee.aquarium.model.Animal;
import com.uge.j2ee.aquarium.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping("/animal")
    public Iterable<Animal> getAll() {
        return animalService.getAll();
    }

    @GetMapping("/animal/{id}")
    public Animal getById(@PathVariable String id) {
        return animalService.getById(id);
    }

    @PostMapping("/animal")
    @ResponseBody
    public Animal addAnimal(@RequestBody Animal animal) {
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
