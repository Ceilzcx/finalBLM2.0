package com.example.blmuserprovider.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.example.blmshopprovider.dao.mapper", sqlSessionTemplateRef = "firstSessionTemplate")
public class FirstDataSourceConfig {

    @Bean("firstDS")
    @Qualifier("firstDS")
    @ConfigurationProperties(prefix="spring.datasource.first")
    @Primary
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("firstSqlSessionFactory")
    @Qualifier("firstSqlSessionFactory")
    @Primary
    public SqlSessionFactory getSessionFactory(@Qualifier("firstDS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean("firstTransactionManager")
    @Primary
    public DataSourceTransactionManager getTransactionManger(@Qualifier("firstDS") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("firstSessionTemplate")
    @Primary
    public SqlSessionTemplate getSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }

}

