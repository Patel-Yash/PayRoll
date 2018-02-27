package com.brevitaz.dao.impl;

import com.brevitaz.config.Config;
import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.SalaryDeductionComponentDao;
import com.brevitaz.model.SalaryDeductionComponent;
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
public class SalaryDeductionComponentDaoImpl implements SalaryDeductionComponentDao
{
   // private final String INDEX_NAME = "salary-deduction-component";
    private final String TYPE_NAME = "doc";

    @Value("${SalaryDeductionComponent-Index-Name}")
    String indexName;

    @Autowired
    Config config;

/*
    @Autowired
    ElasticConfig client;
*/

    @Override
    public boolean create(SalaryDeductionComponent salaryDeductionComponent) throws IOException {
        IndexRequest request = new IndexRequest(
                indexName,
                TYPE_NAME,""+salaryDeductionComponent.getId()
        );

        String json = config.getObjectMapper().writeValueAsString(salaryDeductionComponent);

        request.source(json, XContentType.JSON);

        IndexResponse indexResponse= config.getClient().index(request);

        System.out.println(indexResponse);

        return true;
    }

    @Override
    public List<SalaryDeductionComponent> getAll() throws IOException {
        List<SalaryDeductionComponent > salaryDeductionComponents = new ArrayList<>();
        SearchRequest request = new SearchRequest(indexName);
        request.types(TYPE_NAME);
        SearchResponse response = config.getClient().search(request);
        SearchHit[] hits = response.getHits().getHits();

        SalaryDeductionComponent salaryDeductionComponent;
        for (SearchHit hit : hits)
        {
            salaryDeductionComponent = config.getObjectMapper().readValue(hit.getSourceAsString(), SalaryDeductionComponent.class);
            salaryDeductionComponents.add(salaryDeductionComponent);
        }
        return salaryDeductionComponents;

    }

    @Override
    public boolean update(SalaryDeductionComponent salaryDeductionComponent,String id) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest updateRequest = new UpdateRequest(
                indexName,TYPE_NAME,
                id).doc(objectMapper.writeValueAsString(salaryDeductionComponent), XContentType.JSON);
        UpdateResponse updateResponse = config.getClient().update(updateRequest);
        System.out.println("Update: "+updateResponse);
        return true;
    }

    @Override
    public boolean delete(String id) throws IOException {
        DeleteRequest request = new DeleteRequest(
                indexName,
                TYPE_NAME,
                id);

        DeleteResponse response = config.getClient().delete(request);

        System.out.println(response.status());

        System.out.println(response);
        return true;
    }

    @Override
    public SalaryDeductionComponent getById(String id) throws IOException {
        GetRequest getRequest = new GetRequest(
                indexName,
                TYPE_NAME,
                id);

        GetResponse getResponse = config.getClient().get(getRequest);

        SalaryDeductionComponent salaryDeductionComponent  = config.getObjectMapper().readValue(getResponse.getSourceAsString(),SalaryDeductionComponent.class);

        System.out.println(salaryDeductionComponent);
        return salaryDeductionComponent;
    }

}
