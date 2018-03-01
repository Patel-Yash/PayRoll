package com.brevitaz.dao.impl;

import com.brevitaz.config.Config;
import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.SalaryDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.Salary;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SalaryDaoImpl implements SalaryDao
{
    //private final String INDEX_NAME = "salary";
    private final String TYPE_NAME = "doc";


    @Value("${Salary-Index-Name}")
    String indexName;

    @Autowired
    Config config;

/*
    @Autowired
    ElasticConfig client;
*/

    @Override
    public boolean create(Salary salary)  {
        config.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        IndexRequest request = new IndexRequest(
                indexName,
                TYPE_NAME,salary.getId());
        try {

            String json = config.getObjectMapper().writeValueAsString(salary);

            request.source(json, XContentType.JSON);

            IndexResponse indexResponse = config.getClient().index(request);
            System.out.println(indexResponse);
            if (indexResponse.status() == RestStatus.OK)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Salary> getAll() {
        List<Salary> salaries = new ArrayList<>();
        SearchRequest request = new SearchRequest(indexName);
        request.types(TYPE_NAME);
        try {
            SearchResponse response = config.getClient().search(request);
            SearchHit[] hits = response.getHits().getHits();

            for (SearchHit hit : hits) {
                Salary salary = config.getObjectMapper().readValue(hit.getSourceAsString(), Salary.class);
                salaries.add(salary);
            }
            if(response.status() == RestStatus.OK)
            {
                return salaries;
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Salary salary,String id) {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            UpdateRequest updateRequest = new UpdateRequest(
                    indexName, TYPE_NAME,
                    id).doc(objectMapper.writeValueAsString(salary), XContentType.JSON);
            UpdateResponse updateResponse = config.getClient().update(updateRequest);
            System.out.println("Update: " + updateResponse);
            if(updateResponse.status() == RestStatus.OK)
            {
                return true;
            }
           else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id)  {
        DeleteRequest request = new DeleteRequest(
                indexName,
                TYPE_NAME,
                id);
    try {
        DeleteResponse response = config.getClient().delete(request);

        System.out.println(response.status());

        System.out.println(response);
        if (response.status() == RestStatus.OK)
        {
            return true;
        }
        else
        {
            return false;
        }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Salary getById(String id) {
        GetRequest getRequest = new GetRequest(
                indexName,
                TYPE_NAME,
                id);
        try {
            GetResponse getResponse = config.getClient().get(getRequest);


            Salary salary = config.getObjectMapper().readValue(getResponse.getSourceAsString(), Salary.class);
            System.out.println(salary);
            if (getResponse.isExists()) {
                return salary;
            }
            else
            {
                return null;
            }
            }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
