package com.brevitaz.model;

import java.util.Date;

public class Employee {

    private String id;
    private String name;
    private String department;
    private Date dateOfJoining;
    private String designation;
    private String location;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDate() {
        return dateOfJoining;
    }

    public void setDate(Date date) {
        this.dateOfJoining = date;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", date=" + dateOfJoining +
                ", designation='" + designation + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
