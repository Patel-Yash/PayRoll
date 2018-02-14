package com.brevitaz.controller;

import com.brevitaz.model.SalaryStructureComponent;
import com.brevitaz.model.SalaryStructure;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/payroll-structure")
public class SalaryStructureController {

    @RequestMapping(method = RequestMethod.POST)
    public boolean create(@RequestBody SalaryStructure salarystructure) throws IOException
    {
        return true;
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<SalaryStructureComponent> getAll()
    {
        return null;
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public boolean getByName(@PathVariable String name)
    {
        return true;
    }

    @RequestMapping(value = "/{name}" , method = RequestMethod.PUT)
    public boolean update(@RequestBody SalaryStructure salaryStructure, @PathVariable String name)
    {
        return true;
    }

    @RequestMapping(value = "/{name}" , method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String name)
    {
        return true;
    }







}
