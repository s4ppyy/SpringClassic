package com.peterservice.web.controller;

import com.peterservice.web.model.Employee;
import com.peterservice.web.model.EmployeeList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class EmployeeRestController {

    private EmployeeList getAllEmployees() {
        EmployeeList employees = new EmployeeList();
        employees.getEmployees().add(new Employee(1, "first", new Date()));
        employees.getEmployees().add(new Employee(2, "second", new Date()));
        employees.getEmployees().add(new Employee(3, "third", new Date()));
        return employees;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET, headers="Accept=application/json")
    public String getAllEmployeesJSON(Model model) {
        model.addAttribute("employees",getAllEmployees());
        return "jsonTemplate";
    }

    @RequestMapping(value = "/employee/{id}" , method = RequestMethod.GET )
    public String getEmployeeByIdJSON(Model model,@PathVariable("id") int id) {
        model.addAttribute("employee", getEmployeeById(id));
        return "jsonTemplate";
    }

//    public ResponseEntity<Employee> getEmployeeById(@PathVariable if (id<=employees.getEmployees().size()) {
//Employee employee = employees.getEmployees().get(id);
//    return new ResponseEntity<Employee>(employee, HttpStatus.OK);
//}
//return new ResponseEntity(HttpStatus.NOT_FOUND);
//        ("id") int id) {

    public Employee getEmployeeById( int id) {
        EmployeeList employees = new EmployeeList();
        employees.getEmployees().add(new Employee(1, "first", new Date()));
        employees.getEmployees().add(new Employee(2, "second", new Date()));
        employees.getEmployees().add(new Employee(3, "third", new Date()));

        if (id<=employees.getEmployees().size()) {
            Employee employee = employees.getEmployees().get(id-1);
            return employee;
        }
        return new Employee();
    }


    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void remEmployeeByID(@PathVariable String id) {
        System.out.println(id);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public @ResponseBody void putEmployeeByID(@PathVariable String id) {
        System.out.println("PUT"+id);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.POST)
    public @ResponseBody void postEmployeeByID(@PathVariable String id) {
        System.out.println("POST"+id);
    }

}

