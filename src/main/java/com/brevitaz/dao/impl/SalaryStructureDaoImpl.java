package com.brevitaz.dao.impl;

import com.brevitaz.config.Config;
import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.SalaryStructureDao;
import com.brevitaz.model.Salary;
import com.brevitaz.model.SalaryStructure;
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
public class SalaryStructureDaoImpl implements SalaryStructureDao {
    //private final String INDEX_NAME = "salary-structure";
    private final String TYPE_NAME = "doc";

    @Value("${SalaryStructure-Index-Name}")
    String indexName;

    @Autowired
    Config config;

/*
    @Autowired
    ElasticConfig client;
*/

    @Override
    public boolean create(SalaryStructure salaryStructure) {
        config.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            IndexRequest request = new IndexRequest(
                    indexName,
                    TYPE_NAME, salaryStructure.getId()
            );

            String json = config.getObjectMapper().writeValueAsString(salaryStructure);

            request.source(json, XContentType.JSON);

            IndexResponse indexResponse = config.getClient().index(request);

            System.out.println(indexResponse);
            if (indexResponse.status() == RestStatus.CREATED) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<SalaryStructure> getAll() {
        List<SalaryStructure> salaryStructures = new ArrayList<>();
        try {
            SearchRequest request = new SearchRequest(indexName);
            request.types(TYPE_NAME);
            SearchResponse response = config.getClient().search(request);
            SearchHit[] hits = response.getHits().getHits();

            SalaryStructure salaryStructure;

            for (SearchHit hit : hits) {
                salaryStructure = config.getObjectMapper().readValue(hit.getSourceAsString(), SalaryStructure.class);
                salaryStructures.add(salaryStructure);
            }
            if (response.status() == RestStatus.OK) {
                return salaryStructures;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(SalaryStructure salaryStructure, String id) {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            UpdateRequest updateRequest = new UpdateRequest(
                    indexName, TYPE_NAME,
                    id).doc(objectMapper.writeValueAsString(salaryStructure), XContentType.JSON);
            UpdateResponse updateResponse = config.getClient().update(updateRequest);
            System.out.println("Update: " + updateResponse);
            if (updateResponse.status() == RestStatus.OK) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        DeleteRequest request = new DeleteRequest(
                indexName,
                TYPE_NAME,
                id);
        try {
            DeleteResponse response = config.getClient().delete(request);

            System.out.println(response.status());

            System.out.println(response);
            if (response.status() == RestStatus.OK) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public SalaryStructure getById(String id) {
        GetRequest getRequest = new GetRequest(
                indexName,
                TYPE_NAME,
                id);
        try {
            GetResponse getResponse = config.getClient().get(getRequest);

            SalaryStructure salaryStructure = config.getObjectMapper().readValue(getResponse.getSourceAsString(), SalaryStructure.class);

            System.out.println(salaryStructure);
            if (getResponse.isExists())
            {
            return salaryStructure;}
            else {
                return null;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
