package com.brevitaz.dao.impl;

import com.brevitaz.dao.SalaryDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.Salary;

import java.io.IOException;
import java.util.List;

public class SalaryDaoImpl implements SalaryDao {
    @Override
    public boolean create(Salary salary) throws IOException {
        return false;
    }

    @Override
    public List<Salary> getAll() throws IOException {
        return null;
    }

    @Override
    public boolean update(Salary salary, String id) throws IOException {
        return false;
    }

    @Override
    public boolean delete(String id) throws IOException {
        return false;
    }

    @Override
    public Employee getById(String id) throws IOException {
        return null;
    }
}
