package com.uge.j2ee.aquarium.controller;

import com.uge.j2ee.aquarium.model.Employee;
import com.uge.j2ee.aquarium.model.Pool;
import com.uge.j2ee.aquarium.service.EmployeeService;
import com.uge.j2ee.aquarium.service.PoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PoolController {

    @Autowired
    PoolService poolService;
    @Autowired
    EmployeeService employeeService;


    @GetMapping("/pool")
    public Iterable<Pool> getAll() {
        return poolService.getAll();
    }

    @GetMapping("/pool/{id}")
    public Pool getById(@PathVariable String id) {
        return poolService.getById(id);
    }

    @PostMapping("/pool/employee/{employeeId}")
    @ResponseBody
    public Pool create(@RequestBody Pool pool, @PathVariable String employeeId) {
        Employee employeeRes = employeeService.getById(employeeId);
        pool.setResponsable(employeeRes);
        return poolService.save(pool);
    }

    @PutMapping("/pool/{id}")
    @ResponseBody
    public Pool updatePool(@PathVariable String id, @RequestBody Map<String, String> allParams) {
        Pool p = poolService.getById(id);
        p.setNamePool(allParams.get("namePool"));
        p.setState(allParams.get("state"));
        return poolService.save(p);
    }

    @DeleteMapping("/pool/{id}")
    public Pool delete(@PathVariable String id) {
        return  poolService.remove( poolService.getById(id));
    }

}
