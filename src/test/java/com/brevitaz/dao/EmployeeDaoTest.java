package com.brevitaz.dao;


import com.brevitaz.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmployeeDaoTest
{

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void createTest() throws IOException {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("Arpy");/*
        employee.setDate(2018-02-22);*/
        employee.setDepartment("Developing");
        employee.setDesignation("Developer");
        employee.setLocation("Ahmedabad");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);
    }

    @Test
    public void getAllTest() throws IOException {
        Employee employee = new Employee();
        employee.setId("3");
        employee.setName("dffbf");
        employee.setDepartment("ndfhfjd");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);

        List<Employee> employees = employeeDao.getAll();
        int size = employees.size();
        Assert.assertEquals(4,size);
    }

    @Test
    public void getTest() throws IOException {
        Employee employee = new Employee();
        employee.setId("3");
        employee.setName("Pr");/*
        employee.setDate(2018-02-22);*/
        employee.setDepartment("Developing");
        employee.setDesignation("Developer");
        employee.setLocation("Ahmedabad");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);

        employee = employeeDao.getById("3");
        Assert.assertNotNull(employee);
    }

    @Test
    public void updateTest() throws IOException {
        Employee employee = new Employee();
        employee.setId("4");
        employee.setName("Anushka");/*
        employee.setDate(2018-02-22);*/
        employee.setDepartment("Developing");
        employee.setDesignation("Developer");
        employee.setLocation("Ahmedabad");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);

        employee.setName("Anoushka");

        boolean status1 = employeeDao.update(employee,"4");
        Assert.assertEquals(true,status1);
    }

    @Test
    public void deleteTest() throws IOException {

        Employee employee = new Employee();
        employee.setId("5");
        employee.setName("Adhi");/*
        employee.setDate(2018-02-22);*/
        employee.setDepartment("Developing");
        employee.setDesignation("Developer");
        employee.setLocation("Ahmedabad");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);

        boolean status1=employeeDao.delete("5");
        Assert.assertEquals(true,status1);
    }

}
