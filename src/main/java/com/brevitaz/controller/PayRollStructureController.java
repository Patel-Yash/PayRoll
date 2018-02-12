package com.brevitaz.controller;

import com.brevitaz.model.Employee;
import com.brevitaz.model.Slip;
import com.brevitaz.model.Structure;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payroll-structure")
public class PayRollStructureController {

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public void create(@RequestBody Structure structure)
    {
        System.out.println("structure is created.");
    }


    @RequestMapping(value = "" , method = RequestMethod.GET)
    public void getAll()
    {
        System.out.println("structure is viewed.");
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public void update(@RequestBody Structure structure, @PathVariable String id)
    {
        System.out.println("structure is updated.");
    }



   /* @RequestMapping(value = "/generate-slip" , method = RequestMethod.GET)
    public void generateSlipPDF(@RequestBody Employee employee)
    {
        System.out.println("record is viewed.");
    }
*/
   /* @RequestMapping(value = "/checkRequest" , method = RequestMethod.GET)
    public void mailSlipPDF(@RequestBody Employee employee)
    {
        System.out.println("request is checked.");
    }*/

    /*@RequestMapping(value = "/approveRequest" , method = RequestMethod.POST)
    public void viewMySlipPDF(@RequestBody Employee employee)
    {
        System.out.println("request is approved.");
    }*/




}
