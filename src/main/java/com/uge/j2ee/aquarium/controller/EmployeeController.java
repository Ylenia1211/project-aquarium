package com.uge.j2ee.aquarium.controller;

import com.uge.j2ee.aquarium.model.Employee;

import com.uge.j2ee.aquarium.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
public class EmployeeController {
      @Autowired
      EmployeeService employeeService;

    @GetMapping("/employee")
    public Iterable<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable String id) {
        return employeeService.getById(id);
    }

    @PostMapping("/employee")
    @ResponseBody
    public Employee create(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PutMapping("/employee/{id}")
    @ResponseBody
    public Employee updateEmployee(@PathVariable String id, @RequestBody Map<String, String> allParams) {
       Employee p = employeeService.getById(id);
        p.setName(allParams.get("name"));
        p.setDesignation(allParams.get("designation"));
        return  employeeService.save(p);
    }

    @DeleteMapping("/employee/{id}")
    public Employee delete(@PathVariable String id) {
        return  employeeService.remove( employeeService.getById(id));
    }

}


