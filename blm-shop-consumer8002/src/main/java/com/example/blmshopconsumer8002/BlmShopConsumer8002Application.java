package com.example.blmshopconsumer8002;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        MybatisAutoConfiguration.class})
@EnableDubbo
public class BlmShopConsumer8002Application {

    public static void main(String[] args) {
        SpringApplication.run(BlmShopConsumer8002Application.class, args);
    }

}
