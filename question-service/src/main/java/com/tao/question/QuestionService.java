package com.tao.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:26
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.tao.*.mapper")
public class QuestionService {
    public static void main(String[] args) {
        SpringApplication.run(QuestionService.class, args);
    }
}
