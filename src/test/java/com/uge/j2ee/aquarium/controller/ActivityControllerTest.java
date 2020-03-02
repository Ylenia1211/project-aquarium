package com.uge.j2ee.aquarium.controller;

import com.uge.j2ee.aquarium.model.Activity;
import com.uge.j2ee.aquarium.service.ActivityService;

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
public class ActivityControllerTest {
    @LocalServerPort
    private int port = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    ActivityService activityService;

    private List<Activity> acts = new ArrayList<Activity>();

    @Before
    public void init() {
        Activity p1 = new  Activity(1L, "abba", "public");
        Activity p2 = new  Activity(2L, "aaish", "public");
        Activity p3 = new  Activity(3L, "lish", "private");

        acts.add(p1);
        acts.add(p2);
        acts.add(p3);
        Mockito.when(activityService.getAll()).thenReturn(acts);
        Mockito.when(activityService.getById("1")).thenReturn(p1);
        Mockito.when(activityService.getById("2")).thenReturn(p2);
        Mockito.when(activityService.getById("3")).thenReturn(p3);
    }

    @Test
    public void getAll() {
        List<Activity> lista = this.restTemplate.getForObject("http://localhost:" + port + "/activity", List.class);
        assertEquals(3, lista.size());
    }

    @Test
    public void getById() {
        List<HashMap> listSect = this.restTemplate.getForObject("http://localhost:" + port + "/activity", List.class);
        Activity output = this.restTemplate.getForObject("http://localhost:" + port + "/activity/2", Activity.class);
        assertEquals(listSect.get(1).get("nameActivity"), output.getNameActivity());
    }

    @Test
    public void testPostId() throws URISyntaxException {
        Activity p1 = new  Activity(1L, "abba", "public");
        Mockito.when(activityService.save(p1)).thenReturn(new  Activity(1L, "abba", "public"));
        Activity request = this.restTemplate.postForObject("http://localhost:" + port + "/activity", p1,
                Activity.class);
        assertEquals("abba", request.getNameActivity());
        assertEquals("public", request.getState());
        assertNotNull(request.getId());
    }

    @Test
    public void updateEmployee() {
        Activity updateP1 = new  Activity(1L, "abba", "public");
        Mockito.when(activityService.save(updateP1)).thenReturn( new  Activity(1L, "abba", "public"));
        updateP1.setState("private");;
        HttpEntity<Activity> updated = new HttpEntity<Activity>(updateP1);
        Activity request = this.restTemplate.exchange("http://localhost:" + port + "/activity/1", HttpMethod.PUT,
                updated, Activity.class).getBody();
        System.out.println(request);
        assertEquals(updateP1, request);
    }

    @Test
    public void delete() {
        Activity p1 =new  Activity(1L, "abba", "public");
        Mockito.when(activityService.remove(p1)).thenReturn(p1);
        Activity response = this.restTemplate
                .exchange("http://localhost:" + port + "/activity/1", HttpMethod.DELETE, null, Activity.class)
                .getBody();
        assert response != null;
        assertEquals(Long.valueOf(1L), response.getId());
        assertEquals(p1, response);
    }
}