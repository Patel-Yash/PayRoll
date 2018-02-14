package com.brevitaz.controller;


import com.brevitaz.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody Employee employee) throws IOException {
        // return employeeDao.insert(employee);
        return true;
    }


    @RequestMapping(method = {RequestMethod.GET})
    public List<Employee> getAll() throws IOException {
        // return employeeDao.getAll();
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update(@RequestBody Employee employee, @PathVariable String id) throws IOException {
        //return employeeDao.update(employee,id);
        return true;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String id) throws IOException {
        //return employeeDao.delete(id);
        return true;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Employee getById(@PathVariable String id) throws IOException {
        // return employeeDao.getById(id);
        return null;
    }
}