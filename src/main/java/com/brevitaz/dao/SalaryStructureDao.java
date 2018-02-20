package com.brevitaz.dao;

import com.brevitaz.model.SalaryStructure;

import java.io.IOException;
import java.util.List;

public interface SalaryStructureDao
{
    public boolean create(SalaryStructure salaryStructure) throws IOException;
    public List<SalaryStructure> getAll() throws IOException;
    public boolean update(SalaryStructure salaryStructure,String id) throws IOException;
    public boolean delete(String id)throws IOException;
    public SalaryStructure getById(String id)throws IOException;
}
