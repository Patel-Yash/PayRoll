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
    public boolean create(@RequestBody Salary salary) throws IOException {
        return salaryDao.create(salary);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Salary> getAll() throws IOException {
        return salaryDao.getAll();


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update(@RequestBody Salary salary, @PathVariable String id) throws IOException {
        return salaryDao.update(salary,id);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String id) throws IOException {
        return salaryDao.delete(id);

    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Salary getById(@PathVariable String id) throws IOException {
       return salaryDao.getById(id);

    }
}
