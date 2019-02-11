package com.springdata.springJPA.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan("com.springdata.springJPA")
@EnableJpaRepositories(basePackages = "com.springdata.springJPA.repository")
public class AppConfiguration {
	
	
	@Bean
	public DataSource datasource() {
		BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/tnt");
        dataSource.setUsername("dbadmin");
        dataSource.setPassword("Training_2018");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
		
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entitymanagerfactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        
        factoryBean.setPackagesToScan(new String[] { "com.springdata.springJPA.models" });
        //factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.hbm2ddl.auto","update");
		jpaProperties.setProperty("hibernate.show_sql", "true");
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		factoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
		factoryBean.setJpaProperties(jpaProperties);
        factoryBean.setDataSource(datasource());
		return factoryBean;

	}
	
	/*
     * Provider specific adapter.
     */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
	        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
	        return hibernateJpaVendorAdapter;
	}
	
	/*
	 * Transaction Manager
	 */
	@Bean
	@Autowired
	public JpaTransactionManager TxManager(EntityManagerFactory factoryBean) {
		JpaTransactionManager TxManager = new JpaTransactionManager();
		TxManager.setEntityManagerFactory(factoryBean);
		return TxManager;
	}
}
