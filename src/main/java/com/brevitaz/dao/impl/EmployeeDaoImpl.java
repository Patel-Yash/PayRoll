package com.brevitaz.dao.impl;

import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.EmployeeDao;
import com.brevitaz.model.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{

    private final String INDEX_NAME = "employee";
    private final String TYPE_NAME = "doc";

    ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    ElasticConfig client;

    @Override
    public boolean create(Employee employee) throws IOException {
        IndexRequest request = new IndexRequest(
                INDEX_NAME,
                TYPE_NAME,""+employee.getId()
        );

        //ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(employee);

        request.source(json, XContentType.JSON);

        IndexResponse indexResponse= client.getClient().index(request);

        System.out.println(indexResponse);

        return true;
    }

    @Override
    public List<Employee> getAll() throws IOException {
        List<Employee> employees = new ArrayList<>();
        SearchRequest request = new SearchRequest(INDEX_NAME);
        request.types(TYPE_NAME);
        SearchResponse response = client.getClient().search(request);
        SearchHit[] hits = response.getHits().getHits();

        Employee employee;

        for (SearchHit hit : hits)
        {
            employee = objectMapper.readValue(hit.getSourceAsString(), Employee.class);
            employees.add(employee);
        }
        return employees;

    }

    @Override
    public boolean update(Employee employee,String id) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest updateRequest = new UpdateRequest(
                INDEX_NAME,TYPE_NAME,
                id).doc(objectMapper.writeValueAsString(employee), XContentType.JSON);
        UpdateResponse updateResponse = client.getClient().update(updateRequest);
        System.out.println("Update: "+updateResponse);
        return true;
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
