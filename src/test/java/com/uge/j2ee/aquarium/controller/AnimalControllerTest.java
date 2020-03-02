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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


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

   @Test
   public void testPostId() throws URISyntaxException {
       Animal animal = new Animal(1L, "Axolotl", "Tropical");
       Mockito.when(animalService.save(animal)).thenReturn( new Animal(1L, "Axolotl", "Tropical"));
       Animal request = this.restTemplate.postForObject("http://localhost:" + port + "/animal", animal,
               Animal.class);
       assertEquals("Axolotl", request.getName());
       assertEquals("Tropical", request.getSpecies());
       assertNotNull(request.getId());
   }

    @Test
    public void testUpdateAnimal() {
        Animal updateP1 = new Animal(1L, "Axolotl", "Tropical");
        Mockito.when(animalService.save(updateP1)).thenReturn(new Animal(1L, "Axolotl", "Tropical"));
        updateP1.setSpecies("Tropical");
        HttpEntity<Animal> updated = new HttpEntity<Animal>(updateP1);
        Animal request = this.restTemplate.exchange("http://localhost:" + port + "/animal/1", HttpMethod.PUT,
                updated, Animal.class).getBody();
        System.out.println(request);
        assertEquals(updateP1, request);
    }
/*
    @Test
    public void testDeleteAnimal() {
        Animal p1 = new Animal(1L, "Axolotl", "Tropical");
        Mockito.when(animalService.remove(p1)).thenReturn(p1);
        Animal response = this.restTemplate
                .exchange("http://localhost:" + port + "/animal/1", HttpMethod.DELETE, null, Animal.class)
                .getBody();
        assertEquals(Long.valueOf(1L), response.getId());
        assertEquals(p1, response);
    }
*/

}
