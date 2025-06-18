package com.cqrs.demo.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@TestConfiguration
public class AppTestConfiguration {

    private static final String ORG_H_2_DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String USERNAME = "test";
    private static final String PWD = "test";

    @Bean
    DataSource inMemoryDataSource() {

        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(ORG_H_2_DRIVER);
        dataSourceBuilder.url(URL);
        dataSourceBuilder.username(USERNAME);
        dataSourceBuilder.password(PWD);
        return dataSourceBuilder.build();
    }
}
