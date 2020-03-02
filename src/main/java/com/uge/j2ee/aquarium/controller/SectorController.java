package com.uge.j2ee.aquarium.controller;

import com.uge.j2ee.aquarium.model.Employee;
import com.uge.j2ee.aquarium.model.Sector;
import com.uge.j2ee.aquarium.service.EmployeeService;
import com.uge.j2ee.aquarium.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.SecondaryTable;
import java.util.Map;

@RestController
public class SectorController {
    @Autowired
    SectorService sectorService;

    @GetMapping("/sector")
    public Iterable<Sector> getAll() {
        return sectorService.getAll();
    }

    @GetMapping("/sector/{id}")
    public Sector getById(@PathVariable String id) {
        return sectorService.getById(id);
    }

    @PostMapping("/sector")
    @ResponseBody
    public Sector create(@RequestBody Sector employee) {
        return sectorService.save(employee);
    }

    @PutMapping("/sector/{id}")
    @ResponseBody
    public Sector updateSector(@PathVariable String id, @RequestBody Map<String, String> allParams) {
        Sector p = sectorService.getById(id);
        p.setName(allParams.get("name"));
        p.setLocalitation(allParams.get("localitation"));
        return  sectorService.save(p);
    }

    @DeleteMapping("/sector/{id}")
    public Sector delete(@PathVariable String id) {
        return  sectorService.remove( sectorService.getById(id));
    }
}
