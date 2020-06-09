package com.example.blmshopprovider;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        MybatisAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class})
@MapperScan("com.example.blmshopprovider.dao.")
@EnableDubbo
public class BlmShopProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlmShopProviderApplication.class, args);
    }

}
