package com.brevitaz.dao.impl;

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
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SalaryDeductionComponentDaoImpl implements SalaryDeductionComponentDao
{
    private final String INDEX_NAME = "salary-deduction-component";
    private final String TYPE_NAME = "doc";

    ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    ElasticConfig client;

    @Override
    public boolean create(SalaryDeductionComponent salaryDeductionComponent) throws IOException {
        IndexRequest request = new IndexRequest(
                INDEX_NAME,
                TYPE_NAME,""+salaryDeductionComponent.getId()
        );

        //ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(salaryDeductionComponent);

        request.source(json, XContentType.JSON);

        IndexResponse indexResponse= client.getClient().index(request);

        System.out.println(indexResponse);

        return true;
    }

    @Override
    public List<SalaryDeductionComponent> getAll() throws IOException {
        List<SalaryDeductionComponent > salaryDeductionComponents = new ArrayList<>();
        SearchRequest request = new SearchRequest(INDEX_NAME);
        request.types(TYPE_NAME);
        SearchResponse response = client.getClient().search(request);
        SearchHit[] hits = response.getHits().getHits();

        SalaryDeductionComponent salaryDeductionComponent;
        for (SearchHit hit : hits)
        {
            salaryDeductionComponent = objectMapper.readValue(hit.getSourceAsString(), SalaryDeductionComponent.class);
            salaryDeductionComponents.add(salaryDeductionComponent);
        }
        return salaryDeductionComponents;

    }

    @Override
    public boolean update(SalaryDeductionComponent salaryDeductionComponent,String id) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest updateRequest = new UpdateRequest(
                INDEX_NAME,TYPE_NAME,
                id).doc(objectMapper.writeValueAsString(salaryDeductionComponent), XContentType.JSON);
        UpdateResponse updateResponse = client.getClient().update(updateRequest);
        System.out.println("Update: "+updateResponse);
        return true;
    }

    @Override
    public boolean delete(String id) throws IOException {
        DeleteRequest request = new DeleteRequest(
                INDEX_NAME,
                TYPE_NAME,
                id);

        DeleteResponse response = client.getClient().delete(request);

        System.out.println(response.status());

        System.out.println(response);
        return true;
    }

    @Override
    public SalaryDeductionComponent getById(String id) throws IOException {
        GetRequest getRequest = new GetRequest(
                INDEX_NAME,
                TYPE_NAME,
                id);

        GetResponse getResponse = client.getClient().get(getRequest);

        ObjectMapper objectMapper = new ObjectMapper();

        SalaryDeductionComponent salaryDeductionComponent  = objectMapper.readValue(getResponse.getSourceAsString(),SalaryDeductionComponent.class);

        System.out.println(salaryDeductionComponent);
        return salaryDeductionComponent;
    }

}
