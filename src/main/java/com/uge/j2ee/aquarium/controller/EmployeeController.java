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

      /*  private List<Employee> employees = createList();

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

    @PostMapping(path = "/createEmployee")
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
        }*/

    }


