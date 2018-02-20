package com.brevitaz.controller;

import com.brevitaz.model.Employee;
import com.brevitaz.model.SalarySlip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/salary-slip")
public class SalarySlipController
{

    @Autowired
    SalarySlip salarySlip;

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody SalarySlip salarySlip) throws IOException {
        return salarySlipDao.create(salarySlip);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SalarySlip> getAll() throws IOException {
        return salarySlip.getAll();

    }

    @RequestMapping(value = "/{eid}", method = RequestMethod.PUT)
    public boolean update(@RequestBody SalarySlip salarySlip, @PathVariable String eid) throws IOException {
        return salarySlip.update(salarySlip,eid);

    }

    @RequestMapping(value = "/{eid}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String eid) throws IOException {
        return salarySlip.delete(id);

    }

    @RequestMapping(value = "/{eid}", method = {RequestMethod.GET})
    public Employee getById(@PathVariable String eid) throws IOException {
        return salarySlip.getById(eid);

    }
}
