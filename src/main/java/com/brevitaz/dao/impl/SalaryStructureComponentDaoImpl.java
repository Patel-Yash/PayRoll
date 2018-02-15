package com.brevitaz.dao.impl;

import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.SalaryStructureComponentDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.SalaryStructureComponent;
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
public class SalaryStructureComponentDaoImpl implements SalaryStructureComponentDao
{

    private final String INDEX_NAME = "salarystructurecomponent";
    private final String TYPE_NAME = "doc";

    ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    ElasticConfig client;

    @Override
    public boolean create(SalaryStructureComponent salaryStructureComponent) throws IOException {
        IndexRequest request = new IndexRequest(
                INDEX_NAME,
                TYPE_NAME,""+salaryStructureComponent.getId()
        );

        //ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(salaryStructureComponent);

        request.source(json, XContentType.JSON);

        IndexResponse indexResponse= client.getClient().index(request);

        System.out.println(indexResponse);

        return true;
    }

    @Override
    public List<SalaryStructureComponent> getAll() throws IOException {
        List<SalaryStructureComponent > salaryStructureComponents = new ArrayList<>();
        SearchRequest request = new SearchRequest(INDEX_NAME);
        request.types(TYPE_NAME);
        SearchResponse response = client.getClient().search(request);
        SearchHit[] hits = response.getHits().getHits();

        SalaryStructureComponent salaryStructureComponent;

        for (SearchHit hit : hits)
        {
            salaryStructureComponent = objectMapper.readValue(hit.getSourceAsString(), SalaryStructureComponent.class);
            salaryStructureComponents.add(salaryStructureComponent);
        }
        return salaryStructureComponents;

    }

    @Override
    public boolean update(SalaryStructureComponent salaryStructureComponent,String id) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest updateRequest = new UpdateRequest(
                INDEX_NAME,TYPE_NAME,
                id).doc(objectMapper.writeValueAsString(salaryStructureComponent), XContentType.JSON);
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
    public SalaryStructureComponent getById(String id) throws IOException {
        GetRequest getRequest = new GetRequest(
                INDEX_NAME,
                TYPE_NAME,
                id);

        GetResponse getResponse = client.getClient().get(getRequest);

        ObjectMapper objectMapper = new ObjectMapper();

        SalaryStructureComponent salaryStructureComponent  = objectMapper.readValue(getResponse.getSourceAsString(),SalaryStructureComponent.class);


        System.out.println(salaryStructureComponent);
        return salaryStructureComponent;
    }

}
