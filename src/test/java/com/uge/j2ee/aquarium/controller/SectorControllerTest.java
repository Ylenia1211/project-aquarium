package com.uge.j2ee.aquarium.controller;
import com.uge.j2ee.aquarium.model.Sector;
import com.uge.j2ee.aquarium.service.SectorService;
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

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SectorControllerTest {
    @LocalServerPort
    private int port = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    SectorService sectorService;

    private List<Sector> sects = new ArrayList<Sector>();

    @Before
    public void init() {
        Sector p1 = new  Sector(1L, "abba", "plan1");
        Sector p2 = new  Sector(2L, "aaish", "plan2");
        Sector p3 = new  Sector(3L, "lish", "plan3");

        sects.add(p1);
        sects.add(p2);
        sects.add(p3);
        Mockito.when(sectorService.getAll()).thenReturn(sects);
        Mockito.when(sectorService.getById("1")).thenReturn(p1);
        Mockito.when(sectorService.getById("2")).thenReturn(p2);
        Mockito.when(sectorService.getById("3")).thenReturn(p3);
    }

    @Test
    public void getAll() {
        List<Sector> lista = this.restTemplate.getForObject("http://localhost:" + port + "/sector", List.class);
        assertEquals(3, lista.size());
    }

    @Test
    public void getById() {
        List<HashMap> listSect = this.restTemplate.getForObject("http://localhost:" + port + "/sector", List.class);
        Sector output = this.restTemplate.getForObject("http://localhost:" + port + "/sector/2", Sector.class);
        assertEquals(listSect.get(1).get("name"), output.getName());
    }

    @Test
    public void testPostId() throws URISyntaxException {
        Sector p1 = new  Sector(1L, "abba", "plan1");
        Mockito.when(sectorService.save(p1)).thenReturn(new  Sector(1L, "abba", "plan1"));
        Sector request = this.restTemplate.postForObject("http://localhost:" + port + "/sector", p1,
                Sector.class);
        assertEquals("abba", request.getName());
        assertEquals("plan1", request.getLocalitation());
        assertNotNull(request.getId());
    }

    @Test
    public void updateSector() {
       Sector updateP1 = new  Sector(1L, "abba", "plan1");
        Mockito.when(sectorService.save(updateP1)).thenReturn( new  Sector(1L, "abba", "plan1"));
        updateP1.setLocalitation("plan2");
        HttpEntity<Sector> updated = new HttpEntity<Sector>(updateP1);
        Sector request = this.restTemplate.exchange("http://localhost:" + port + "/sector/1", HttpMethod.PUT,
                updated, Sector.class).getBody();
        System.out.println(request);
        assertEquals(updateP1, request);
    }

    @Test
    public void delete() {
        Sector p1 =new  Sector(1L, "abba", "plan1");
        Mockito.when(sectorService.remove(p1)).thenReturn(p1);
        Sector response = this.restTemplate
                .exchange("http://localhost:" + port + "/sector/1", HttpMethod.DELETE, null, Sector.class)
                .getBody();
        assert response != null;
        assertEquals(Long.valueOf(1L), response.getId());
        assertEquals(p1, response);
    }
}