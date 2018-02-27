package com.brevitaz.controller;

import com.brevitaz.dao.SalaryDeductionComponentDao;
import com.brevitaz.dao.SalaryStructureComponentDao;
import com.brevitaz.model.SalaryDeductionComponent;
import com.brevitaz.model.SalaryStructureComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/salary-deduction-component")
public class SalaryDeductionComponentController {

    @Autowired
    SalaryDeductionComponentDao salaryDeductionComponentDao;

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody SalaryDeductionComponent salaryDeductionComponent) throws IOException {
        return salaryDeductionComponentDao.create(salaryDeductionComponent);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<SalaryDeductionComponent> getAll() throws IOException {
        return salaryDeductionComponentDao.getAll();
    }

    @RequestMapping(value = "/{salary-deduction-component-id}", method = RequestMethod.PUT)
    public boolean update(@RequestBody SalaryDeductionComponent salaryDeductionComponent, @PathVariable String salaryDeductionComponentId) throws IOException {
        return salaryDeductionComponentDao.update(salaryDeductionComponent,salaryDeductionComponentId);
    }

    @RequestMapping(value = "/{salary-deduction-component-id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String salaryDeductionComponentId) throws IOException {
        return salaryDeductionComponentDao.delete(salaryDeductionComponentId);
    }

    @RequestMapping(value = "/{salary-deduction-component-id}", method = {RequestMethod.GET})
    public SalaryDeductionComponent getById(@PathVariable String salaryDeductionComponentId) throws IOException {
        return salaryDeductionComponentDao.getById(salaryDeductionComponentId);
    }
}
