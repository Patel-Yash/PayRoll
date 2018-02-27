package com.brevitaz.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config
{
    @Value("${Host-Name}")
    String hostName;

    private RestHighLevelClient client;
    private ObjectMapper objectMapper;

    @Bean
    public RestHighLevelClient getClient() {
        if(client == null)
        {
            client = new RestHighLevelClient
                    (RestClient.builder(
                            new HttpHost(hostName, 9200, "http")));
            return client;

        }
        else {
            return client;
        }
    }

    public void setClient(RestHighLevelClient client) {
        this.client = client;
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        if(objectMapper == null)
        {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper;
        }
        else
        {
            return objectMapper;
        }
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Config()
    {

    }
}
