package com.brevitaz.dao.impl;

import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.EmployeeDao;
import com.brevitaz.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{

    private final String INDEX_NAME = "employee";
    private final String TYPE_NAME = "doc";
    @Autowired
    ElasticConfig client;

    @Override
    public boolean create(Employee employee) throws IOException {
        IndexRequest request = new IndexRequest(
                INDEX_NAME,
                TYPE_NAME,""+employee.getId()
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(employee);

        request.source(json, XContentType.JSON);

        IndexResponse indexResponse= client.getClient().index(request);

        System.out.println(indexResponse);

        return true;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public Employee getById() {
        return null;
    }
}
