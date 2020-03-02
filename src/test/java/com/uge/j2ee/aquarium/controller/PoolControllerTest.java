package com.uge.j2ee.aquarium.controller;
import com.uge.j2ee.aquarium.model.Pool;
import com.uge.j2ee.aquarium.service.PoolService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
    @Test
    public void getAll() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void create() {
    }

    @Test
    public void updatePool() {
    }

    @Test
    public void delete() {
    }
}