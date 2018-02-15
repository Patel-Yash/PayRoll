package com.brevitaz.dao.impl;

import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.SalaryStructureComponentDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.SalaryStructureComponent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class SalaryStructureComponentDaoImpl  implements SalaryStructureComponentDao
{

    private final String INDEX_NAME = "component";
    private final String TYPE_NAME = "doc";

    @Autowired
    ElasticConfig client;

    ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public boolean create(SalaryStructureComponent component) throws IOException {
        IndexRequest request = new IndexRequest(
                INDEX_NAME,
                TYPE_NAME,""+component.getId()
        );

        //ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(component);

        request.source(json, XContentType.JSON);

        IndexResponse indexResponse= client.getClient().index(request);

        System.out.println(indexResponse);

        return true;
    }

    @Override
    public List<SalaryStructureComponent> getAll() throws IOException {
        return null;
    }

    @Override
    public boolean update(SalaryStructureComponent component, String id) throws IOException {
        return false;
    }

    @Override
    public boolean delete(String id) throws IOException {
        return false;
    }

    @Override
    public SalaryStructureComponent getById(String id) throws IOException {
        return null;
    }
}
