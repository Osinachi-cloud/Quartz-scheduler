package com.cymark.quartz_scheduler.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
public class QuartzConfig {

//    @Autowired
//    Environment env;
//    @Bean
//    @QuartzDataSource
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource quartzDataSource(){
////        return DataSourceBuilder.create()
////                .driverClassName("org.postgresql.Driver")
////                .url("jdbc:postgresql://localhost:5432/quartz-scheduler")
////                .username("postgres")
////                .password("1234")
////                .build();
//
////        dataSource.setDriverClassName(env.getProperty("custom.datasource.driver-class-name"));
////        dataSource.setUrl(env.getProperty("custom.datasource.url"));
////        dataSource.setUsername(env.getProperty("custom.datasource.username"));
////        dataSource.setPassword(env.getProperty("custom.datasource.password"));
//
////        return new DataSourceProperties().initializeDataSourceBuilder()
////                .driverClassName(env.getProperty("spring.datasource.driver-class-name"))
////                .url(env.getProperty("spring.datasource.url"))
////                .username(env.getProperty("spring.datasource.username"))
////                .password(env.getProperty("spring.datasource.password"))
////                .build();
//
//
//                return new DataSourceProperties()
//                        .initializeDataSourceBuilder()
//                    .driverClassName("org.postgresql.Driver")
//                    .url("jdbc:postgresql://localhost:5432/quartz-scheduler")
//                    .username("postgres")
//                    .password("1234")
//                        .type(HikariDataSource.class)
//                    .build();
//    }



    @Autowired
    Environment env;

    @Bean
    @QuartzDataSource
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource quartzDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("spring.datasource.driver-class-name"))
                .url(env.getProperty("spring.datasource.url"))
                .username(env.getProperty("spring.datasource.username"))
                .password(env.getProperty("spring.datasource.password"))
                .build();
    }
}
