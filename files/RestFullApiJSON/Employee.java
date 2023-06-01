package com.peterservice.web.model;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "employee")
public class Employee {

    private int id;


    private String strName;


    private Date dtWork;

    public Employee(int id, String strName, Date dtWork) {
        this.id = id;
        this.strName = strName;
        this.dtWork = dtWork;
    }



    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public Date getDtWork() {
        return dtWork;
    }

    public void setDtWork(Date dtWork) {
        this.dtWork = dtWork;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", strName='" + strName + '\'' +
                ", dtWork=" + dtWork +
                '}';
    }
}
