package com.brevitaz.controller;


import com.brevitaz.dao.EmployeeDao;
import com.brevitaz.dao.impl.EmployeeDaoImpl;
import com.brevitaz.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody Employee employee) throws IOException {
        return employeeDao.create(employee);

    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getAll() throws IOException {
         return employeeDao.getAll();

    }

    @RequestMapping(value = "/{employee-id}", method = RequestMethod.PUT)
    public boolean update(@RequestBody Employee employee, @PathVariable String employeeId) throws IOException {
        return employeeDao.update(employee,employeeId);

    }

    @RequestMapping(value = "/{employee-id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String employeeId) throws IOException {
        return employeeDao.delete(employeeId);

    }

    @RequestMapping(value = "/{employee-id}", method = {RequestMethod.GET})
    public Employee getById(@PathVariable String employeeId) throws IOException {
         return employeeDao.getById(employeeId);

    }
}