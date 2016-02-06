package com.yourslife.db.hibernate5;

import java.io.IOException;
import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
@ComponentScan // looks for beans
public class RepositoryTestConfig implements TransactionManagementConfigurer {

	@Inject
	private SessionFactory sessionFactory;

	@Bean
	public DataSource dataSource() {
		return MySQLDataSource();
		// return EmbededDataSource();
	}

	public DataSource MySQLDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/yours_life");
		// ds.setUrl("jdbc:mysql://localhost:3306/testdb");
		ds.setUsername("root");
		ds.setPassword("");
		ds.setInitialSize(5);
		ds.setMaxActive(10);

		// List<String> initTestSQLScripts = new ArrayList<>();
		// initTestSQLScripts.add("drop-tables.sql");
		// initTestSQLScripts.add("classpath:schema-mysql.sql");
		// initTestSQLScripts.add("init-data.sql");
		// ds.setConnectionInitSqls(initTestSQLScripts);

		return ds;
	}

	public PlatformTransactionManager annotationDrivenTransactionManager() {
		System.out.println(sessionFactory);
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

	@Bean
	public SessionFactory sessionFactoryBean() {
		try {
			LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
			lsfb.setDataSource(dataSource());
			// lsfb.setPackagesToScan("spittr");
			lsfb.setPackagesToScan("com.yourslife"); // looks only entities
			Properties props = new Properties();
			props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
			lsfb.setHibernateProperties(props);
			lsfb.afterPropertiesSet();
			SessionFactory object = lsfb.getObject();
			return object;
		} catch (IOException e) {
			return null;
		}
	}
}
