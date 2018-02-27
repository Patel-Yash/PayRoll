package com.brevitaz.dao.impl;

import com.brevitaz.config.Config;
import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.SalarySlipDao;
import com.brevitaz.model.SalarySlip;
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
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SalarySlipDaoImpl implements SalarySlipDao
{
    //private final String INDEX_NAME = "salary-slip";
    private final String TYPE_NAME = "doc";

    @Value("${SalarySlip-Index-Name}")
    String indexName;

    @Autowired
    Config config;

/*
    @Autowired
    ElasticConfig client;
*/

    @Override
    public boolean create(SalarySlip salarySlip) throws IOException {
        IndexRequest request = new IndexRequest(
                indexName,
                TYPE_NAME,salarySlip.getEmployeeId()
        );

        String json = config.getObjectMapper().writeValueAsString(salarySlip);

        request.source(json, XContentType.JSON);

        IndexResponse indexResponse= config.getClient().index(request);

        System.out.println(indexResponse);

        return true;
    }

    @Override
    public List<SalarySlip> getAll() throws IOException {
        List<SalarySlip> salarySlips = new ArrayList<>();
        SearchRequest request = new SearchRequest(indexName);
        request.types(TYPE_NAME);
        SearchResponse response = config.getClient().search(request);
        SearchHit[] hits = response.getHits().getHits();

        SalarySlip salarySlip;

        for (SearchHit hit : hits)
        {
            salarySlip = config.getObjectMapper().readValue(hit.getSourceAsString(), SalarySlip.class);
            salarySlips.add(salarySlip);
        }
        return salarySlips;

    }

    @Override
    public boolean update(SalarySlip salarySlip,String employeeId) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest updateRequest = new UpdateRequest(
                indexName,TYPE_NAME,
                employeeId).doc(objectMapper.writeValueAsString(salarySlip), XContentType.JSON);
        UpdateResponse updateResponse = config.getClient().update(updateRequest);
        System.out.println("Update: "+updateResponse);
        return true;
    }

    @Override
    public boolean delete(String employeeId) throws IOException {
        DeleteRequest request = new DeleteRequest(
                indexName,
                TYPE_NAME,
                employeeId);

        DeleteResponse response = config.getClient().delete(request);

        System.out.println(response.status());

        System.out.println(response);
        return true;
    }

    @Override
    public SalarySlip getById(String employeeId) throws IOException {
        GetRequest getRequest = new GetRequest(
                indexName,
                TYPE_NAME,
                employeeId);

        GetResponse getResponse = config.getClient().get(getRequest);

        SalarySlip salarySlip  = config.getObjectMapper().readValue(getResponse.getSourceAsString(),SalarySlip.class);

        System.out.println(salarySlip);
        return salarySlip;
    }
}
