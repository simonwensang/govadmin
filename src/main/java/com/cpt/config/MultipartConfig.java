package com.cpt.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipartConfig {
	 @Bean
	public MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory factory   = new MultipartConfigFactory();
		factory.setMaxFileSize(10*1024L*1024L);
		factory.setMaxRequestSize(100*1024L*1024L);
		return factory.createMultipartConfig();
	} 
	/*@Bean
	public MultipartResolver multipartResolver(){
		 
		return new CommonsMultipartResolver();
	}*/
}
