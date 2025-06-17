package com.cqrs.demo.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@TestConfiguration
public class AppTestConfiguration {

    @Bean
    DataSource inMemoryDataSource() {

        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        dataSourceBuilder.username("test");
        dataSourceBuilder.password("test");
        return dataSourceBuilder.build();
    }
}
