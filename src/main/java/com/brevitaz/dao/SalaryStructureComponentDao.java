package com.brevitaz.dao;

import com.brevitaz.model.Employee;
import com.brevitaz.model.SalaryStructureComponent;

import java.io.IOException;
import java.util.List;

public interface SalaryStructureComponentDao
{
    public boolean create(SalaryStructureComponent salaryStructureComponent) throws IOException;
    public List<SalaryStructureComponent> getAll() throws IOException;
    public boolean update(SalaryStructureComponent salaryStructureComponent,String id) throws IOException;
    public boolean delete(String id)throws IOException;
    public SalaryStructureComponent getById(String id)throws IOException;
}
