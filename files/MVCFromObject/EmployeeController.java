package com.peterservice.web.controller;


import com.peterservice.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {

    // Реализация HandlerMapping
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ModelAndView employeeOne() {

        ModelAndView model = new ModelAndView();
        model.setViewName("employeeOne");

        Employee empOne = new Employee(1,"first", new Date());
        model.addObject("employeeFor",empOne);

        return model;

    }

    // Реализация HandlerMapping
    @RequestMapping(value = "/manyEmp", method = RequestMethod.GET)
    public ModelAndView employeeMany() {

        ModelAndView model = new ModelAndView();
        model.setViewName("employeeMany");

        List<Employee> lEmp = new ArrayList<>();
        lEmp.add(new Employee(1,"first", new Date()));
        lEmp.add(new Employee(2,"second", new Date()));
        model.addObject("employeeSFor",lEmp);


        List<String> sEmp = new ArrayList<>();
        sEmp.add("fist");
        sEmp.add("next");
        model.addObject("sFor",sEmp);

        return model;

    }
}

