package com.tao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/28 15:36
 **/

@SpringBootApplication
@EnableEurekaServer
public class Registry {

    public static void main(String[] args) {
        SpringApplication.run(Registry.class, args);
    }

}
