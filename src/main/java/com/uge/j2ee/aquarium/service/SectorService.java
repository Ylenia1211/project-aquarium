package com.uge.j2ee.aquarium.service;


import com.uge.j2ee.aquarium.model.Pool;
import com.uge.j2ee.aquarium.model.Sector;
import com.uge.j2ee.aquarium.repository.PoolRepository;
import com.uge.j2ee.aquarium.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectorService {

    @Autowired
    SectorRepository sectorRepo;

    public Iterable<Sector> getAll() {
        return sectorRepo.findAll();
    }

    public Sector save(Sector sector) {
        return sectorRepo.save(sector);
    }

    public void update(Sector sector) {
        sectorRepo.save(sector);
    }

    public Sector getById(String id) {
        return sectorRepo.findById(Long.parseLong(id)).get();
    }

    public Sector remove(Sector sector) {
        sectorRepo.delete(sector);
        return sector;
    }


}
