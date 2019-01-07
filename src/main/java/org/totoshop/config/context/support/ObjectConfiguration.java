package org.totoshop.config.context.support;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.totoshop.util.multipart.FileTransfer;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

@Configuration
public class ObjectConfiguration {
	private FileTransfer fileTransfer;
	
	@Bean(name = {"fileTransfer"}, autowire = Autowire.NO)
	@Scope(scopeName = "singleton")
	public FileTransfer fileTransfer() {
		fileTransfer = new FileTransfer();
		return (null != fileTransfer) ? fileTransfer : fileTransfer();
	}
}
