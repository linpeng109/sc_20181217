package com.cn;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@Log4j2
public class UserbaseServerApplication {
    public static void main(String[] args) {
        log.debug("User Server is starting....");
        SpringApplication.run(UserbaseServerApplication.class, args);
    }
}
