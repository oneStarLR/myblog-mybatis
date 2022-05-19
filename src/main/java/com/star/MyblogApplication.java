package com.star;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching   //注解配置启用缓存
public class MyblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyblogApplication.class, args);
    }

}
