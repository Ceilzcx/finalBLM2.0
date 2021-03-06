package com.example.blmuserconsumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        MybatisAutoConfiguration.class})
@EnableDubbo
public class BlmuserconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlmuserconsumerApplication.class, args);
    }

}
