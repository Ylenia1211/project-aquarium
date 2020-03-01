package com.uge.j2ee.aquarium.service;

import com.uge.j2ee.aquarium.model.Employee;
import com.uge.j2ee.aquarium.model.Pool;
import com.uge.j2ee.aquarium.repository.EmployeeRepository;
import com.uge.j2ee.aquarium.repository.PoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoolService {

    @Autowired
    PoolRepository poolRepo;

    public Iterable<Pool> getAll() {
        return poolRepo.findAll();
    }

    public Pool save(Pool pool) {
        return poolRepo.save(pool);
    }

    public void update(Pool pool) {
        poolRepo.save(pool);
    }

    public Pool getById(String id) {
        return poolRepo.findById(Long.parseLong(id)).get();
    }

    public Pool remove(Pool pool) {
        poolRepo.delete(pool);
        return pool;
    }



}
