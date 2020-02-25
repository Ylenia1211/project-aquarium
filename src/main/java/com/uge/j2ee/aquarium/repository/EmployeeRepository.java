package com.uge.j2ee.aquarium.repository;

import com.uge.j2ee.aquarium.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> { 
}
