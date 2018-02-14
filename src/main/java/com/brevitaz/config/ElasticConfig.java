package com.brevitaz.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Component;

@Component
public class ElasticConfig {


    public RestHighLevelClient getClient() {

        if (client == null)
        {
            client = new RestHighLevelClient
                    (RestClient.builder(
                            new HttpHost("localhost", 9200, "http")));
            return client;
        }
        else
        {
            return client;
        }

    }

    public void setClient(RestHighLevelClient client) {
        this.client = client;
    }

    private RestHighLevelClient client;


}
