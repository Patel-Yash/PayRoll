package com.brevitaz.dao;

import com.brevitaz.model.Salary;

import java.io.IOException;
import java.util.List;

public interface SalaryDao
{
    public boolean create(Salary salary) throws IOException;
    public List<Salary> getAll() throws IOException;
    public boolean update(Salary salary,String salaryId) throws IOException;
    public boolean delete(String salaryId)throws IOException;
    public Salary getById(String salaryId)throws IOException;
}
