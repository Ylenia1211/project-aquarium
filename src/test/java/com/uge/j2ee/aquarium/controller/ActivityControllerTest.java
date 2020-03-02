package com.uge.j2ee.aquarium.controller;

import com.uge.j2ee.aquarium.model.Activity;

import com.uge.j2ee.aquarium.service.ActivityService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ActivityControllerTest {
    @LocalServerPort
    private int port = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    ActivityService activityService;

    private List<Activity> acts = new ArrayList<Activity>();
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
    public void updateEmployee() {
    }

    @Test
    public void delete() {
    }
}