package com.brevitaz.controller;


import com.brevitaz.dao.SalaryStructureComponentDao;
import com.brevitaz.model.SalaryStructure;
import com.brevitaz.model.SalaryStructureComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/salary-structure-component")
public class SalaryStructureComponentController {

    @Autowired
    SalaryStructureComponentDao component;
    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody SalaryStructureComponent salarystructureComponent) throws IOException
    {
        return component.create(salarystructureComponent);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SalaryStructureComponent> getAll()
    {
        return null;
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public boolean getById(@PathVariable String id)
    {
        return true;
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public boolean update(@RequestBody SalaryStructureComponent salaryStructureComponent , @PathVariable String id)
    {
        return true;
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String id)
    {
        return true;
    }


}
