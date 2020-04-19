package com.tao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/28 15:55
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class AIGateway {

    public static void main(String[] args) {
        SpringApplication.run(AIGateway.class, args);
    }
}
