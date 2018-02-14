package com.brevitaz.dao;

import com.brevitaz.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

public interface EmployeeDao
{
    public boolean create(Employee employee) throws IOException;
    public List<Employee> getAll();
    public boolean update();
    public boolean delete();
    public Employee getById();
}
