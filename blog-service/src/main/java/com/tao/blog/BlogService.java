package com.tao.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 17:07
 **/

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.tao.*.mapper")
public class BlogService {
    public static void main(String[] args) {
        SpringApplication.run(BlogService.class, args);
    }
}
