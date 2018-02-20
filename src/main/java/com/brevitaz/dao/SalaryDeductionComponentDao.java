package com.brevitaz.dao;

import com.brevitaz.model.SalaryDeductionComponent;
import com.brevitaz.model.SalaryStructureComponent;

import java.io.IOException;
import java.util.List;

public interface SalaryDeductionComponentDao
{
    public boolean create(SalaryDeductionComponent salaryDeductionComponent) throws IOException;
    public List<SalaryDeductionComponent> getAll() throws IOException;
    public boolean update(SalaryDeductionComponent salaryDeductionComponent,String id) throws IOException;
    public boolean delete(String id)throws IOException;
    public SalaryDeductionComponent getById(String id)throws IOException;
}
