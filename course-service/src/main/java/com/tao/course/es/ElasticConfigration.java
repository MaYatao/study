package com.tao.course.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetAddress;

/***
 ** 配置ES,支持集群
 */
@Configuration
public class ElasticConfigration {

    public final static String HOST = "192.168.183.130";
    // http请求的端口是9200，客户端是9300
    public final static int PORT = 9300;
    private TransportClient client = null;

    
    @PostConstruct
    public void initialize() throws Exception {
        Settings setting = Settings.builder()
                .put("cluster.name", "my-application")
                .put("client.transport.sniff", true)//启动嗅探功能
                .build();
        // 创建client
        client = new PreBuiltTransportClient(setting)
                .addTransportAddresses(new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));
        System.out.println("连接成功！");

    }
    
    @Bean
    public Client client() {
	   return client;
    }
    
    
    @PreDestroy
    public void destroy() {
	  if (client != null) {
	       client.close();
	   }
    }

}