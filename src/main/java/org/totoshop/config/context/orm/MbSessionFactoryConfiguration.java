package org.totoshop.config.context.orm;

import java.io.IOException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource; // 加載.xml文件
import org.springframework.context.annotation.PropertySource; // 加載.properties文件
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = {"org.totoshop.dao"}) // 等價于在每個dao接口/實現類中使用@Mapper：作用：告訴SpringIoC這是與xxxdao-mapper.xml文件相互對應的dao層
public class MbSessionFactoryConfiguration {
	@Resource(name = "dataSource", type = DataSource.class)
	private DataSource dataSource;
	
	@Value("${mybatis.configLocation}")
	private String configLocation;
	
	@Value("${mybatis.mapperLocation}")
	private String mapperLocation;
	
	@Value("${entityPackageLocation}")
	private String entityPackage;
	
	private ResourcePatternResolver resourcePatternResolver;
	
	private SqlSessionFactoryBean sqlSessionFactory;
	
	@Bean(name = {"sessionFactory"}, autowire = Autowire.NO)
	@Scope(scopeName = "singleton")
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setConfigLocation(new ClassPathResource(configLocation));
		
		String resourcePath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperLocation;
		resourcePatternResolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactory.setMapperLocations(resourcePatternResolver.getResources(resourcePath));
		sqlSessionFactory.setTypeAliasesPackage(entityPackage);
		return sqlSessionFactory;
	}
}
