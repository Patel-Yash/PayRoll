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
        employee.setName("Arpy");
        //employee.setDate("2018-02-22");
        employee.setDepartment("Developing");
        employee.setDesignation("Developer");
        employee.setLocation("Ahmedabad");

        boolean status = employeeDao.create(employee);
        Assert.assertEquals(true,status);
    }

    @Test
    public void getAllTest() throws IOException {
        List<Employee> employees = employeeDao.getAll();
        int size = employees.size();
        Assert.assertEquals(1,size);
    }

    @Test
    public void getTest() throws IOException {
        Employee employee = employeeDao.getById("1");
        Assert.assertNotNull(employee);
    }

    @Test
    public void updateTest() throws IOException {
        Employee employee = new Employee();
        employee.setName("Yash");
        boolean status = employeeDao.update(employee,"1");
        Assert.assertEquals(true,status);
    }

    @Test
    public void deleteTest() throws IOException {
        boolean status=employeeDao.delete("1");
        Assert.assertEquals(true,status);
    }

}
