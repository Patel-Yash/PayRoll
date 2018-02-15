package com.brevitaz.dao;


import com.brevitaz.model.SalaryStructureComponent;

import java.io.IOException;
import java.util.List;

public interface SalaryStructureComponentDao {

    public boolean create(SalaryStructureComponent component) throws IOException;
    public List<SalaryStructureComponent> getAll() throws IOException;
    public boolean update(SalaryStructureComponent component,String id) throws IOException;
    public boolean delete(String id)throws IOException;
    public SalaryStructureComponent getById(String id)throws IOException;
}
