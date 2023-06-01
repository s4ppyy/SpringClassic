package com.peterservice.web.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="employees")
public class EmployeeList {
    private static final long serialVersionUID = 1L;

    private List<Employee> employees = new ArrayList<Employee>();

    public EmployeeList() {
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
