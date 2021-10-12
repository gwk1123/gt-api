package com.gt.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.gt.api.jp.mapper"})
@SpringBootApplication
public class GtApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GtApiApplication.class, args);
    }

}
