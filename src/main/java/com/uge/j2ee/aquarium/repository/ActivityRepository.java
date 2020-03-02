package com.uge.j2ee.aquarium.repository;

import com.uge.j2ee.aquarium.model.Activity;
import com.uge.j2ee.aquarium.model.Pool;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
