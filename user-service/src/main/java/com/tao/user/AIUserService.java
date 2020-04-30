package com.tao.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:26
 **/
@SpringBootApplication
@MapperScan("com.tao.*.mapper")
public class AIUserService {
    public static void main(String[] args) {
        SpringApplication.run(AIUserService.class, args);

    }
}
