package com.uge.j2ee.aquarium.controller;
import com.uge.j2ee.aquarium.model.Pool;
import com.uge.j2ee.aquarium.service.PoolService;
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
public class PoolControllerTest {
    @LocalServerPort
    private int port = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    PoolService poolService;

    private List<Pool> pools = new ArrayList<Pool>();


    @Before
    public void init() {
        Pool p1 = new  Pool(1L, "abba", "clean");
        Pool p2 = new   Pool(2L, "aaish", "dirty");
        Pool p3 = new   Pool(3L, "lish", "clean");

        pools.add(p1);
        pools.add(p2);
        pools.add(p3);
        Mockito.when(poolService.getAll()).thenReturn(pools);
        Mockito.when(poolService.getById("1")).thenReturn(p1);
        Mockito.when(poolService.getById("2")).thenReturn(p2);
        Mockito.when(poolService.getById("3")).thenReturn(p3);
    }
    @Test
    public void getAll() {
        List<Pool> lista = this.restTemplate.getForObject("http://localhost:" + port + "/pool", List.class);
        assertEquals(3, lista.size());
    }

    @Test
    public void getById() {
        List<HashMap> listSect = this.restTemplate.getForObject("http://localhost:" + port + "/pool", List.class);
        Pool output = this.restTemplate.getForObject("http://localhost:" + port + "/pool/2", Pool.class);
        assertEquals(listSect.get(1).get("namePool"), output.getNamePool());
    }

    @Test
    public void testPostId() throws URISyntaxException {
        Pool p1 = new  Pool(1L, "abba", "clean");
        Mockito.when(poolService.save(p1)).thenReturn(new  Pool(1L, "abba", "clean"));
        Pool request = this.restTemplate.postForObject("http://localhost:" + port + "/pool", p1,
                Pool.class);
        assertEquals("abba", request.getNamePool());
        assertEquals("clean", request.getState());
        assertNotNull(request.getIdPool());
    }

    @Test
    public void updatePool() {
        Pool updateP1 = new  Pool(1L, "abba", "clean");
        Mockito.when(poolService.save(updateP1)).thenReturn(new  Pool(1L, "abba", "clean"));
        updateP1.setState("dirty");
        HttpEntity<Pool> updated = new HttpEntity<Pool>(updateP1);
        Pool request = this.restTemplate.exchange("http://localhost:" + port + "/pool/1", HttpMethod.PUT,
                updated, Pool.class).getBody();
        System.out.println(request);
        assertEquals(updateP1, request);
    }

    @Test
    public void delete() {
        Pool p1 = new  Pool(1L, "abba", "clean");
        Mockito.when(poolService.remove(p1)).thenReturn(p1);
        Pool response = this.restTemplate
                .exchange("http://localhost:" + port + "/pool/1", HttpMethod.DELETE, null, Pool.class)
                .getBody();
        assert response != null;
        assertEquals(Long.valueOf(1L), response.getIdPool());
        assertEquals(p1, response);
    }
}