package org.totoshop.config.web.fileupload;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class MultipartFileUploadConfiguration {
	private final long MAX_UPLOAD_SIZE = 60000000 * 2; // 上傳的文件的總大小
	private final long MAX_UPLOAD_SIZE_PRE_FILE = 60000000; // 上傳的每個文件的大小 
	private final String DEFAULT_ENCODING = "utf-8"; // 默認的編碼方式 
	
	private CommonsMultipartResolver multipartResolver;	
	
	@Bean(name = {"multipartResolver"}, autowire = Autowire.NO)
	@Scope(scopeName = "singleton")
	public CommonsMultipartResolver commonsMultipartResolver() {
		multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(MAX_UPLOAD_SIZE);
		multipartResolver.setMaxUploadSizePerFile(MAX_UPLOAD_SIZE_PRE_FILE);
		multipartResolver.setDefaultEncoding(DEFAULT_ENCODING);
		return multipartResolver;
	}
}
