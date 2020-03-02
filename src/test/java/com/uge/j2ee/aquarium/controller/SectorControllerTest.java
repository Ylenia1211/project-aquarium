package com.uge.j2ee.aquarium.controller;
import com.uge.j2ee.aquarium.model.Sector;
import com.uge.j2ee.aquarium.service.SectorService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SectorControllerTest {
    @LocalServerPort
    private int port = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    SectorService sectorService;

    private List<Sector> sects = new ArrayList<Sector>();
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
    public void updateSector() {
    }

    @Test
    public void delete() {
    }
}