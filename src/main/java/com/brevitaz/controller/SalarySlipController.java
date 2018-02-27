package com.brevitaz.controller;

import com.brevitaz.dao.SalarySlipDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.SalarySlip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/salary-slips")
public class SalarySlipController
{

    @Autowired
    SalarySlipDao salarySlipDao;

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody SalarySlip salarySlip) throws IOException {
        return salarySlipDao.create(salarySlip);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SalarySlip> getAll() throws IOException {
        return salarySlipDao.getAll();

    }

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
    public boolean update(@RequestBody SalarySlip salarySlip, @PathVariable String employeeId) throws IOException {
        return salarySlipDao.update(salarySlip,employeeId);

    }

    @RequestMapping(value = "/{employeeId}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String employeeId) throws IOException {
        return salarySlipDao.delete(employeeId);

    }

    @RequestMapping(value = "/{employeeId}", method = {RequestMethod.GET})
    public SalarySlip getById(@PathVariable String employeeId) throws IOException {
        return salarySlipDao.getById(employeeId);

    }
}
