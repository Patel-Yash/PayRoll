package com.brevitaz.dao.impl;

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
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SalarySlipDaoImpl implements SalarySlipDao
{
    private final String INDEX_NAME = "salary-slip";
    private final String TYPE_NAME = "doc";

    ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    ElasticConfig client;

    @Override
    public boolean create(SalarySlip salarySlip) throws IOException {
        IndexRequest request = new IndexRequest(
                INDEX_NAME,
                TYPE_NAME,""+salarySlip.getEid()
        );

        //ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(salarySlip);

        request.source(json, XContentType.JSON);

        IndexResponse indexResponse= client.getClient().index(request);

        System.out.println(indexResponse);

        return true;
    }

    @Override
    public List<SalarySlip> getAll() throws IOException {
        List<SalarySlip> salarySlips = new ArrayList<>();
        SearchRequest request = new SearchRequest(INDEX_NAME);
        request.types(TYPE_NAME);
        SearchResponse response = client.getClient().search(request);
        SearchHit[] hits = response.getHits().getHits();

        SalarySlip salarySlip;

        for (SearchHit hit : hits)
        {
            salarySlip = objectMapper.readValue(hit.getSourceAsString(), SalarySlip.class);
            salarySlips.add(salarySlip);
        }
        return salarySlips;

    }

    @Override
    public boolean update(SalarySlip salarySlip,String eid) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest updateRequest = new UpdateRequest(
                INDEX_NAME,TYPE_NAME,
                eid).doc(objectMapper.writeValueAsString(salarySlip), XContentType.JSON);
        UpdateResponse updateResponse = client.getClient().update(updateRequest);
        System.out.println("Update: "+updateResponse);
        return true;
    }

    @Override
    public boolean delete(String eid) throws IOException {
        DeleteRequest request = new DeleteRequest(
                INDEX_NAME,
                TYPE_NAME,
                eid);

        DeleteResponse response = client.getClient().delete(request);

        System.out.println(response.status());

        System.out.println(response);
        return true;
    }

    @Override
    public SalarySlip getById(String eid) throws IOException {
        GetRequest getRequest = new GetRequest(
                INDEX_NAME,
                TYPE_NAME,
                eid);

        GetResponse getResponse = client.getClient().get(getRequest);

        ObjectMapper objectMapper = new ObjectMapper();

        SalarySlip salarySlip  = objectMapper.readValue(getResponse.getSourceAsString(),SalarySlip.class);

        System.out.println(salarySlip);
        return salarySlip;
    }
}
