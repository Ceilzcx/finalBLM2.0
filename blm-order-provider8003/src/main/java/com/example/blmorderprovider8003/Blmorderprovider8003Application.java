package com.example.blmorderprovider8003;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        MybatisAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class})
@MapperScan("com.example.blmorderprovider8003.dao.")
//@ImportResource({"classpath:tcc-transaction.xml","classpath:tcc-transaction-dubbo.xml"})
@ImportResource({"classpath:tcc-transaction.xml"})
@EnableDubbo
public class Blmorderprovider8003Application {

    public static void main(String[] args) {
        SpringApplication.run(Blmorderprovider8003Application.class, args);
    }

}
