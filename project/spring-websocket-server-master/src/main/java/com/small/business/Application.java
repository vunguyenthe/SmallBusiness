package com.small.business;

import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import liquibase.integration.spring.SpringLiquibase;

/*
 * @Author Jay Sridhar
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @Autowired
    private Environment env;
    
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }
    
    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource());
        liquibase.setChangeLog("classpath:dbchange/master.xml");
        return liquibase;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(env.getProperty("spring.http.multipart.maxFileSize"));
        factory.setMaxRequestSize(env.getProperty("spring.http.multipart.maxRequestSize"));
        return factory.createMultipartConfig();
    }    
}
