package com.peterservice.web.controller;


import com.peterservice.web.model.Employee;
import com.peterservice.web.model.EmployeeList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class EmployeeRestController {
    @RequestMapping(value = "/employees")
    public EmployeeList getAllEmployees() {
        EmployeeList employees = new EmployeeList();
        employees.getEmployees().add(new Employee(1, "first", new Date()));
        employees.getEmployees().add(new Employee(2, "second", new Date()));
        employees.getEmployees().add(new Employee(3, "third", new Date()));
        return employees;
    }

    @RequestMapping(value = "/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        EmployeeList employees = new EmployeeList();
        employees.getEmployees().add(new Employee(1, "first", new Date()));
        employees.getEmployees().add(new Employee(2, "second", new Date()));
        employees.getEmployees().add(new Employee(3, "third", new Date()));

        if (id<employees.getEmployees().size()) {
            Employee employee = employees.getEmployees().get(id);
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}

