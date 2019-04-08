package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ElasticServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticServerApplication.class, args);
    }
}