package org.totoshop.config.context.orm;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Spring的鏈接數據庫的Configuration類
 */
@Configuration
public class DataSourceConfiguration {
	private ComboPooledDataSource comboPooledDataSource;

    /**
     * 數據庫驅動類
     */
	@Value("${jdbc.connection.driverClass}")
	private String driverClass;

    /**
     * 數據庫的鏈接URI
     */
	@Value("${jdbc.connection.jdbcUrl}")
	private String jdbcUrl;

    /**
     * 數據庫的用戶名
     */
	@Value("${jdbc.connection.username}")
	private String userName;

    /**
     * 數據庫的密碼
     */
	@Value("${jdbc.connection.password}")
	private String password;

    /**
     * 事務自動提交的配置參數
     */
	@Value("${jdbc.connection.transaction.autoCommitOnClose}")
	private boolean autoCommitOnClose;

    /**
     * 數據庫連接池的最大連接數
     */
	@Value("${jdbc.connection.maxPoolSize}")
	private int maxPoolSize;

    /**
     * 數據庫連接池的最小連接數
     */
	@Value("${jdbc.connection.minPoolSize}")
	private int minPoolSize;

    /**
     * 配置一個數據庫連接池的Bean（連接池使用c3p0）
     * @return ComboPooledDataSource
     * @throws PropertyVetoException
     */
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
