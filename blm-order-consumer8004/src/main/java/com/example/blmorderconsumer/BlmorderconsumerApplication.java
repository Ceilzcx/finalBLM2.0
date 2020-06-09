package com.example.blmorderconsumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        MybatisAutoConfiguration.class})
@EnableDubbo
public class BlmorderconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlmorderconsumerApplication.class, args);
    }

}
