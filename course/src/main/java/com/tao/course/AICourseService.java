package com.tao.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/11/10 22:54
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.tao.*.mapper")
public class AICourseService {
    public static void main(String[] args) {
        SpringApplication.run(AICourseService.class, args);
    }
}
