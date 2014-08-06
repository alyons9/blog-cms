package com.lyons.blog.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lyons.blog.repository.UsersRepository;

@Configuration
@EnableJpaRepositories(basePackages = "com.lyons.blog.repository",
includeFilters = @ComponentScan.Filter(value = {UsersRepository.class}, type = FilterType.ASSIGNABLE_TYPE))
@EnableTransactionManagement
public class JPAConfiguration {

	@Bean
	public DataSource dataSource() throws SQLException{
		EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder();
		return edb.setType(EmbeddedDatabaseType.H2).build();
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() throws SQLException{
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(true);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.lyons.blog.data");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		factory.setJpaProperties(hibernateProperties());
		
		return factory.getObject();
	}
	
	@Bean
	public EntityManager entityManager(EntityManagerFactory entityManagerFactory){
		
		return entityManagerFactory.createEntityManager();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() throws SQLException{
		JpaTransactionManager jpaTxManager = new JpaTransactionManager();
		jpaTxManager.setEntityManagerFactory(entityManagerFactory());
		return jpaTxManager;
	}
	
	@Bean
	  public HibernateExceptionTranslator hibernateExceptionTranslator() {
	    return new HibernateExceptionTranslator();
	  }
	
	Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", "true");
               
            }
        };
    }
}
