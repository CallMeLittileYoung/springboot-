package com.young.el.config;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.util.CollectionUtils;

/**
 * 
 * @author        Young
 * @description   手动配置Es
 * @date          2018年9月5日 下午5:27:44 
 *
 */
@Configuration
public class ConfigElasticSearch {
	
    @Value("${elasticsearch.port}")
    private int esPort;

    @Value("${elasticsearch.clustername}")
    private String esClusterName;

    @Value("#{'${elasticsearch.hosts:localhost}'.split(',')}")
    private List<String> hosts = new ArrayList<>();
    
    
    private Settings getSettingsForEs() {
        Settings settings = Settings.builder()
                .put("cluster.name", esClusterName)
                //嗅探整个集群的状态
                .put("client.transport.sniff", false).build();
        return settings;
    }
    
    @Bean
    protected Client buildClient() {
        TransportClient transportClient = new PreBuiltTransportClient(getSettingsForEs());


        if (!CollectionUtils.isEmpty(hosts)) {
            hosts.stream().forEach(h -> {
                try {
                	transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(h), esPort));
                } catch (UnknownHostException e) {
                	e.printStackTrace();
                }
            });
        }
        return transportClient;
    }
    
    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        Client client = buildClient();
        return new ElasticsearchTemplate(client);
    }
}
