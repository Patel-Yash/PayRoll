package com.brevitaz.controller;

import com.brevitaz.model.Slip;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payroll-slip")

public class PayRollSlipController {

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public void create(@RequestBody Slip slip)
    {
        System.out.println("slip is generated.");
    }

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public void getAll()
    {
        System.out.println("slip is viewed.");
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public void getById(@PathVariable String id)
    {
        System.out.println("myslip is viewed.");
    }

}
