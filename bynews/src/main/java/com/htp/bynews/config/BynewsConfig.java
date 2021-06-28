package com.htp.bynews.config;

import java.util.Properties;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db_settings.properties")
@EnableTransactionManagement
@ComponentScans(value = {
		@ComponentScan(basePackages = "com.htp.bynews.service"),
		@ComponentScan(basePackages = "com.htp.bynews.dao") 
		})
public class BynewsConfig {
	
	@Autowired
	private Environment env;
	
	  @Bean
	  public SessionFactory  sessionFactory() {
	      
		  LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
	      builder.scanPackages("com.htp.bynews.entity").addProperties(hibernateProperties());
	      return builder.buildSessionFactory();
	  }

	  @Bean
	  public AbstractDataSource dataSource() {
	      
		  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName(env.getRequiredProperty("mysql.driver"));
	      dataSource.setUrl(env.getRequiredProperty("mysql.jdbcUrl"));
	      dataSource.setUsername(env.getRequiredProperty("mysql.username"));
	      dataSource.setPassword(env.getRequiredProperty("mysql.password"));
	      return dataSource;
	  }

	  private Properties hibernateProperties() {
	      Properties properties = new Properties();
	      properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	      properties.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
	      properties.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
	      
	      // Setting C3P0 properties
	      properties.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
	      properties.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
	      properties.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
	      properties.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
	      properties.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
	      
	      return properties;
	  }

	  @Bean
	  public HibernateTransactionManager txManager() {
	      return new HibernateTransactionManager(sessionFactory());
	  }	  
	  
}