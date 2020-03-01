package com.uge.j2ee.aquarium.repository;

import com.uge.j2ee.aquarium.model.Employee;
import com.uge.j2ee.aquarium.model.Pool;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PoolRepository extends CrudRepository<Pool, Long> {


}
