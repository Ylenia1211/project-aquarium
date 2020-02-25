package com.uge.j2ee.aquarium.service;

import com.uge.j2ee.aquarium.model.Animal;
import com.uge.j2ee.aquarium.model.Employee;
import com.uge.j2ee.aquarium.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepo;

    public Iterable<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void update(Employee employee) {
        employeeRepo.save(employee);
    }

    public Employee getById(String id) {
        return employeeRepo.findById(Long.parseLong(id)).get();
    }

    public Employee remove(Employee employee) {
        employeeRepo.delete(employee);
        return employee;
    }
}
