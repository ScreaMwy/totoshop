package org.totoshop.config.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // 相當於xml文件中的<aop:aspectj-autoproxy/>：啟用aspectj的動態代理（註解方式）
@ComponentScan(basePackages = {"org.totoshop.dao", "org.totoshop.service", "org.totoshop.aspect"})
@PropertySource(value = {"classpath:/application.properties"}, encoding = "utf-8")
public class ApplicationContextConfiguration {

}
