package org.totoshop.config.context.orm;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement// 相當於xml文件中的<tx:annotation-driven transaction-manager=""/>
public class MbTransactionManagementConfiguration {
	@Resource(name = "dataSource", type = DataSource.class)
	private DataSource dataSource;

	private DataSourceTransactionManager transactionManagement;

	@Bean(name = "transactionManagement", autowire = Autowire.NO)
	@Scope(scopeName = "singleton")
	public DataSourceTransactionManager transactionManagement() {
		transactionManagement = new DataSourceTransactionManager(dataSource);
		return transactionManagement;
	}
}
