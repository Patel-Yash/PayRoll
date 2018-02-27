package com.brevitaz.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ElasticConfig {

   /* @Value("${Host-Name}")
    String hostName;



    public RestHighLevelClient getClient() {

        if (client == null)
        {
            client = new RestHighLevelClient
                    (RestClient.builder(
                            new HttpHost(hostName, 9200, "http")));
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

*/
}
