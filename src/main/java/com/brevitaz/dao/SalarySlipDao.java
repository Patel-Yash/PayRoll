package com.brevitaz.dao;


import com.brevitaz.model.SalarySlip;

import java.io.IOException;
import java.util.List;

public interface SalarySlipDao
{
    public boolean create(SalarySlip salarySlip) throws IOException;
    public List<SalarySlip> getAll() throws IOException;
    public boolean update(SalarySlip salarySlip,String employeeId) throws IOException;
    public boolean delete(String employeeId)throws IOException;
    public SalarySlip getById(String employeeId)throws IOException;
}
