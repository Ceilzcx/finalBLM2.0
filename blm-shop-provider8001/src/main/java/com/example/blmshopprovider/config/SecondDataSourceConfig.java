package com.example.blmshopprovider.config;

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
@MapperScan(basePackages = "com.example.blmshopprovider.dao.mapper2", sqlSessionTemplateRef= "secondSessionTemplate")
public class SecondDataSourceConfig {

    @Bean("secondDS")
    @Qualifier("secondDS")
    @ConfigurationProperties(prefix="spring.datasource.second")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("secondSqlSessionFactory")
    @Qualifier("secondSqlSessionFactory")
    public SqlSessionFactory getSessionFactory(@Qualifier("secondDS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean("secondTransactionManager")
    public DataSourceTransactionManager getTransactionManger(@Qualifier("secondDS") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("secondSessionTemplate")
    public SqlSessionTemplate getSessionTemplate(@Qualifier("secondSqlSessionFactory") SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }

}
