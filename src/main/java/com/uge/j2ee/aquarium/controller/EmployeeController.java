package com.uge.j2ee.aquarium.controller;

import com.uge.j2ee.aquarium.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

        private List<Employee> employees = createList();

        @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
        public List<Employee> firstPage() {
            return employees;
        }

    @DeleteMapping(path = { "/{id}" })
    public Employee delete(@PathVariable("id") int id) {
        Employee deletedEmp = null;
        for (Employee emp : employees) {
            if (emp.getIdEmployee().equals(id)) {
                employees.remove(emp);
                deletedEmp = emp;
                break;
            }
        }
        return deletedEmp;
    }

    @PostMapping
    public Employee create(@RequestBody Employee user) {
        employees.add(user);
        System.out.println(employees);
        return user;
    }
        //test only to see if work
        private static List<Employee> createList() {
            List<Employee> tempEmployees = new ArrayList<>();
            Employee emp1 = new Employee();
            emp1.setName("emp1");
            emp1.setDesignation("employer simple");
            emp1.setIdEmployee(3L);

            Employee emp2 = new Employee();
            emp2.setName("emp2");
            emp2.setDesignation("admin");
            emp1.setIdEmployee(2L);

            tempEmployees.add(emp1);
            tempEmployees.add(emp2);
            return tempEmployees;
        }

    }


