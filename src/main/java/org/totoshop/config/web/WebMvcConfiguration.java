package org.totoshop.config.web;

import java.util.List;
import java.util.Vector;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import org.totoshop.util.annotation.Values;
import org.totoshop.util.AnnotationParse;

@Configuration // 相当于<beans/>和标签中的约束，命名空间
@EnableWebMvc // 相当于xml中的<mvc:annotation-driven/>
@ComponentScan(basePackages = {"org.totoshop.web"})
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	@Value("${viewPrefix}")
	private String prefix;

	@Value("${viewSuffix}")
	private String suffix;

	@Value("${pathPattern}")
	private String pathPattern;

	@Value("${resourceLocations}")
	private String resourceLocations;

	@Value("${viewUrlPath}")
	private String viewUrlPath;

	@Value("${viewName}")
	private String viewName;

	private static final List<MediaType> SUPPORTED_MEDIA_TYPES;

	private InternalResourceViewResolver viewResolver;

	private StringHttpMessageConverter httpMessageConverter;

	private MappingJackson2HttpMessageConverter jacksonHttpMessageConverter;

	static {
		List<MediaType> mediaTypes = new Vector<MediaType>();
		mediaTypes.add(MediaType.TEXT_HTML);
		mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		SUPPORTED_MEDIA_TYPES = mediaTypes;
	}

	@Bean(name = "internalResourceViewResolver", autowire = Autowire.NO)
	@Scope(scopeName = "singleton")
	public InternalResourceViewResolver internalResourceViewResolver() {
		viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
 		viewResolver.setPrefix(prefix);
		viewResolver.setSuffix(suffix);
		viewResolver.setOrder(0);
		return viewResolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController(viewUrlPath).setViewName("forward:" + viewName);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(pathPattern).addResourceLocations(resourceLocations).resourceChain(false);
	}

	@Bean(name = {"httpMessageConverter"}, autowire = Autowire.NO)
	@Scope(scopeName = "singleton")
	public StringHttpMessageConverter stringHttpMessageConverter() {
		httpMessageConverter = new StringHttpMessageConverter();
		httpMessageConverter.setSupportedMediaTypes(SUPPORTED_MEDIA_TYPES);
		return httpMessageConverter;
	}

	@Bean(name = {"jackson2HttpMessageConverter"}, autowire = Autowire.NO)
	@Scope(scopeName = "singleton")
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		jacksonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
		jacksonHttpMessageConverter.setSupportedMediaTypes(SUPPORTED_MEDIA_TYPES);
		return jacksonHttpMessageConverter;
	}
}
