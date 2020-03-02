package com.uge.j2ee.aquarium.controller;
import com.uge.j2ee.aquarium.model.Employee;

import com.uge.j2ee.aquarium.service.EmployeeService;
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
public class EmployeeControllerTest {

    @LocalServerPort
    private int port = 8080;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    EmployeeService employeeService;

    private List<Employee> employees = new ArrayList<Employee>();


    @Before
    public void init() {
        Employee p1 = new  Employee(1L, "abba", "Tdds");
        Employee p2 = new  Employee(2L, "aaish", "aa");
        Employee p3 = new  Employee(3L, "lish", "ADSG");

        employees.add(p1);
        employees.add(p2);
        employees.add(p3);
        Mockito.when(employeeService.getAll()).thenReturn(employees);
        Mockito.when(employeeService.getById("1")).thenReturn(p1);
        Mockito.when(employeeService.getById("2")).thenReturn(p2);
        Mockito.when(employeeService.getById("3")).thenReturn(p3);
    }
    @Test
    public void getAll() {
        List<Employee> lista = this.restTemplate.getForObject("http://localhost:" + port + "/employee", List.class);
        assertEquals(3, lista.size());
    }

    @Test
    public void getById() {
        List<HashMap> listEmployee = this.restTemplate.getForObject("http://localhost:" + port + "/employee", List.class);
        Employee output = this.restTemplate.getForObject("http://localhost:" + port + "/employee/2", Employee.class);
        assertEquals(listEmployee.get(1).get("name"), output.getName());
    }

    @Test
    public void testPostId() throws URISyntaxException {
        Employee p1 = new  Employee(1L, "abba", "Tdds");
        Mockito.when(employeeService.save(p1)).thenReturn( new  Employee(1L, "abba", "Tdds"));
        Employee request = this.restTemplate.postForObject("http://localhost:" + port + "/employee", p1,
                Employee.class);
        assertEquals("abba", request.getName());
        assertEquals("Tdds", request.getSurname());
        assertNotNull(request.getIdEmployee());
    }

    @Test
    public void updateEmployee() {
        Employee updateP1 = new  Employee(1L, "abba", "Tdds");
        Mockito.when(employeeService.save(updateP1)).thenReturn(new  Employee(1L, "abba", "Tdds"));
        updateP1.setSurname("Rossi");
        HttpEntity<Employee> updated = new HttpEntity<Employee>(updateP1);
        Employee request = this.restTemplate.exchange("http://localhost:" + port + "/employee/1", HttpMethod.PUT,
                updated, Employee.class).getBody();
        System.out.println(request);
        assertEquals(updateP1, request);
    }

    @Test
    public void delete() {
        Employee p1 = new  Employee(1L, "abba", "Tdds");
        Mockito.when(employeeService.remove(p1)).thenReturn(p1);
        Employee response = this.restTemplate
                .exchange("http://localhost:" + port + "/employee/1", HttpMethod.DELETE, null, Employee.class)
                .getBody();
        assert response != null;
        assertEquals(Long.valueOf(1L), response.getIdEmployee());
        assertEquals(p1, response);
    }
}