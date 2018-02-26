package com.brevitaz.controller;


import com.brevitaz.dao.SalaryDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    SalaryDao salaryDao;

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody Salary salary) throws IOException// give salary a ssid
    {
        return salaryDao.create(salary);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Salary> getAll() throws IOException {
        return salaryDao.getAll();


    }

    @RequestMapping(value = "/{salary-id}", method = RequestMethod.PUT)
    public boolean update(@RequestBody Salary salary, @PathVariable String salaryId) throws IOException {
        return salaryDao.update(salary,salaryId);

    }

    @RequestMapping(value = "/{salary-id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String salaryId) throws IOException {
        return salaryDao.delete(salaryId);

    }

    @RequestMapping(value = "/{salary-id}", method = {RequestMethod.GET})
    public Salary getById(@PathVariable String salaryId) throws IOException {
       return salaryDao.getById(salaryId);

    }
}
