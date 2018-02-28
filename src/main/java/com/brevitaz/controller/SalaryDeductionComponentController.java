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
    public boolean create(@RequestBody SalaryDeductionComponent salaryDeductionComponent) {
        return salaryDeductionComponentDao.create(salaryDeductionComponent);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<SalaryDeductionComponent> getAll()  {
        return salaryDeductionComponentDao.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean update(@RequestBody SalaryDeductionComponent salaryDeductionComponent, @PathVariable String id) {
        return salaryDeductionComponentDao.update(salaryDeductionComponent,id);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String id) {
        return salaryDeductionComponentDao.delete(id);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public SalaryDeductionComponent getById(@PathVariable String id)  {
        return salaryDeductionComponentDao.getById(id);
    }
}
