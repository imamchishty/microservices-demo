package com.demo.product.domain;

import com.demo.product.domain.config.EnableProductJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by imamchishty on 23/06/2016.
 */
@SpringBootApplication
@EnableProductJpa
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("product-domain.jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("product-domain.jdbc.url"));
        dataSource.setUsername(env.getProperty("product-domain.jdbc.user"));
        dataSource.setPassword(env.getProperty("product-domain.jdbc.pass"));
        return dataSource;
    }
}
