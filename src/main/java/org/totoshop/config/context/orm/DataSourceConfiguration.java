package org.totoshop.config.context.orm;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class DataSourceConfiguration {
	private ComboPooledDataSource comboPooledDataSource;
	
	@Value("${jdbc.connection.driverClass}")
	private String driverClass;
	
	@Value("${jdbc.connection.jdbcUrl}")
	private String jdbcUrl;
	
	@Value("${jdbc.connection.username}")
	private String userName;
	
	@Value("${jdbc.connection.password}")
	private String password;
	
	@Value("${jdbc.connection.transaction.autoCommitOnClose}")
	private boolean autoCommitOnClose;
	
	@Value("${jdbc.connection.maxPoolSize}")
	private int maxPoolSize;
	
	@Value("${jdbc.connection.minPoolSize}")
	private int minPoolSize;
	
	@Bean(name = {"dataSource"}, autowire = Autowire.NO)
	@Scope(scopeName = "singleton")
	public ComboPooledDataSource comboPooledDataSource() throws PropertyVetoException {
		comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setDriverClass(driverClass);
		comboPooledDataSource.setJdbcUrl(jdbcUrl);
		comboPooledDataSource.setUser(userName);
		comboPooledDataSource.setPassword(password);
		comboPooledDataSource.setAutoCommitOnClose(autoCommitOnClose);
		comboPooledDataSource.setMaxPoolSize(maxPoolSize);
		comboPooledDataSource.setMinPoolSize(minPoolSize);
		return comboPooledDataSource;
	}
}
