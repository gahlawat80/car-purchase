package com.learn2code.mycar.buy.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.learn2code.mycar.buy.app")
public class PurchaseAppConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClass}")
    private String driver;

    @Bean
    public DataSource datasource(){
        DriverManagerDataSource ds = new DriverManagerDataSource(url,username,password);
        ds.setDriverClassName(driver);
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate template = new JdbcTemplate(datasource());
        return template;
    }
}
