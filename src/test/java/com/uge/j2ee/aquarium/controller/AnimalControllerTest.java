package com.uge.j2ee.aquarium.controller;


import com.uge.j2ee.aquarium.model.Animal;
import com.uge.j2ee.aquarium.service.AnimalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnimalControllerTest {

    @LocalServerPort
    private int port = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    AnimalService animalService;

    private List<Animal> animals = new ArrayList<Animal>();

    @Before
    public void init() {
        Animal p1 = new Animal(1L, "Axolotl", "Tropical");
        Animal p2 = new Animal(2L, "Clown Fish", "Amphiprion percula");
        Animal p3 = new Animal(3L, "Ball fish", "Arothron stellatus");

        animals.add(p1);
        animals.add(p2);
        animals.add(p3);
        Mockito.when(animalService.getAll()).thenReturn(animals);
        Mockito.when(animalService.getById("1")).thenReturn(p1);
        Mockito.when(animalService.getById("2")).thenReturn(p2);
        Mockito.when(animalService.getById("3")).thenReturn(p3);
    }

    @Test
    public void testGetAll() {
        List<Animal> lista = this.restTemplate.getForObject("http://localhost:" + port + "/animal", List.class);
        assertEquals(3, lista.size());
    }

    @Test
    public void testGetById() {
        List<HashMap> listAnimal = this.restTemplate.getForObject("http://localhost:" + port + "/animal", List.class);
        Animal output = this.restTemplate.getForObject("http://localhost:" + port + "/animal/2", Animal.class);
        assertEquals(listAnimal.get(1).get("name"), output.getName());
    }

   //TO DO TEST POST, UPDATE, DELETE


}
