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
    public boolean create(@RequestBody SalaryStructure salaryStructure)
    {
        return true;
    }

    @RequestMapping(method = RequestMethod.GET)
    public SalaryStructure getById(@PathVariable String id)
    {
        return null;
    }






}
