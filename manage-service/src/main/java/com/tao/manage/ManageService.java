package com.tao.manage;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.MultipartConfigElement;

/**
 * @Author tao
 * @Description //TODO
 * @date 2019/10/30 23:26
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.tao.*.mapper")
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class ManageService {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("500MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("500MB");
        return factory.createMultipartConfig();
    }

    public static void main(String[] args) {

        SpringApplication.run(ManageService.class, args);

    }

}
